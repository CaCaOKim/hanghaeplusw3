package hhplusw3.ecommerce.domain.reository;

import hhplusw3.ecommerce.domain.model.User;

public interface WalletRepository {
    User findById(long id);
    User charge(long amount);
}
