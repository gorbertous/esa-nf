package eu.europa.ec.estat.esa.repository;

import eu.europa.ec.estat.esa.entity.ListItem;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabrix
 */
public interface ListItemRepository extends CrudRepository<ListItem, Integer>  {
	
}
