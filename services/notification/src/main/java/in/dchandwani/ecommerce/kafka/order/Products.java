package in.dchandwani.ecommerce.kafka.order;

import java.math.BigDecimal;

public record Products(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
){
}
