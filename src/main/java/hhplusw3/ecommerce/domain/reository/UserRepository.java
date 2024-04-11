package hhplusw3.ecommerce.domain.reository;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;

public interface UserRepository {
    public UserEntity getUser(long id);
    public UserEntity saveUser(UserEntity userEntity);
}
