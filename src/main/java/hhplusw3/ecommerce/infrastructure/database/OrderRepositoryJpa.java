package hhplusw3.ecommerce.infrastructure.database;

import hhplusw3.ecommerce.domain.model.Order;
import hhplusw3.ecommerce.domain.model.OrderProduct;
import hhplusw3.ecommerce.domain.reository.OrderRepository;
import hhplusw3.ecommerce.infrastructure.entity.OrderEntity;
import hhplusw3.ecommerce.infrastructure.entity.OrderProductEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderRepositoryJpa implements OrderRepository {
    private final EntityManager em;

    public OrderRepositoryJpa(EntityManager em) {
        this.em = em;
    }


    @Override
    public Order getOrder(long id) {
        OrderEntity orderEntity = em.find(OrderEntity.class, id);
        return new Order(orderEntity.getId(), orderEntity.getUserId(), orderEntity.getUser().getName(), orderEntity.getTotalPrice(), orderEntity.getStatus(), this.getOrderProducts(orderEntity.getId()));
    }

    @Override
    public Order order(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(order.userId());
        orderEntity.setTotalPrice(order.totalPrice());
        orderEntity.setStatus(order.status());
        em.persist(orderEntity);
        if (orderEntity.getId() <= 0) {
            order = new Order(0, 0, null, 0, null, null);
        }
        return order;
    }

    @Override
    public List<OrderProduct> getOrderProducts(long orderId) {
        String query = "select p from OrderProductEntity p where p.order_id = :orderId";
        List<OrderProductEntity> orderProductEntities = em.createQuery(query, OrderProductEntity.class)
                .setParameter("orderId", orderId)
                .getResultList();
        return orderProductEntities.stream().map(p -> new OrderProduct(p.getId(), p.getOrderId(), p.getProductId(), p.getProduct().getName(), p.getCount(), p.getStatus())).toList();
    }

    @Override
    public OrderProduct orderProduct(OrderProduct orderProduct) {
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderId(orderProduct.orderId());
        orderProductEntity.setProductId(orderProduct.productId());
        orderProductEntity.setCount(orderProduct.count());
        orderProductEntity.setStatus(orderProduct.status());
        em.persist(orderProductEntity);
        if (orderProductEntity.getId() <= 0) {
            orderProduct = new OrderProduct(0, 0, 0, null, 0, null);
        }
        return orderProduct;
    }
}
