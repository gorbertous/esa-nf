package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class ParagraphDto extends ElementDto {

	private String code;
	private List<ElementDto> paragraphElementDtos;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ElementDto> getParagraphElementDtos() {
		return paragraphElementDtos;
	}

	public void setParagraphElementDtos(List<ElementDto> paragraphElementDtos) {
		this.paragraphElementDtos = paragraphElementDtos;
	}

}
