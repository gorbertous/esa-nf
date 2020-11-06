package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "heading_text_block")
@NamedQueries({ @NamedQuery(name = "HeadingTextBlock.findAll", query = "SELECT h FROM HeadingTextBlock h") })
public class HeadingTextBlock extends Element implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Lob
	@Column(name = "text")
	private String text;

	@JoinColumn(name = "glossary_item_id", referencedColumnName = "glossary_item_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private GlossaryItem glossaryItemId;

	public HeadingTextBlock() {
	}

	public HeadingTextBlock(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public GlossaryItem getGlossaryItemId() {
		return glossaryItemId;
	}

	public void setGlossaryItemId(GlossaryItem glossaryItemId) {
		this.glossaryItemId = glossaryItemId;
	}

	@Override
	public String toString() {
		return "HeadingTextBlock{" + "text=" + text  + ", glossaryItemId="
				+ glossaryItemId + '}';
	}

}
