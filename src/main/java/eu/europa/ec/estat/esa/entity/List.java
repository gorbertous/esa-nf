package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "list")
@NamedQueries({
	@NamedQuery(name = "List.findAll", query = "SELECT l FROM List l")})
public class List extends ParagraphElement implements Serializable, BaseList {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "list_type_id", referencedColumnName = "list_type_id")
	@ManyToOne(optional = false)
	private ListType listTypeId;
	@OneToMany(mappedBy = "listParagrafElementId", cascade = CascadeType.ALL)
	private java.util.List<ListItem> listItemList;

	public List() {
	}

	@Override
	public ListType getListTypeId() {
		return listTypeId;
	}

	public void setListTypeId(ListType listTypeId) {
		this.listTypeId = listTypeId;
	}

	@Override
	public java.util.List<ListItem> getListItemList() {
		if (this.listItemList == null) {
			this.listItemList = new ArrayList<>();
		}
		return listItemList;
	}

	public void setListItemList(java.util.List<ListItem> listItemList) {
		this.listItemList = listItemList;
	}

	@Override
	public String toString() {
		return "List{" + "listItemList=" + listItemList + '}';
	}

	@Override
	public Object getParent() {
		return this.getParagraphId();
	}

}
