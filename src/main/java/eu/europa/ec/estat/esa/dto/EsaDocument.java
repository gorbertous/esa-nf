package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class EsaDocument {

	private List<PureHeadingDto> headingDtos;

	public EsaDocument(List<PureHeadingDto> headingDtos) {
		this.headingDtos = headingDtos;
	}

	public List<PureHeadingDto> getHeadingDtos() {
		return headingDtos;
	}

	public void setHeadingDtos(List<PureHeadingDto> headingDtos) {
		this.headingDtos = headingDtos;
	}

	@Override
	public String toString() {
		return "EsaDocument{" + "headingDtos=" + headingDtos + '}';
	}

}
