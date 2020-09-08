package eu.europa.ec.estat.esa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import eu.europa.ec.estat.esa.model.Chapter;

public interface ChapterService {
    List < Chapter > getAllChapters();
    void saveChapter(Chapter chapter);
    Chapter getChapterById(long id);
    void deleteChapterById(long id);
    Page < Chapter > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
