package eu.europa.ec.estat.esa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import eu.europa.ec.estat.esa.model.Chapter;
import eu.europa.ec.estat.esa.repository.ChapterRepository;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

	@Override
	public List<Chapter> getAllChapters() {
		return chapterRepository.findAll();
	}

	@Override
	public void saveChapter(Chapter chapter) {
		this.chapterRepository.save(chapter);
	}

	@Override
	public Chapter getChapterById(long id) {
		Optional<Chapter> optional = chapterRepository.findById((int) id);
		Chapter chapter = null;
		if (optional.isPresent()) {
			chapter = optional.get();
		} else {
			throw new RuntimeException(" Chapter not found for id :: " + id);
		}
		return chapter;
	}

	@Override
	public void deleteChapterById(long id) {
		this.chapterRepository.deleteById((int) id);
	}

	@Override
    public Page < Chapter > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.chapterRepository.findAll(pageable);
    }
}
