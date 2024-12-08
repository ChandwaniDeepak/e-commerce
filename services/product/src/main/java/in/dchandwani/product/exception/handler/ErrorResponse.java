package in.dchandwani.product.exception.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> error) {
}
