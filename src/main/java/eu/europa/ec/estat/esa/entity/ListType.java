package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "list_type")
@NamedQueries({
	@NamedQuery(name = "ListType.findAll", query = "SELECT l FROM ListType l")})
public class ListType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
  @Basic(optional = false)
  @Column(name = "list_type_id")
	private Integer listTypeId;
	@Basic(optional = false)
  @Column(name = "ordered")
	private boolean ordered;
	@Basic(optional = false)
  @Column(name = "value")
	private String value;
	@Column(name = "description")
	private String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "listTypeId")
	private List<NestedList> nestedListList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "listTypeId")
	private List<eu.europa.ec.estat.esa.entity.List> listList;

	public ListType() {
	}

	public ListType(Integer listTypeId) {
		this.listTypeId = listTypeId;
	}

	public ListType(Integer listTypeId, boolean ordered, String value) {
		this.listTypeId = listTypeId;
		this.ordered = ordered;
		this.value = value;
	}

	public Integer getListTypeId() {
		return listTypeId;
	}

	public void setListTypeId(Integer listTypeId) {
		this.listTypeId = listTypeId;
	}

	public boolean getOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<NestedList> getNestedListList() {
		return nestedListList;
	}

	public void setNestedListList(List<NestedList> nestedListList) {
		this.nestedListList = nestedListList;
	}

	public List<eu.europa.ec.estat.esa.entity.List> getListList() {
		return listList;
	}

	public void setListList(List<eu.europa.ec.estat.esa.entity.List> listList) {
		this.listList = listList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (listTypeId != null ? listTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ListType)) {
			return false;
		}
		ListType other = (ListType) object;
		if ((this.listTypeId == null && other.listTypeId != null) || (this.listTypeId != null && !this.listTypeId.equals(other.listTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.ListType[ listTypeId=" + listTypeId + " ]";
	}
	
}
