package hhplusw3.ecommerce.api.user.useCase;

import hhplusw3.ecommerce.api.user.dto.UserRes;

public class ChargeMoneyUseCase {

    public UserRes excute() {
        return new UserRes(1234, "david", 3000);
    }
}
