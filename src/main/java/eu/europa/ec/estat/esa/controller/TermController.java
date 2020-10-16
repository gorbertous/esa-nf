package eu.europa.ec.estat.esa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.europa.ec.estat.esa.model.Term;
import eu.europa.ec.estat.esa.service.TermService;

@Controller
public class TermController {

	@Autowired
	private TermService termService;
	
	private static final String TERM = "term";

	// display list of terms
	@GetMapping("/terms")
	public String termsList(Model model) {
		return findPaginated(1, "id", "asc", model);
	}

	@GetMapping("/term/view/{id}")
	public String getTerm(@PathVariable(value = "id") int id, Model model) {

		// get term from the service
		Term term = termService.getTermById(id);

		// set term as a model attribute to pre-populate the form
		model.addAttribute(TERM, term);
		return TERM;
	}

	@GetMapping("/terms/new")
	public String showNewTermForm(Model model) {
		// create model attribute to bind form data
		Term term = new Term();
		model.addAttribute(TERM, term);
		return "new_term";
	}

	@PostMapping("/saveTerm")
	public String saveTerm(@ModelAttribute(TERM) Term term) {
		// save term to database
		termService.saveTerm(term);
		return "redirect:/terms";
	}

	@GetMapping("/terms/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get term from the service
		Term term = termService.getTermById(id);

		// set term as a model attribute to pre-populate the form
		model.addAttribute(TERM, term);
		return "update_term";
	}

	@GetMapping("/deleteTerm/{id}")
	public String deleteTerm(@PathVariable(value = "id") int id) {

		// call delete term method
		this.termService.deleteTermById(id);
		return "redirect:/terms";
	}

	@GetMapping("/terms/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 30;

		Page<Term> page = termService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Term> listTerms = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listTerms", listTerms);
		return "terms";
	}

}
