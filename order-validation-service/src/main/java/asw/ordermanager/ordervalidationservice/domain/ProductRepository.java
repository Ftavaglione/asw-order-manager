package asw.ordermanager.ordervalidationservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {


    public Collection<Product> findByNameIn(List<String> names);
}
