package eu.europa.ec.estat.esa.repository;

import eu.europa.ec.estat.esa.entity.Heading;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabrix
 */
public interface HeadingRepository extends CrudRepository<Heading, Integer> {

	List<Heading> findByParentIdIsNull();
	
	Heading findByHeadingId(Integer headingId);

}
