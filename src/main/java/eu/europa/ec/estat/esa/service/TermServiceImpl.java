package eu.europa.ec.estat.esa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import eu.europa.ec.estat.esa.model.Term;
import eu.europa.ec.estat.esa.repository.TermRepository;

@Service
public class TermServiceImpl implements TermService {

	@Autowired
	private TermRepository termRepository;

	@Override
	public List<Term> getAllTerms() {
		return termRepository.findAll();
	}

	@Override
	public void saveTerm(Term term) {
		this.termRepository.save(term);
	}

	@Override
	public Term getTermById(long id) {
		Optional<Term> optional = termRepository.findById((int) id);
		Term term = null;
		if (optional.isPresent()) {
			term = optional.get();
		} else {
			throw new RuntimeException(" Term not found for id :: " + id);
		}
		return term;
	}

	@Override
	public void deleteTermById(long id) {
		this.termRepository.deleteById((int) id);
	}

	@Override
	public Page<Term> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.termRepository.findAll(pageable);
	}
}

