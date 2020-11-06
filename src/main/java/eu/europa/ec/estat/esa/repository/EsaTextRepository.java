package eu.europa.ec.estat.esa.repository;

import eu.europa.ec.estat.esa.entity.EsaText;
import eu.europa.ec.estat.esa.entity.EsaTextId;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabrix
 */
public interface EsaTextRepository extends CrudRepository<EsaText, EsaTextId> {

}
