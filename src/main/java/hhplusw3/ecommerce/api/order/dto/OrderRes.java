package hhplusw3.ecommerce.api.order.dto;


public record OrderRes(
        long id,
        long userId,
        long totalPrice,
        String payYn
) {
}
