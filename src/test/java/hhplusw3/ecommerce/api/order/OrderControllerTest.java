package hhplusw3.ecommerce.api.order;

import hhplusw3.ecommerce.api.order.dto.OrderRes;
import hhplusw3.ecommerce.api.product.ProductController;
import hhplusw3.ecommerce.api.user.dto.UserRes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    OrderController orderController;

    OrderControllerTest() {
        this.orderController = new OrderController();
    }

    long userId = 1;

    @Test
    void order() throws InterruptedException {
        List<Long> productIds = Arrays.asList(1L, 2L, 3L);

        OrderRes order = this.orderController.order(userId, productIds);

        assertThat(order.id()).isEqualTo(1);
        assertThat(order.userId()).isEqualTo(userId);
        assertThat(order.totalPrice()).isEqualTo(51000);
        assertThat(order.status()).isEqualTo("complete");
    }

    @Test
    void userId가_유실되면_주문_실패() throws InterruptedException {
        List<Long> productIds = Arrays.asList(1L, 2L, 3L);

        assertThatThrownBy(() -> {
            OrderRes order = this.orderController.order(0, productIds);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 상품이_품절된_경우_주문실패() throws InterruptedException {
        List<Long> productIds = Arrays.asList(10004L);

        assertThatThrownBy(() -> {
            OrderRes order = this.orderController.order(userId, productIds);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 유저의_잔액이_부족한_경우_주문실패() throws InterruptedException {
        List<Long> productIds = Arrays.asList(10001L, 10002L, 10003L);

        assertThatThrownBy(() -> {
            OrderRes order = this.orderController.order(1235, productIds);
        }).isInstanceOf(RuntimeException.class);
    }
}