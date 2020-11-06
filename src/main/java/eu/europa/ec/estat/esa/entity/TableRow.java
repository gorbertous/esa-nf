package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "table_row")
@NamedQueries({
	@NamedQuery(name = "TableRow.findAll", query = "SELECT t FROM TableRow t")})
public class TableRow implements Serializable, BaseRow {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "table_row_id")
	private Integer tableRowId;
	@JoinColumn(name = "esa_table_element_id", referencedColumnName = "element_id")
	@ManyToOne
	private EsaTable esaTableElementId;
	@JoinColumn(name = "paragraph_table_paragraph_element_id", referencedColumnName = "paragraph_element_id")
	@ManyToOne
	private ParagraphTable paragraphTableParagraphElementId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tableRowId")
	private List<TableCell> tableCellList;

	public TableRow() {
	}

	public TableRow(Integer tableRowId) {
		this.tableRowId = tableRowId;
	}

	public Integer getTableRowId() {
		return tableRowId;
	}

	public void setTableRowId(Integer tableRowId) {
		this.tableRowId = tableRowId;
	}

	public EsaTable getEsaTableElementId() {
		return esaTableElementId;
	}

	public void setEsaTableElementId(EsaTable esaTableElementId) {
		this.esaTableElementId = esaTableElementId;
	}

	public ParagraphTable getParagraphTableParagraphElementId() {
		return paragraphTableParagraphElementId;
	}

	public void setParagraphTableParagraphElementId(ParagraphTable paragraphTableParagraphElementId) {
		this.paragraphTableParagraphElementId = paragraphTableParagraphElementId;
	}

	@Override
	public List<TableCell> getTableCellList() {
		if(this.tableCellList == null){
			this.tableCellList = new ArrayList<>();
		}
		return tableCellList;
	}

	public void setTableCellList(List<TableCell> tableCellList) {
		this.tableCellList = tableCellList;
	}

	@Override
	public void setTableId(BaseTable bt) {
		if (bt instanceof EsaTable) {
			this.setEsaTableElementId((EsaTable) bt);
		} else {
			this.setParagraphTableParagraphElementId((ParagraphTable) bt);
		}
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tableRowId != null ? tableRowId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TableRow)) {
			return false;
		}
		TableRow other = (TableRow) object;
		if ((this.tableRowId == null && other.tableRowId != null) || (this.tableRowId != null && !this.tableRowId.equals(other.tableRowId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.TableRow[ tableRowId=" + tableRowId + " ]";
	}

}
