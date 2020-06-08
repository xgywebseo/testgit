package gs.edu.consumer.feign.controller;

import gs.edu.feignservice.services.IProductClientService;
import gs.edu.serviceapi.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
/*    public static final String PRODUCT_GET_URL = "http://GS-EDU-PROVIDER-PRODUCT/prodcut/get/";
    public static final String PRODUCT_LIST_URL="http://GS-EDU-PROVIDER-PRODUCT/prodcut/list/";
    public static final String PRODUCT_ADD_URL = "http://GS-EDU-PROVIDER-PRODUCT/prodcut/add/";*/

    @Autowired
    private IProductClientService iProductClientService;
    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        //Object product = iProductClientService.getProduct(id);
        // Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
        //Product Product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        //return  Product;
        return iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        //List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
       /* List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;*/
        Object o = iProductClientService.listProduct();
        return o;
        //return  iProductClientService.listProduct();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        //Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
       /* Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
        return  result;*/
       return  iProductClientService.addPorduct(product);
    }



}
