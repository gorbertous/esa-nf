package eu.europa.ec.estat.esa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import eu.europa.ec.estat.esa.model.Link;

public interface LinkService {
	List<Link> getAllLinks();

	void saveLink(Link link);

	Link getLinkById(long id);

	void deleteLinkById(long id);

	Page<Link> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
