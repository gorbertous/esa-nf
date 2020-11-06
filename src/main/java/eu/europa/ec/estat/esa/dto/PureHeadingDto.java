package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class PureHeadingDto {

	private Integer headingId;
	private short level;
	private String text;
	private List<PureHeadingDto> headingDtos;

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

	public List<PureHeadingDto> getHeadingDtos() {
		return headingDtos;
	}

	public void setHeadingDtos(List<PureHeadingDto> headingDtos) {
		this.headingDtos = headingDtos;
	}
}
