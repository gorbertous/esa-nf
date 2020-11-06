package eu.europa.ec.estat.esa.entity;

import java.util.List;

/**
 *
 * @author fabrix
 */
public interface BaseRow {

	void setTableId(BaseTable bt);

	List<TableCell> getTableCellList();
}
