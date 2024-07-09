package asw.ordermanager.ordervalidationservice.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

	private final Logger logger = Logger.getLogger(this.getClass().toString());																		
	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(String name,  int stockLevel) {
		
		Product product = new Product(name, stockLevel);
		productRepository.save(product);
		logger.info("prodotto salvato correttamente");										  
		return product;
	}


 	public Product getProduct(String name) {
		Product product = productRepository.findById(name).orElse(null);
		return product;
	}

	public Product updateProductStockLevel(String name, int stockLevelVariation) {
		Product product = getProduct(name); 
		product.setStockLevel(product.getStockLevel() + stockLevelVariation);
		product = productRepository.save(product);
		return product;
	}

	public List<Product> getProductsByNames(List<String> names) {
		List<Product> products = (List<Product>) productRepository.findByNameIn(names);
		return products;
	}


}
