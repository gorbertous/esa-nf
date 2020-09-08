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

import eu.europa.ec.estat.esa.model.Chapter;
import eu.europa.ec.estat.esa.service.ChapterService;

@Controller
public class ChapterController {

	@Autowired
	private ChapterService chapterService;

	// display list of chapters
	@GetMapping("/chapters")
    public String viewHomePage(Model model) {
        return findPaginated(1, "title", "asc", model);
    }
	
	@GetMapping("/chapter/view/{id}")
	public String getChapter(@PathVariable(value = "id") int id, Model model) {

		// get chapter from the service
		Chapter chapter = chapterService.getChapterById(id);

		// set chapter as a model attribute to pre-populate the form
		model.addAttribute("chapter", chapter);
		return "chapter";
	}
	
	@GetMapping("/chapters/new")
	public String showNewChapterForm(Model model) {
		// create model attribute to bind form data
		Chapter chapter = new Chapter();
		model.addAttribute("chapter", chapter);
		return "new_chapter";
	}

	@PostMapping("/saveChapter")
	public String saveChapter(@ModelAttribute("chapter") Chapter chapter) {
		// save chapter to database
		chapterService.saveChapter(chapter);
		return "redirect:/chapters";
	}

	@GetMapping("/chapters/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get chapter from the service
		Chapter chapter = chapterService.getChapterById(id);

		// set chapter as a model attribute to pre-populate the form
		model.addAttribute("chapter", chapter);
		return "update_chapter";
	}

	@GetMapping("/deleteChapter/{id}")
	public String deleteChapter(@PathVariable(value = "id") int id) {

		// call delete chapter method
		this.chapterService.deleteChapterById(id);
		return "redirect:/chapters";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
	    @RequestParam("sortField") String sortField,
	    @RequestParam("sortDir") String sortDir,
	    Model model) {
	    int pageSize = 5;

	    Page < Chapter > page = chapterService.findPaginated(pageNo, pageSize, sortField, sortDir);
	    List < Chapter > listChapters = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());

	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	    model.addAttribute("listChapters", listChapters);
	    return "chapters";
	}

}

//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import eu.europa.ec.estat.esa.model.Chapter;
//import eu.europa.ec.estat.esa.service.ChapterService;
//
///**
// * @author Gorazd.Bertoncelj
// *
// */
//
//@Controller
//public class ChapterController implements WebMvcConfigurer {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	private final int ROW_PER_PAGE = 5;
//
//	@Autowired
//	private ChapterService chapterService;
//
////	@Value("${msg.title}")
////	private String title;
////
////	@GetMapping(value = { "/", "/index" })
////	public String index(Model model) {
//////		model.addAttribute("title", title);
////		return "index";
////	}
//
//	@GetMapping(value = "/chapters")
//	public String getChapters(Model model, @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
//		List<Chapter> chapters = chapterService.findAll(pageNumber, ROW_PER_PAGE);
//
//		long count = chapterService.count();
//		boolean hasPrev = pageNumber > 1;
//		boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
//		model.addAttribute("chapters", chapters);
//		model.addAttribute("hasPrev", hasPrev);
//		model.addAttribute("prev", pageNumber - 1);
//		model.addAttribute("hasNext", hasNext);
//		model.addAttribute("next", pageNumber + 1);
//		return "chapters";
//	}
//
//	@GetMapping(value = "/chapters/{chapterId}")
//	public String getChapterById(Model model, @PathVariable int chapterId) {
//		Chapter chapter = null;
//		String errorMessage = null;
//		try {
//			chapter = chapterService.findById(chapterId);
//		} catch (Exception ex) {
//			errorMessage = "Chapter not found";
//		}
//
//		model.addAttribute("chapter", chapter);
//		model.addAttribute("allowDelete", false);
//		model.addAttribute("errorMessage", errorMessage);
//		return "chapter-view";
//
//	}
//
//	@GetMapping(value = { "/chapters/add" })
//	public String showAddChapter(Model model) {
//		Chapter chapter = new Chapter();
//		model.addAttribute("add", true);
//		model.addAttribute("chapter", chapter);
//		model.addAttribute("actionUrl", "/chapter/add");
//
//		return "chapter-edit";
//	}
//
//	@PostMapping(value = "/chapters/add")
//	public String addChapter(Model model, @ModelAttribute("chapter") Chapter chapter) {
//		try {
//			Chapter newChapter = chapterService.save(chapter);
//			return "redirect:/chapters/" + String.valueOf(newChapter.getId());
//		} catch (Exception ex) {
//			// log exception first,
//			// then show error
//			String errorMessage = ex.getMessage();
//			logger.error(errorMessage);
//			model.addAttribute("errorMessage", errorMessage);
//
//			// model.addAttribute("chapter", chapter);
//			model.addAttribute("add", true);
//			return "chapter-edit";
//		}
//	}
//
//	@GetMapping(value = { "/chapters/{chapterId}/edit" })
//	public String showEditChapter(Model model, @PathVariable int chapterId) {
//		Chapter chapter = null;
//		String errorMessage = null;
//		try {
//			chapter = chapterService.findById(chapterId);
//		} catch (Exception ex) {
//			errorMessage = "Chapter not found";
//		}
//		model.addAttribute("add", false);
//		model.addAttribute("chapter", chapter);
//		model.addAttribute("errorMessage", errorMessage);
//		model.addAttribute("actionUrl", "/chapters/" + (chapter == null ? 0 : chapter.getId()) + "/edit");
//		return "chapter-edit";
//	}
//
//	@PostMapping(value = { "/chapters/{chapterId}/edit" })
//	public String updateChapter(Model model, @PathVariable int chapterId, @ModelAttribute("chapter") Chapter chapter) {
//		try {
//			chapter.setId(chapterId);
//			chapterService.update(chapter);
//			return "redirect:/chapters/" + String.valueOf(chapter.getId());
//		} catch (Exception ex) {
//			// log exception first,
//			// then show error
//			String errorMessage = ex.getMessage();
//			logger.error(errorMessage);
//			model.addAttribute("errorMessage", errorMessage);
//
//			model.addAttribute("add", false);
//			return "chapter-edit";
//		}
//	}
//
//	@GetMapping(value = { "/chapters/{chapterId}/delete" })
//	public String showDeletechapterById(Model model, @PathVariable int chapterId) {
//		Chapter chapter = null;
//		String errorMessage = null;
//		try {
//			chapter = chapterService.findById(chapterId);
//		} catch (Exception ex) {
//			errorMessage = "chapter not found";
//
//		}
//		model.addAttribute("allowDelete", true);
//		model.addAttribute("chapter", chapter);
//		model.addAttribute("errorMessage", errorMessage);
//		return "chapter-view";
//	}
//
//	@PostMapping(value = { "/chapters/{chapterId}/delete" })
//	public String deletechapterById(Model model, @PathVariable int chapterId) {
//		try {
//			chapterService.deleteById(chapterId);
//			return "redirect:/chapters";
//		} catch (Exception ex) {
//			String errorMessage = ex.getMessage();
//			logger.error(errorMessage);
//			model.addAttribute("errorMessage", errorMessage);
//			return "chapter-view";
//		}
//	}
//
//}
