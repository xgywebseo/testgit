package gs.edu.provide.productone.mapper;

import gs.edu.serviceapi.vo.Product;

import java.util.List;

public interface ProductMapper {
    /**
     *
     * @param product
     * @return
     */
    boolean create(Product product);

    /**
     *
     * @param id
     * @return
     */
    public Product findById(Long id);

    /**
     *
     * @return
     */
    public List<Product> findAll();

}

