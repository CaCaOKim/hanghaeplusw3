package hhplusw3.ecommerce.api.order;

import hhplusw3.ecommerce.api.order.dto.OrderRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    // 주문
    @PostMapping("/{userId}")
    public OrderRes order(@PathVariable long userId, @RequestBody List<Long> productIds) throws InterruptedException {
        return null;
    }

}
