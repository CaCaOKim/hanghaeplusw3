package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.Order;
import hhplusw3.ecommerce.domain.model.OrderProduct;
import hhplusw3.ecommerce.domain.model.TranscationType;
import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.OrderRepository;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderModifier {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderModifier(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order orderProducts(Order order) {
        Order result = this.orderRepository.orderProducts(order);
        List<OrderProduct> resultProducts = new ArrayList<>();
        for (OrderProduct orderProduct : order.orderProducts()) {
            resultProducts.add(this.orderRepository.orderProduct(orderProduct));
        }
        return new Order(result.id(), result.userId(), result.userNm(), result.totalPrice(), result.status(), resultProducts);
    }
}
