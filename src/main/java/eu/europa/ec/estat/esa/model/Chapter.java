package eu.europa.ec.estat.esa.model;

//import java.util.Set;

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
@Table(name = "chapter")
//@NamedQuery(name = "Chapter.findAll", query = "SELECT c FROM chapter c")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chapter_id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "chapter_text")
	private String htmltext;

}
