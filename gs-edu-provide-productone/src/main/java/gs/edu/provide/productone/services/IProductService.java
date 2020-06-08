package gs.edu.provide.productone.services;

import gs.edu.serviceapi.vo.Product;

import java.util.List;

public interface IProductService {
    /**
     *
     * @param id
     * @return
     */
    Product get(long id);

    /**
     *
     * @param product
     * @return
     */
    boolean add(Product product);

    /**
     *
     * @return
     */
    List<Product> list();

}
