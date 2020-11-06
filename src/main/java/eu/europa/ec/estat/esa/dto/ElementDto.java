package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class ElementDto {

	private Integer elementId;

	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	@Override
	public String toString() {
		return "ElementDto{" + "elementId=" + elementId + '}';
	}

}
