//package eu.europa.ec.estat.esa.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import eu.europa.ec.estat.esa.model.Chapter;
//import eu.europa.ec.estat.esa.repository.ChapterRepository;
//
///**
// * @author Gorazd.Bertoncelj
// *
// */
//
//@Service
//public class ChapterServiceImpl2 {
//
//	@Autowired
//	private ChapterRepository chapterrepo;
//
//	private boolean existsById(int i) {
//		return chapterrepo.existsById((int) i);
//	}
//
//	public Chapter findById(Integer id) throws Exception {
//		Chapter chapter = chapterrepo.findById(id).orElse(null);
//		if (chapter == null) {
//			throw new Exception("Cannot find chapter with id: " + id);
//		} else
//			return chapter;
//	}
//
//	public List<Chapter> findAll(int pageNumber, int rowPerPage) {
//		List<Chapter> chapters = new ArrayList<>();
//		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("id").ascending());
//		chapterrepo.findAll(sortedByIdAsc).forEach(chapters::add);
//		return chapters;
//	}
//
//	public Chapter save(Chapter chapter) throws Exception {
//		if (!StringUtils.isEmpty(chapter.getTitle())) {
//			if (existsById(chapter.getId())) {
//				throw new Exception("chapter with id: " + chapter.getId() + " already exists");
//			}
//			return chapterrepo.save(chapter);
//		} else {
//			throw new Exception("Chapter name cannot be null or empty");
//		}
//	}
//
//	public void update(Chapter chapter) throws Exception {
//		if (!StringUtils.isEmpty(chapter.getTitle())) {
//			if (!existsById(chapter.getId())) {
//				throw new Exception("Cannot find chapter with id: " + chapter.getId());
//			}
//			chapterrepo.save(chapter);
//		} else {
//			throw new Exception("Chapter name cannot be null or empty");
//		}
//	}
//
//	public void deleteById(int id) throws Exception {
//		if (!existsById(id)) {
//			throw new Exception("Cannot find chapter with id: " + id);
//		} else {
//			chapterrepo.deleteById(id);
//		}
//	}
//
//	public Long count() {
//		return chapterrepo.count();
//	}
//
//}
//
//
////import java.util.List;
////import java.util.Optional;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
////import org.springframework.stereotype.Service;
////
////import eu.europa.ec.estat.esa.model.Chapter;
////import eu.europa.ec.estat.esa.repository.ChapterRepository;
////
////@Service
////public class ChapterServiceImpl implements ChapterService {
////
////	@Autowired
////	private ChapterRepository chapterRepository;
////
////	@Override
////	public List<Chapter> getAllChapters() {
////		return chapterRepository.findAll();
////	}
////
////	@Override
////	public void saveChapter(Chapter chapter) {
////		this.chapterRepository.save(chapter);
////	}
////
////	@Override
////	public Chapter getChapterById(long id) {
////		Optional<Chapter> optional = chapterRepository.findById(id);
////		Chapter chapter = null;
////		if (optional.isPresent()) {
////			chapter = optional.get();
////		} else {
////			throw new RuntimeException(" Chapter not found for id :: " + id);
////		}
////		return chapter;
////	}
////
////	@Override
////	public void deleteChapterById(long id) {
////		this.chapterRepository.deleteById(id);
////	}
////
////	@Override
////	public Page<Chapter> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
////		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
////			Sort.by(sortField).descending();
////		
////		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
////		return this.chapterRepository.findAll(pageable);
////	}
////}
////
