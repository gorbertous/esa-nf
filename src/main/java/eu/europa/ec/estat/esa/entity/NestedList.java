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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "nested_list")
@NamedQueries({
	@NamedQuery(name = "NestedList.findAll", query = "SELECT n FROM NestedList n")})
public class NestedList implements Serializable, BaseList {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "nested_list_id")
	private Integer nestedListId;
	@JoinColumn(name = "list_type_id", referencedColumnName = "list_type_id")
	@ManyToOne(optional = false)
	private ListType listTypeId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parentNestedListId")
	private List<ListItem> listItemList;
	@OneToOne(mappedBy = "childNestedListId")
	private ListItem listItemParent;
	@Transient
	private short indentationLevel;

	public NestedList() {
	}

	public NestedList(Integer nestedListId) {
		this.nestedListId = nestedListId;
	}

	public Integer getNestedListId() {
		return nestedListId;
	}

	public void setNestedListId(Integer nestedListId) {
		this.nestedListId = nestedListId;
	}

	@Override
	public ListType getListTypeId() {
		return listTypeId;
	}

	public void setListTypeId(ListType listTypeId) {
		this.listTypeId = listTypeId;
	}

	@Override
	public List<ListItem> getListItemList() {
		if (this.listItemList == null) {
			this.listItemList = new ArrayList<>();
		}
		return listItemList;
	}

	public void setListItemList(List<ListItem> listItemList) {
		this.listItemList = listItemList;
	}

	public ListItem getListItemParent() {
		return listItemParent;
	}

	public void setListItemParent(ListItem listItemParent) {
		this.listItemParent = listItemParent;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (nestedListId != null ? nestedListId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof NestedList)) {
			return false;
		}
		NestedList other = (NestedList) object;
		if ((this.nestedListId == null && other.nestedListId != null) || (this.nestedListId != null && !this.nestedListId.equals(other.nestedListId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.NestedList[ nestedListId=" + nestedListId + " ]";
	}

	@Override
	public Object getParent() {
		return this.getListItemParent();
	}

}
