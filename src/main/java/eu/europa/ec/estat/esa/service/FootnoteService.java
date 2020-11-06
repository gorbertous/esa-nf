package eu.europa.ec.estat.esa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import eu.europa.ec.estat.esa.model.Footnote;

public interface FootnoteService {
	List<Footnote> getAllFootnotes();

	void saveFootnote(Footnote footnote);

	Footnote getFootnoteById(long id);

	void deleteFootnoteById(long id);

	Page<Footnote> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
