package hhplusw3.ecommerce.api.product;

import hhplusw3.ecommerce.api.product.dto.ProductRes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductControllerTest {

    ProductController productController;

    ProductControllerTest() {
        this.productController = new ProductController();
    }

    long id = 10001;

    @Test
    void getProduct() throws InterruptedException {
        ProductRes product = this.productController.getProduct(id);

        assertThat(product.id()).isEqualTo(id);
        assertThat(product.name()).isEqualTo("bottle");
        assertThat(product.price()).isEqualTo(10000);
        assertThat(product.stock()).isEqualTo(30);
        assertThat(product.sales()).isEqualTo(10);
    }
}