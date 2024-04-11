package hhplusw3.ecommerce.infrastructure.database;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;

public class UserRepositoryMybatis implements UserRepository {
    @Override
    public UserEntity getUser(long id) {
        return null;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return null;
    }
}
