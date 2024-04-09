package hhplusw3.ecommerce.infrastructure;

import hhplusw3.ecommerce.domain.model.User;
import hhplusw3.ecommerce.domain.reository.UserRepository;

public class UserRepositoryMybatis implements UserRepository {
    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public User chargeMoney(long amount) {
        return null;
    }
}
