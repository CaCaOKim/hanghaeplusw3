package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.Order;
import hhplusw3.ecommerce.domain.model.TranscationType;
import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.OrderRepository;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderModifier {

    OrderRepository orderRepository;

    @Autowired
    public OrderModifier(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order order() {
        return null;
    }
}
