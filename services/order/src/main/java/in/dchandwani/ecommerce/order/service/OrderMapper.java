package in.dchandwani.ecommerce.order.service;

import in.dchandwani.ecommerce.order.model.Order;
import in.dchandwani.ecommerce.order.request.OrderRequest;
import in.dchandwani.ecommerce.order.response.OrderResponse;
import org.springframework.stereotype.Service;


@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
