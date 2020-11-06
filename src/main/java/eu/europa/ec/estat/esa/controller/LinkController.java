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

import eu.europa.ec.estat.esa.model.Link;
import eu.europa.ec.estat.esa.service.LinkService;

@Controller
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	private static final String LINK = "link";

	// display list of links
	@GetMapping("/links")
	public String linksList(Model model) {
		return findPaginated(1, "id", "asc", model);
	}

	@GetMapping("/link/view/{id}")
	public String getLink(@PathVariable(value = "id") int id, Model model) {

		// get link from the service
		Link link = linkService.getLinkById(id);

		// set link as a model attribute to pre-populate the form
		model.addAttribute(LINK, link);
		return LINK;
	}

	@GetMapping("/links/new")
	public String showNewLinkForm(Model model) {
		// create model attribute to bind form data
		Link link = new Link();
		model.addAttribute(LINK, link);
		return "new_link";
	}

	@PostMapping("/saveLink")
	public String saveLink(@ModelAttribute(LINK) Link link) {
		// save link to database
		linkService.saveLink(link);
		return "redirect:/links";
	}

	@GetMapping("/links/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get link from the service
		Link link = linkService.getLinkById(id);

		// set link as a model attribute to pre-populate the form
		model.addAttribute(LINK, link);
		return "update_link";
	}

	@GetMapping("/deleteLink/{id}")
	public String deleteLink(@PathVariable(value = "id") int id) {

		// call delete link method
		this.linkService.deleteLinkById(id);
		return "redirect:/links";
	}

	@GetMapping("/links/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 30;

		Page<Link> page = linkService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Link> listLinks = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLinks", listLinks);
		return "links";
	}

}
