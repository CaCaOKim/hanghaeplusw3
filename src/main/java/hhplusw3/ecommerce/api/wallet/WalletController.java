package hhplusw3.ecommerce.api.wallet;

import hhplusw3.ecommerce.api.wallet.dto.UserRes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
public class WalletController {

    // 잔액 조회
    @GetMapping("/{id}")
    public UserRes ficdById(@PathVariable long id) throws InterruptedException {
        return null;
    }

    @PostMapping("/{id}")
    public UserRes charge(@PathVariable long lectureNo, @RequestBody long amount) throws InterruptedException {
        return null;
    }

}
