package hhplusw3.ecommerce.api.order.useCase;


import hhplusw3.ecommerce.api.order.dto.OrderRes;
import hhplusw3.ecommerce.api.product.dto.ProductRes;
import hhplusw3.ecommerce.domain.component.OrderModifier;
import hhplusw3.ecommerce.domain.component.ProductReader;
import hhplusw3.ecommerce.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCase {

    OrderModifier orderModifier;

    @Autowired
    public OrderUseCase(OrderModifier orderModifier) {
        this.orderModifier = orderModifier;
    }

    public OrderRes excute(long id) {
        return new OrderRes(0, 0, null, 0, null, null);
    }
}
