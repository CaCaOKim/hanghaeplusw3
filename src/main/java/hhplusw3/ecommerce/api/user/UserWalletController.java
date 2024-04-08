package hhplusw3.ecommerce.api.user;

import hhplusw3.ecommerce.api.user.dto.UserRes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/wallet")
public class UserWalletController {

    // 잔액 조회
    @GetMapping("/{id}")
    public UserRes getUserWallet(@PathVariable long id) throws InterruptedException {
        return new UserRes(id, "robert", 30000);
    }

    // 잔액 충전
    @PostMapping("/{id}")
    public UserRes chargeUserWallet(@PathVariable long id, @RequestBody long amount) throws InterruptedException {
        return new UserRes(id, "robert", 30000 + amount);
    }

}
