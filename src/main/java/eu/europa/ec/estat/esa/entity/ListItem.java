package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "list_item")
@NamedQueries({
	@NamedQuery(name = "ListItem.findAll", query = "SELECT l FROM ListItem l")})
public class ListItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "list_item_id")
	private Integer listItemId;
	@Basic(optional = false)
	@Column(name = "text")
	private String text;
	@JoinColumn(name = "glossary_item_id", referencedColumnName = "glossary_item_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private GlossaryItem glossaryItemId;
	@JoinColumn(name = "list_paragraf_element_id", referencedColumnName = "paragraph_element_id")
	@ManyToOne
	private List listParagrafElementId;
	@JoinColumn(name = "parent_nested_list_id", referencedColumnName = "nested_list_id")
	@ManyToOne
	private NestedList parentNestedListId;
	@JoinColumn(name = "child_nested_list_id", referencedColumnName = "nested_list_id")
	@OneToOne(cascade = CascadeType.ALL)
	private NestedList childNestedListId;

	public ListItem() {
	}

	public ListItem(Integer listItemId) {
		this.listItemId = listItemId;
	}

	public ListItem(Integer listItemId, String text, short indentationLevel) {
		this.listItemId = listItemId;
		this.text = text;
	}

	public Integer getListItemId() {
		return listItemId;
	}

	public void setListItemId(Integer listItemId) {
		this.listItemId = listItemId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public GlossaryItem getGlossaryItemId() {
		return glossaryItemId;
	}

	public void setGlossaryItemId(GlossaryItem glossaryItemId) {
		this.glossaryItemId = glossaryItemId;
	}

	public List getListParagrafElementId() {
		return listParagrafElementId;
	}

	public void setListParagrafElementId(List listParagrafElementId) {
		this.listParagrafElementId = listParagrafElementId;
	}

	public NestedList getParentNestedListId() {
		return parentNestedListId;
	}

	public void setParentNestedListId(NestedList parentNestedListId) {
		this.parentNestedListId = parentNestedListId;
	}

	public NestedList getChildNestedListId() {
		return childNestedListId;
	}

	public void setChildNestedListId(NestedList childNestedListId) {
		this.childNestedListId = childNestedListId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (listItemId != null ? listItemId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ListItem)) {
			return false;
		}
		ListItem other = (ListItem) object;
		if ((this.listItemId == null && other.listItemId != null) || (this.listItemId != null && !this.listItemId.equals(other.listItemId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.ListItem[ listItemId=" + listItemId + " ]";
	}

}
