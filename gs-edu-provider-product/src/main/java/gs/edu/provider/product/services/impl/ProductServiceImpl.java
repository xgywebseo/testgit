package gs.edu.provider.product.services.impl;

import gs.edu.provider.product.mapper.ProductMapper;
import gs.edu.provider.product.services.IProductService;
import gs.edu.serviceapi.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product get(long id) {
        return productMapper.findById(id);
    }

    public boolean add(Product product) {
        return  productMapper.create(product);
    }

    public List<Product> list() {
        return productMapper.findAll();
    }
}
