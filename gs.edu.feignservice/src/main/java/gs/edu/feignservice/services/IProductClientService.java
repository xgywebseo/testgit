package gs.edu.feignservice.services;

import gs.edu.feignservice.config.FeignConfig;
import gs.edu.feignservice.services.fallback.IProductClientServiceFallbackFactory;
import gs.edu.serviceapi.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "GS-EDU-PROVIDER-PRODUCT",configuration = FeignConfig.class,fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {

    @RequestMapping("/prodcut/get/{id}")
    Object getProduct(@PathVariable("id") long id) ;

    @RequestMapping("/prodcut/list")
    List<Product> listProduct();
    /*  @RequestMapping("/prodcut/list")
      List<Product> listProduct() ;*/

    @RequestMapping("/prodcut/add")
    Object addPorduct(Product product);

 /*   @RequestMapping("/prodcut/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/prodcut/list")
    public List<Product> listProduct() ;

    @RequestMapping("/prodcut/add")
    public boolean addPorduct(Product product) ;*/


}
