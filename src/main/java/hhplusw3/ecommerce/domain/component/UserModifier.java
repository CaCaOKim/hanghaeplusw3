package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.TranscationType;
import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModifier {

    private final UserRepository userRepository;
    private final UserReader userReader;

    @Autowired
    public UserModifier(UserRepository userRepository, UserReader userReader) {
        this.userRepository = userRepository;
        this.userReader = userReader;
    }

    public User updateUser(User user) {
        User result = this.userRepository.updateUser(user);
        return result;
    }

    public User calculateMoney(long id, long amount, TranscationType type) {
        User user = this.userReader.getUser(id);
        long money = user.money();
        if (type == TranscationType.CHARGE) {
            money += amount;
        } else if (type == TranscationType.USE) {
            money -= amount;
        }
        User result = this.updateUser(new User(user.id(), user.name(), money));
        return result;
    }
}
