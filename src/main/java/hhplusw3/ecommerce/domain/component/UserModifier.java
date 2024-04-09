package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserModifier {

    UserRepository userRepository;

    @Autowired
    public UserModifier(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User chargeMoney(long id, long amount) {
        return null;
    }
}
