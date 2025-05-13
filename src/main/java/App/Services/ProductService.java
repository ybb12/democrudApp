package App.Services;

import App.Enitities.Product;
import App.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void createProduct(Product product){
        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.getReferenceById(id);
    }

    public void updateProduct(Long id, Product productDetails){
        if (productRepository.findById(id).isEmpty()) {
            return;
        }        productRepository.save(productDetails);
    }

    public void deleteProduct(Long id){
        if (productRepository.findById(id).isEmpty()) {
            return;
        }
        productRepository.delete(productRepository.findById(id).get());
    }

}
