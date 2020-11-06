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
@Table(name = "footnote")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Footnote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "footnote_id")
	private Integer id;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "custom")
	private boolean custom;
	
	@Column(name = "paragraph")
	private String paragraph;
	
	@Column(name = "link_js")
	private String linkjs;

}
