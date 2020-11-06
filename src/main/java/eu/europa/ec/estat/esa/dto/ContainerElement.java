package eu.europa.ec.estat.esa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author fabrix
 */
@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum ContainerElement {
	HEADING_TEXT_BLOCK,
	TEXT_BLOCK,
	LIST_ITEM;

	public static ContainerElement fromValue(int value) {
		for (ContainerElement ce : ContainerElement.values()) {
			if (ce.ordinal() == value) {
				return ce;
			}
		}
		throw new RuntimeException("Unknown ContainerElement");
	}
}
