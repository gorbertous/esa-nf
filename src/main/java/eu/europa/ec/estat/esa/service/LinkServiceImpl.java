package eu.europa.ec.estat.esa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import eu.europa.ec.estat.esa.model.Link;
import eu.europa.ec.estat.esa.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;

	@Override
	public List<Link> getAllLinks() {
		return linkRepository.findAll();
	}

	@Override
	public void saveLink(Link link) {
		this.linkRepository.save(link);
	}

	@Override
	public Link getLinkById(long id) {
		Optional<Link> optional = linkRepository.findById((int) id);
		Link link = null;
		if (optional.isPresent()) {
			link = optional.get();
		} else {
			throw new RuntimeException(" Link not found for id :: " + id);
		}
		return link;
	}

	@Override
	public void deleteLinkById(long id) {
		this.linkRepository.deleteById((int) id);
	}

	@Override
	public Page<Link> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.linkRepository.findAll(pageable);
	}
}

