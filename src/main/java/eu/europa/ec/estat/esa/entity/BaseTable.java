package eu.europa.ec.estat.esa.entity;

import java.util.List;

/**
 *
 * @author fabrix
 */
public interface BaseTable {

	String getCode();

	String getDescription();

	List<TableRow> getTableRowList();

	List<TableHeader> getTableHeaderList();

	void setCode(String code);

	void setDescription(String description);

	void setTableRowList(List<TableRow> tableRowList);

	void setContainerId(Object id);

	default void addRow(BaseRow row) {
		if (row instanceof TableRow) {
			this.getTableRowList().add((TableRow) row);
		} else if (row instanceof TableHeader) {
			this.getTableHeaderList().add((TableHeader) row);
		}
	}

}
