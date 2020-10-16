package eu.europa.ec.estat.esa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import eu.europa.ec.estat.esa.model.Term;

public interface TermService {
	List<Term> getAllTerms();

	void saveTerm(Term term);

	Term getTermById(long id);

	void deleteTermById(long id);

	Page<Term> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
