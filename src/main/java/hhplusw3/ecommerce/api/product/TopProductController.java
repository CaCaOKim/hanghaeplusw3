package hhplusw3.ecommerce.api.product;

import hhplusw3.ecommerce.api.product.dto.ProductRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class TopProductController {

    // 상위 상품 조회
    @GetMapping("/top")
    public List<ProductRes> getTopProducts(@RequestBody long topNum, @RequestBody String soldOutYn) throws InterruptedException {
        return List.of(
                new ProductRes(10001, "bottle1", 10000, 10, 500),
                new ProductRes(10002, "bottle2", 11000, 10, 400),
                new ProductRes(10003, "bottle3", 12000, 10, 300),
                new ProductRes(10004, "bottle4", 13000, 10, 200),
                new ProductRes(10005, "bottle5", 14000, 10, 100)
        );
    }

}
