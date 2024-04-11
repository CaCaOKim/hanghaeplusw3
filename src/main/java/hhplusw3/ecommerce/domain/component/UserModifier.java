package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModifier {

    UserRepository userRepository;

    @Autowired
    public UserModifier(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.id());
        userEntity.setName(user.name());
        userEntity.setMoney(user.money());
        UserEntity result = this.userRepository.saveUser(userEntity);
        return new User(result.getId(), result.getName(), result.getMoney());
//        return new User(userEntity.getId(), userEntity.getName(), userEntity.getMoney());
    }
}
