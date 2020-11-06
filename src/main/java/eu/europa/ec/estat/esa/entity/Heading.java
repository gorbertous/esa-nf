package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "heading")
@NamedQueries({
	@NamedQuery(name = "Heading.findAll", query = "SELECT h FROM Heading h")})
@NamedStoredProcedureQuery(name = "clean",procedureName = "clean")
@NamedStoredProcedureQuery(name = "custom_backup",procedureName = "custom_backup")
public class Heading implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "heading_id")
	private Integer headingId;
	@Basic(optional = false)
	@Column(name = "level")
	private short level;
	@Basic(optional = false)
	@Column(name = "text")
	private String text;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
	private List<Heading> headingList;
	@JoinColumn(name = "parent_id", referencedColumnName = "heading_id")
	@ManyToOne
	private Heading parentId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "headingId")
	private List<Element> elementList;

	public Heading() {
	}

	public Heading(Integer headingId) {
		this.headingId = headingId;
	}

	public Heading(Integer headingId, short level, String text) {
		this.headingId = headingId;
		this.level = level;
		this.text = text;
	}

	public Integer getHeadingId() {
		return headingId;
	}

	public void setHeadingId(Integer headingId) {
		this.headingId = headingId;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Heading> getHeadingList() {
		if (this.headingList == null) {
			this.headingList = new ArrayList<>();
		}
		return headingList;
	}

	public void setHeadingList(List<Heading> headingList) {
		this.headingList = headingList;
	}

	public Heading getParentId() {
		return parentId;
	}

	public void setParentId(Heading parentId) {
		this.parentId = parentId;
	}

	public List<Element> getElementList() {
		if (this.elementList == null) {
			this.elementList = new ArrayList<>();
		}
		return elementList;
	}

	public void setElementList(List<Element> elementList) {
		this.elementList = elementList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (headingId != null ? headingId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Heading)) {
			return false;
		}
		Heading other = (Heading) object;
		if ((this.headingId == null && other.headingId != null) || (this.headingId != null && !this.headingId.equals(other.headingId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.Heading[ headingId=" + headingId + " ]";
	}

}
