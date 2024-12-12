package in.dchandwani.ecommerce.order.service;

import in.dchandwani.ecommerce.order.customer.CustomerClient;
import in.dchandwani.ecommerce.order.exception.BusinessException;
import in.dchandwani.ecommerce.kafka.order.OrderConfirmation;
import in.dchandwani.ecommerce.kafka.order.OrderProducer;
import in.dchandwani.ecommerce.order.payment.PaymentClient;
import in.dchandwani.ecommerce.order.payment.PaymentRequest;
import in.dchandwani.ecommerce.order.product.ProductClient;
import in.dchandwani.ecommerce.order.product.request.PurchaseRequest;
import in.dchandwani.ecommerce.order.repository.OrderRepository;
import in.dchandwani.ecommerce.order.request.OrderLineRequest;
import in.dchandwani.ecommerce.order.request.OrderRequest;
import in.dchandwani.ecommerce.order.response.OrderResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {

        // check customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: Customer not found: " + request.customerId()));

        // purchase product using purchase-service, here we can use either OpenFeign or RestTemplate
        // Lets go with RestTemplate
        var purchaseProducts = this.productClient.purchaseProducts(request.products());

        // persist order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        // persist orderLines
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(new OrderLineRequest(null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()
            ));
        }

        // start payment
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        // send order confirmation to notification-service (kafka broker)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided id %d", orderId)));
    }
}
