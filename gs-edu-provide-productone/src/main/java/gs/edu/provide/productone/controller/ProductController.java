package gs.edu.provide.productone.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import gs.edu.provide.productone.services.IProductService;
import gs.edu.serviceapi.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prodcut")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {
        Product product = this.iProductService.get(id);
        if(product==null) throw  new RuntimeException("该产品已下架！");
        return  product;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }
    @RequestMapping(value="/discover")
    public Object discover() {
        return discoveryClient;
    }
    public Object  getFallback(@PathVariable("id") long id){
        Product product = new Product();
        product.setProductName("HystrixName11111111");
        product.setProductDesc("HystrixDesc1111111111");
        product.setProductId(0L);
        return product;
    }


}
