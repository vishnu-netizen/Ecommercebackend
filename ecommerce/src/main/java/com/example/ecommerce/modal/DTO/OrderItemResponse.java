package com.example.ecommerce.modal.DTO;

import java.math.BigDecimal;

public record OrderItemResponse(String productName, int Quantity, BigDecimal totalPrice) {
}
