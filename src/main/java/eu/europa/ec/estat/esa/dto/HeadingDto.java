package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class HeadingDto {

	private Integer headingId;
	private short level;
	private String text;
	private List<HeadingDto> headingDtos;
	private List<ElementDto> elementDtos;

	public Integer getHeadingId() {
		return headingId;
	}

	public void setHeadingId(Integer headingId) {
		this.headingId = headingId;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<ElementDto> getElementDtos() {
		return elementDtos;
	}

	public void setElementDtos(List<ElementDto> elementDtos) {
		this.elementDtos = elementDtos;
	}

	public List<HeadingDto> getHeadingDtos() {
		return headingDtos;
	}

	public void setHeadingDtos(List<HeadingDto> headingDtos) {
		this.headingDtos = headingDtos;
	}

}
