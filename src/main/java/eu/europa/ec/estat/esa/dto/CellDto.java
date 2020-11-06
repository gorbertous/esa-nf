package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class CellDto {

	private Integer tableCellId;
	private String value;
	private Short colSpan;
	private Short rowSpan;

	public Integer getTableCellId() {
		return tableCellId;
	}

	public void setTableCellId(Integer tableCellId) {
		this.tableCellId = tableCellId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Short getColSpan() {
		return colSpan;
	}

	public void setColSpan(Short colSpan) {
		this.colSpan = colSpan;
	}

	public Short getRowSpan() {
		return rowSpan;
	}

	public void setRowSpan(Short rowSpan) {
		this.rowSpan = rowSpan;
	}

	@Override
	public String toString() {
		return "CellDto{" + "tableCellId=" + tableCellId + ", value=" + value + ", colSpan=" + colSpan + ", rowSpan=" + rowSpan + '}';
	}

}
