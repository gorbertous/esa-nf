package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class FootnoteDto {

	private Integer footnoteId;
	private String text;
	private String description;
	private List<Integer> textBlockIds;
	private List<Integer> headingTextBlockIds;
	private List<Integer> listItemIds;

	public Integer getFootnoteId() {
		return footnoteId;
	}

	public void setFootnoteId(Integer footnoteId) {
		this.footnoteId = footnoteId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getTextBlockIds() {
		return textBlockIds;
	}

	public void setTextBlockIds(List<Integer> textBlockIds) {
		this.textBlockIds = textBlockIds;
	}

	public List<Integer> getHeadingTextBlockIds() {
		return headingTextBlockIds;
	}

	public void setHeadingTextBlockIds(List<Integer> headingTextBlockIds) {
		this.headingTextBlockIds = headingTextBlockIds;
	}

	public List<Integer> getListItemIds() {
		return listItemIds;
	}

	public void setListItemIds(List<Integer> listItemIds) {
		this.listItemIds = listItemIds;
	}

	@Override
	public String toString() {
		return "FootnoteDto{" + "footnoteId=" + footnoteId + ", text=" + text + ", description=" + description + ", textBlockIds=" + textBlockIds + ", headingTextBlockIds=" + headingTextBlockIds + ", listItemIds=" + listItemIds + '}';
	}

}
