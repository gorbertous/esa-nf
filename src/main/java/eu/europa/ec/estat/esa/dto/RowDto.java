package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class RowDto {

	private String tableRowId;
	private List<CellDto> cellDtos;

	public String getTableRowId() {
		return tableRowId;
	}

	public void setTableRowId(String tableRowId) {
		this.tableRowId = tableRowId;
	}

	public List<CellDto> getCellDtos() {
		return cellDtos;
	}

	public void setCellDtos(List<CellDto> cellDtos) {
		this.cellDtos = cellDtos;
	}

	@Override
	public String toString() {
		return "RowDto{" + "tableRowId=" + tableRowId + ", cellDtos=" + cellDtos + '}';
	}

}
