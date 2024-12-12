package in.dchandwani.ecommerce.order.service;

import in.dchandwani.ecommerce.order.model.Order;
import in.dchandwani.ecommerce.order.model.OrderLine;
import in.dchandwani.ecommerce.order.request.OrderLineRequest;
import in.dchandwani.ecommerce.order.response.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .productId((request.productId()))
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {{
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
    }
}
