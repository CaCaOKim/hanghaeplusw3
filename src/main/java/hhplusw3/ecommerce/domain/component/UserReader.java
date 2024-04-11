package hhplusw3.ecommerce.domain.component;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserReader {

    UserRepository userRepository;

    @Autowired
    public UserReader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(long id) {
        if (id == 0) {
            throw new RuntimeException("로그인 정보가 유실되었습니다.");
        }
        UserEntity userEntity = this.userRepository.getUser(id);
        if (userEntity == null) {
            userEntity = new UserEntity();
        }
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getMoney());
    }
}
