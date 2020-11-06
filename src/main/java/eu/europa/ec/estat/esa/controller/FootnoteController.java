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

import eu.europa.ec.estat.esa.model.Footnote;
import eu.europa.ec.estat.esa.service.FootnoteService;

@Controller
public class FootnoteController {

	@Autowired
	private FootnoteService footnoteService;
	
	private static final String FOOTNOTE = "footnote";

	// display list of footnotes
	@GetMapping("/footnotes")
	public String footnotesList(Model model) {
		return findPaginated(1, "id", "asc", model);
	}

	@GetMapping("/footnote/view/{id}")
	public String getFootnote(@PathVariable(value = "id") int id, Model model) {

		// get footnote from the service
		Footnote footnote = footnoteService.getFootnoteById(id);

		// set footnote as a model attribute to pre-populate the form
		model.addAttribute(FOOTNOTE, footnote);
		return FOOTNOTE;
	}

	@GetMapping("/footnotes/new")
	public String showNewFootnoteForm(Model model) {
		// create model attribute to bind form data
		Footnote footnote = new Footnote();
		model.addAttribute(FOOTNOTE, footnote);
		return "new_footnote";
	}

	@PostMapping("/saveFootnote")
	public String saveFootnote(@ModelAttribute(FOOTNOTE) Footnote footnote) {
		// save footnote to database
		footnoteService.saveFootnote(footnote);
		return "redirect:/footnotes";
	}

	@GetMapping("/footnotes/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get footnote from the service
		Footnote footnote = footnoteService.getFootnoteById(id);

		// set footnote as a model attribute to pre-populate the form
		model.addAttribute(FOOTNOTE, footnote);
		return "update_footnote";
	}

	@GetMapping("/deleteFootnote/{id}")
	public String deleteFootnote(@PathVariable(value = "id") int id) {

		// call delete footnote method
		this.footnoteService.deleteFootnoteById(id);
		return "redirect:/footnotes";
	}

	@GetMapping("/footnotes/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 20;

		Page<Footnote> page = footnoteService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Footnote> listFootnotes = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listFootnotes", listFootnotes);
		return "footnotes";
	}

}
