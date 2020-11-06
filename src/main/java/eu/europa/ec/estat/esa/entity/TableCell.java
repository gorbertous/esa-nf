package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "table_cell")
@NamedQueries({
	@NamedQuery(name = "TableCell.findAll", query = "SELECT t FROM TableCell t")})
public class TableCell implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "table_cell_id")
	private Integer tableCellId;
	@Basic(optional = false)
	@Column(name = "value")
	private String value;
	@Column(name = "col_span")
	private Short colSpan;
	@Column(name = "row_span")
	private Short rowSpan;
	@JoinColumn(name = "table_row_id", referencedColumnName = "table_row_id")
	@ManyToOne
	private TableRow tableRowId;
	@JoinColumn(name = "table_header_id", referencedColumnName = "table_header_id")
	@ManyToOne
	private TableHeader tableHeaderId;

	public TableCell() {
	}

	public TableCell(Integer tableCellId) {
		this.tableCellId = tableCellId;
	}

	public Integer getTableCellId() {
		return tableCellId;
	}

	public void setTableCellId(Integer tableCellId) {
		this.tableCellId = tableCellId;
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

	public TableRow getTableRowId() {
		return tableRowId;
	}

	public void setTableRowId(TableRow tableRowId) {
		this.tableRowId = tableRowId;
	}

	public TableHeader getTableHeaderId() {
		return tableHeaderId;
	}

	public void setTableHeaderId(TableHeader tableHeaderId) {
		this.tableHeaderId = tableHeaderId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tableCellId != null ? tableCellId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TableCell)) {
			return false;
		}
		TableCell other = (TableCell) object;
		if ((this.tableCellId == null && other.tableCellId != null) || (this.tableCellId != null && !this.tableCellId.equals(other.tableCellId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.TableCell[ tableCellId=" + tableCellId + " ]";
	}

	public void setRowId(BaseRow id) {
		if (id instanceof TableRow) {
			this.tableRowId = (TableRow) id;
		} else {
			this.tableHeaderId = (TableHeader) id;
		}

	}

}
