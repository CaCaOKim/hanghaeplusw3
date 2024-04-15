package hhplusw3.ecommerce.api.order.useCase;


import hhplusw3.ecommerce.api.order.dto.OrderProductReq;
import hhplusw3.ecommerce.api.order.dto.OrderProductRes;
import hhplusw3.ecommerce.api.order.dto.OrderRes;
import hhplusw3.ecommerce.domain.component.*;
import hhplusw3.ecommerce.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderProductsUseCase {

    private final OrderModifier orderModifier;
    private final ProductReader productReader;
    private final ProductModifier productModifier;
    private final UserReader userReader;
    private final UserModifier userModifier;

    @Autowired
    public OrderProductsUseCase(OrderModifier orderModifier, ProductReader productReader, ProductModifier productModifier, UserReader userReader, UserModifier userModifier) {
        this.orderModifier = orderModifier;
        this.productReader = productReader;
        this.productModifier = productModifier;
        this.userReader = userReader;
        this.userModifier = userModifier;
    }

    public OrderRes excute(long userId, List<OrderProductReq> orderProdutReqs) {
        List<Product> products = new ArrayList<>();
        List<OrderProduct> orderProducts = new ArrayList<>();
        long totalPrice = 0;
        for (OrderProductReq orderProductReq : orderProdutReqs) {
            Product product = this.productReader.getProduct(orderProductReq.productId());
            if (product.stock() > 0) {
                totalPrice += product.price();
                products.add(new Product(product.id(), product.name(), product.price(), product.stock() - orderProductReq.count(), product.sales() + orderProductReq.count()));
                orderProducts.add(new OrderProduct(0, 0, orderProductReq.productId(), product.name(), orderProductReq.count(), "ready"));
            }
        }
        User user = this.userReader.getUser(userId);
        if (user.money() < totalPrice) {
            throw new RuntimeException("잔액이 부족합니다.");
        }
        if (totalPrice == 0) {
            throw new RuntimeException("제품들이 모두 품절되었습니다.");
        }
        for (Product product : products) {
            this.productModifier.updateProduct(product);
        }
        Order order = this.orderModifier.orderProducts(new Order(0, userId, null, totalPrice, "ready", orderProducts));
        List<OrderProductRes> orderProductResies = order.orderProducts().stream().map(p -> new OrderProductRes(p.id(), p.orderId(), p.productId(), p.productNm(), p.count(), p.status())).toList();
        this.userModifier.calculateMoney(order.userId(), order.totalPrice(), TranscationType.USE);
        return new OrderRes(order.id(), order.userId(), order.userNm(), order.totalPrice(), order.status(), orderProductResies);
    }
}
