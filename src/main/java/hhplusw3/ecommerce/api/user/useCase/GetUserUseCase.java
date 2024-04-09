package hhplusw3.ecommerce.api.user.useCase;

import hhplusw3.ecommerce.api.user.dto.UserRes;
import hhplusw3.ecommerce.domain.component.UserModifier;
import hhplusw3.ecommerce.domain.component.UserReader;
import hhplusw3.ecommerce.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GetUserUseCase {

    UserReader userReader;
    UserModifier userModifier;

    @Autowired
    public GetUserUseCase(UserReader userModifieruserReader, UserModifier userModifier) {
        this.userReader = userReader;
        this.userModifier = userModifier;
    }

    public UserRes getUserWallet(long id) {
        User user = this.userReader.getUser(id);
        if (user == null) {
            user = new User();
        }
        return new UserRes(user.getId(), user.getName(), user.getMoney());
    }
}
