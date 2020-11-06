package eu.europa.ec.estat.esa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.europa.ec.estat.esa.model.Link;

public interface LinkRepository extends JpaRepository<Link, Integer> {

}
