package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.TranscationType;
import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModifier {

    UserRepository userRepository;
    UserReader userReader;

    @Autowired
    public UserModifier(UserRepository userRepository, UserReader userReader) {
        this.userRepository = userRepository;
        this.userReader = userReader;
    }

    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.id());
        userEntity.setName(user.name());
        userEntity.setMoney(user.money());
        UserEntity result = this.userRepository.saveUser(userEntity);
        return new User(result.getId(), result.getName(), result.getMoney());
    }

    public User calculateMoney(long id, long amount, TranscationType type) {
        User user = this.userReader.getUser(id);
        long money = user.money();
        if (type == TranscationType.CHARGE) {
            money += amount;
        } else if (type == TranscationType.USE) {
            money -= amount;
        }
        User result = this.saveUser(new User(user.id(), user.name(), money));
        return result;
    }
}
