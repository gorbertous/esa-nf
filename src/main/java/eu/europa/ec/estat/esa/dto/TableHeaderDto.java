package eu.europa.ec.estat.esa.dto;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class TableHeaderDto {

	private String tableHeaderId;
	private List<CellDto> cellDtos;

	public String getTableHeaderId() {
		return tableHeaderId;
	}

	public void setTableHeaderId(String tableHeaderId) {
		this.tableHeaderId = tableHeaderId;
	}

	public List<CellDto> getCellDtos() {
		return cellDtos;
	}

	public void setCellDtos(List<CellDto> cellDtos) {
		this.cellDtos = cellDtos;
	}

	@Override
	public String toString() {
		return "TableHeaderDto{" + "tableHeaderId=" + tableHeaderId + ", cellDtos=" + cellDtos + '}';
	}

}
