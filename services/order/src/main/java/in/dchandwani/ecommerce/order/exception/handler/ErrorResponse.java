package in.dchandwani.ecommerce.order.exception.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> error) {
}
