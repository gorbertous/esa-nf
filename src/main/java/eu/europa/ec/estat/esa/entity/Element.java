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
@Table(name = "element")
@NamedQueries({
	@NamedQuery(name = "Element.findAll", query = "SELECT e FROM Element e")})
public abstract class Element implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "element_id")
	private Integer elementId;

	@JoinColumn(name = "heading_id", referencedColumnName = "heading_id")
	@ManyToOne(optional = false)
	private Heading headingId;

	public Element() {
	}

	public Element(Integer elementId) {
		this.elementId = elementId;
	}

	public Element(Heading headingId) {
		this.headingId = headingId;
	}

	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	public Heading getHeadingId() {
		return headingId;
	}

	public void setHeadingId(Heading headingId) {
		this.headingId = headingId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (elementId != null ? elementId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Element)) {
			return false;
		}
		Element other = (Element) object;
		if ((this.elementId == null && other.elementId != null) || (this.elementId != null && !this.elementId.equals(other.elementId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.Element[ elementId=" + elementId + " ]";
	}

}
