package eu.europa.ec.estat.esa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.europa.ec.estat.esa.model.Chapter;

/**
 * @author Gorazd.Bertoncelj
 *
 */
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}