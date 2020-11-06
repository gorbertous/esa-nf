package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "paragraph_element")
@NamedQueries({
	@NamedQuery(name = "ParagraphElement.findAll", query = "SELECT p FROM ParagraphElement p")})
public abstract class ParagraphElement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "paragraph_element_id")
	private Integer paragraphElementId;

	@JoinColumn(name = "paragraph_id", referencedColumnName = "element_id")
	@ManyToOne(optional = false)
	private Paragraph paragraphId;

	public ParagraphElement() {
	}

	public ParagraphElement(Integer paragraphElementId) {
		this.paragraphElementId = paragraphElementId;
	}

	public Integer getParagraphElementId() {
		return paragraphElementId;
	}

	public void setParagraphElementId(Integer paragraphElementId) {
		this.paragraphElementId = paragraphElementId;
	}

	public Paragraph getParagraphId() {
		return paragraphId;
	}

	public void setParagraphId(Paragraph paragraphId) {
		this.paragraphId = paragraphId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (paragraphElementId != null ? paragraphElementId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ParagraphElement)) {
			return false;
		}
		ParagraphElement other = (ParagraphElement) object;
		if ((this.paragraphElementId == null && other.paragraphElementId != null) || (this.paragraphElementId != null && !this.paragraphElementId.equals(other.paragraphElementId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.ParagraphElement[ paragraphElementId=" + paragraphElementId + " ]";
	}

}
