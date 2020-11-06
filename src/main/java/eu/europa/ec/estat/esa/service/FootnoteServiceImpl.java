package eu.europa.ec.estat.esa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import eu.europa.ec.estat.esa.model.Footnote;
import eu.europa.ec.estat.esa.repository.FootnoteRepository;

@Service
public class FootnoteServiceImpl implements FootnoteService {

	@Autowired
	private FootnoteRepository footnoteRepository;

	@Override
	public List<Footnote> getAllFootnotes() {
		return footnoteRepository.findAll();
	}

	@Override
	public void saveFootnote(Footnote footnote) {
		this.footnoteRepository.save(footnote);
	}

	@Override
	public Footnote getFootnoteById(long id) {
		Optional<Footnote> optional = footnoteRepository.findById((int) id);
		Footnote footnote = null;
		if (optional.isPresent()) {
			footnote = optional.get();
		} else {
			throw new RuntimeException(" Footnote not found for id :: " + id);
		}
		return footnote;
	}

	@Override
	public void deleteFootnoteById(long id) {
		this.footnoteRepository.deleteById((int) id);
	}

	@Override
	public Page<Footnote> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.footnoteRepository.findAll(pageable);
	}
}


