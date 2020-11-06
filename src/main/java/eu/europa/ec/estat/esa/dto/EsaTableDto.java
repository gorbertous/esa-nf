package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class EsaTableDto extends ElementDto {

	private String code;
	private String description;
	private List<RowDto> rowDtos;
	private List<TableHeaderDto> tableHeaderDtos;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RowDto> getRowDtos() {
		return rowDtos;
	}

	public void setRowDtos(List<RowDto> rowDtos) {
		this.rowDtos = rowDtos;
	}

	public List<TableHeaderDto> getTableHeaderDtos() {
		return tableHeaderDtos;
	}

	public void setTableHeaderDtos(List<TableHeaderDto> tableHeaderDtos) {
		this.tableHeaderDtos = tableHeaderDtos;
	}

	@Override
	public String toString() {
		return "EsaTableDto{" + "code=" + code + ", description=" + description + ", rowDtos=" + rowDtos + ", tableHeaderDtos=" + tableHeaderDtos + '}';
	}

}
