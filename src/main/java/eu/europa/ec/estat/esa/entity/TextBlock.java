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
@Table(name = "text_block")
@NamedQueries({ @NamedQuery(name = "TextBlock.findAll", query = "SELECT t FROM TextBlock t") })
public class TextBlock extends ParagraphElement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Lob
	@Column(name = "text")
	private String text;

	@JoinColumn(name = "glossary_item_id", referencedColumnName = "glossary_item_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private GlossaryItem glossaryItemId;

	public TextBlock() {
	}

	public TextBlock(ParagraphElement paragraphElementId) {
	}

	public TextBlock(String text) {
		this.text = text;
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

	@Override
	public String toString() {
		return "TextBlock{" + "text=" + text + ", glossaryItemId=" + glossaryItemId + '}';
	}

}
