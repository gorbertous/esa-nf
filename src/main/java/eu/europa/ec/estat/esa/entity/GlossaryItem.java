package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "glossary_item")
@NamedQueries({
	@NamedQuery(name = "GlossaryItem.findAll", query = "SELECT g FROM GlossaryItem g")})
public class GlossaryItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "glossary_item_id")
	private Integer glossaryItemId;
	@Basic(optional = false)
	@Column(name = "text")
	private String text;
	@Basic(optional = false)
	@Column(name = "definition")
	private String definition;
	@Basic(optional = false)
	@Column(name = "custom")
	private boolean custom;
	@OneToMany(mappedBy = "glossaryItemId")
	private List<HeadingTextBlock> headingTextBlockList;
	@OneToMany(mappedBy = "glossaryItemId")
	private List<TextBlock> textBlockList;
	@OneToMany(mappedBy = "glossaryItemId")
	private List<ListItem> listItemList;

	public GlossaryItem() {
	}

	public GlossaryItem(Integer glossaryItemId) {
		this.glossaryItemId = glossaryItemId;
	}

	public GlossaryItem(Integer glossaryItemId, String text, String definition) {
		this.glossaryItemId = glossaryItemId;
		this.text = text;
		this.definition = definition;
	}

	public Integer getGlossaryItemId() {
		return glossaryItemId;
	}

	public void setGlossaryItemId(Integer glossaryItemId) {
		this.glossaryItemId = glossaryItemId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public List<HeadingTextBlock> getHeadingTextBlockList() {
		if (this.headingTextBlockList == null) {
			this.headingTextBlockList = new ArrayList<>();
		}
		return headingTextBlockList;
	}

	public void setHeadingTextBlockList(List<HeadingTextBlock> headingTextBlockList) {
		this.headingTextBlockList = headingTextBlockList;
	}

	public List<TextBlock> getTextBlockList() {
		if (this.textBlockList == null) {
			this.textBlockList = new ArrayList<>();
		}
		return textBlockList;
	}

	public void setTextBlockList(List<TextBlock> textBlockList) {
		this.textBlockList = textBlockList;
	}

	public List<ListItem> getListItemList() {
		return listItemList;
	}

	public void setListItemList(List<ListItem> listItemList) {
		this.listItemList = listItemList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (glossaryItemId != null ? glossaryItemId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof GlossaryItem)) {
			return false;
		}
		GlossaryItem other = (GlossaryItem) object;
		if ((this.glossaryItemId == null && other.glossaryItemId != null) || (this.glossaryItemId != null && !this.glossaryItemId.equals(other.glossaryItemId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.GlossaryItem[ glossaryItemId=" + glossaryItemId + " ]";
	}

}
