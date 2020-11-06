package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class LinkDto {

	private Integer id;
	private String text;
	private String url;
	private List<Integer> textBlockIds;
	private List<Integer> headingTextBlockIds;
	private List<Integer> listItemIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return "LinkDto{" + "id=" + id + ", text=" + text + ", url=" + url + ", textBlockIds=" + textBlockIds + ", headingTextBlockIds=" + headingTextBlockIds + ", listItemIds=" + listItemIds + '}';
	}

}
