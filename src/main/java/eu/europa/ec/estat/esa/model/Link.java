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
@Table(name = "links")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_id")
	private int id;

	@Column(name = "text")
	private String text;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "esa_paragraph")
	private String paragraphesa;
	
	@Column(name = "bmp_paragraph")
	private String paragraphbmp;
	
	@Column(name = "link_js")
	private String linkjs;

	

}
