package App;

import App.Enitities.Product;
import App.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    };
    @GetMapping
    public List<Product> getAllProducts(){
      return productService.getAllProducts();
    };
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return  productService.getProductById(id);
    };
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product){
      productService.updateProduct(id, product);
    };
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }




}
