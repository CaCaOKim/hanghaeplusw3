package hhplusw3.ecommerce.api.product;

import hhplusw3.ecommerce.api.order.dto.OrderRes;
import hhplusw3.ecommerce.api.product.dto.ProductRes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TopProductControllerTest {

    TopProductController topProductController;

    TopProductControllerTest() {
        this.topProductController = new TopProductController();
    }

    @Test
    void getTopProducts() throws InterruptedException {
        long topNum = 5;
        List<ProductRes> products = this.topProductController.getTopProducts(topNum, "N");

        assertThat(products.size()).isEqualTo(topNum);
        assertThat(products.get(0).id()).isEqualTo(10001);
        assertThat(products.get(1).id()).isEqualTo(10002);
        assertThat(products.get(2).id()).isEqualTo(10003);
        assertThat(products.get(3).id()).isEqualTo(10004);
        assertThat(products.get(4).id()).isEqualTo(10005);
    }
}