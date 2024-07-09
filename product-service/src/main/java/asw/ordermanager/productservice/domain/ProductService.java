package asw.ordermanager.productservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import asw.ordermanager.api.event.ProductCreatedEvent;
import asw.ordermanager.api.event.UpdateStockLevelEvent;
import asw.ordermanager.common.api.event.DomainEvent;
import java.util.logging.Logger;
import java.util.*; 

@Service
public class ProductService {

	private final Logger logger = Logger.getLogger(this.getClass().toString());																		
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductEventPublisher productEventPublisher;	   
 	public Product createProduct(String name, String category, int stockLevel, double price) {
		Product product = new Product(name, category, stockLevel, price); 
		product = productRepository.save(product);
		DomainEvent event = new ProductCreatedEvent(product.getName(), product.getCategory(), product.getStockLevel(), product.getPrice());
		productEventPublisher.publish(event);
		logger.info("prodotto creato correttamente");									   
		return product;
	}

 	public Product getProduct(String name) {
		Product product = productRepository.findById(name).orElse(null);
		return product;
	}

	public Collection<Product> getProducts() {
		Collection<Product> products = productRepository.findAll();
		return products;
	}

	public Collection<Product> getProductsByCategory(String category) {
		Collection<Product> products = productRepository.findByCategory(category);
		return products;
	}	

	public Collection<Product> getProductsByNames(List<String> names) {
		Collection<Product> products = productRepository.findByNameIn(names);
		return products;
	}	

 	public Product updateProductStockLevel(String name, int stockLevelVariation) {
		Product product = getProduct(name); 
		product.setStockLevel(product.getStockLevel() + stockLevelVariation);
		product = productRepository.save(product);
		
		DomainEvent event = new UpdateStockLevelEvent(product.getName(), stockLevelVariation);
		productEventPublisher.publish(event);																														   
		logger.info("prodotto aggiornato correttamente");									   
		return product;
	}

}
