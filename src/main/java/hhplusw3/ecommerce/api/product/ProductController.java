package hhplusw3.ecommerce.api.product;

import hhplusw3.ecommerce.api.product.dto.ProductRes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    // 상품 조회
    @GetMapping("/{id}")
    public ProductRes getProduct(@PathVariable long id) throws InterruptedException {
        return new ProductRes(id, "bottle", 10000, 30, 10);
    }

}
