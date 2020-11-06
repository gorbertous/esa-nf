package eu.europa.ec.estat.esa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "terms")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Term {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "term_id")
	private int id;

	@Column(name = "term_title")
	private String title;
	
	@Column(name = "term_code")
	private String code;
	
	@Column(name = "term_paragraph")
	private String paragraph;
	
	@Column(name = "term_definition")
	private String definition;
	
	@Column(name = "term_defjs")
	private String defjs;

	

}
