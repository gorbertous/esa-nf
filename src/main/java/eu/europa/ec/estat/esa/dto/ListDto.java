package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class ListDto extends ElementDto {

	private Integer listTypeId;
	private List<ListItemDto> listItemDtos;

	public Integer getListTypeId() {
		return listTypeId;
	}

	public void setListTypeId(Integer listTypeId) {
		this.listTypeId = listTypeId;
	}

	public List<ListItemDto> getListItemDtos() {
		return listItemDtos;
	}

	public void setListItemDtos(List<ListItemDto> listItemDtos) {
		this.listItemDtos = listItemDtos;
	}

}
