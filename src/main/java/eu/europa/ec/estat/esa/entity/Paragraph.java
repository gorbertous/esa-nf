package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "paragraph")
@NamedQueries({
	@NamedQuery(name = "Paragraph.findAll", query = "SELECT p FROM Paragraph p")})
public class Paragraph extends Element implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "code")
	private String code;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paragraphId")
	@OrderBy(value = "paragraphElementId ASC")
	private List<ParagraphElement> paragraphElementList;

	public Paragraph() {
	}

	public Paragraph(String code, Heading headingId) {
		super(headingId);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ParagraphElement> getParagraphElementList() {
		if (this.paragraphElementList == null) {
			this.paragraphElementList = new ArrayList<>();
		}
		return paragraphElementList;
	}

	public void setParagraphElementList(List<ParagraphElement> paragraphElementList) {
		this.paragraphElementList = paragraphElementList;
	}

	@Override
	public String toString() {
		return "Paragraph{" + "code=" + code + '}';
	}

}
