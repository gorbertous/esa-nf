package eu.europa.ec.estat.esa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.europa.ec.estat.esa.model.Term;

public interface TermRepository extends JpaRepository<Term, Integer> {

}
