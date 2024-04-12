package hhplusw3.ecommerce.domain.reository;

import hhplusw3.ecommerce.domain.model.Product;
import hhplusw3.ecommerce.infrastructure.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    public Product getProduct(long id);

    public List<Product> getTopProducts(long topNum, String soldOutYn);

}
