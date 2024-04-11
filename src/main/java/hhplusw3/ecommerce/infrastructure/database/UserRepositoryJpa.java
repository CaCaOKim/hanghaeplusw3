package hhplusw3.ecommerce.infrastructure.database;

import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.entity.UserEntity;
import jakarta.persistence.EntityManager;

public class UserRepositoryJpa implements UserRepository {
    private final EntityManager em;

    public UserRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserEntity getUser(long id) {
        UserEntity user = em.find(UserEntity.class, id);
        return user;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        UserEntity result = em.merge(userEntity);
        return result;
    }

}
