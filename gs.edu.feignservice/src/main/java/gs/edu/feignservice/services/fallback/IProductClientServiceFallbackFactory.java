package gs.edu.feignservice.services.fallback;

import feign.hystrix.FallbackFactory;
import gs.edu.feignservice.services.IProductClientService;
import gs.edu.serviceapi.vo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            public Object getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return  product;

            }

            public List<Product> listProduct() {
                return null;
            }

            public Object addPorduct(Product product) {
                return null;
            }
        };
    }
}
