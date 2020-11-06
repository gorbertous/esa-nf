package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class GlossaryItemDto {

	private Integer glossaryItemId;
	private String text;
	private String definition;

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

}
