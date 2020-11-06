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
@Table(name = "table_header")
@NamedQueries({
	@NamedQuery(name = "TableHeader.findAll", query = "SELECT t FROM TableHeader t")})
public class TableHeader implements Serializable, BaseRow {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "table_header_id")
	private Integer tableHeaderId;
	@JoinColumn(name = "esa_table_element_id", referencedColumnName = "element_id")
	@ManyToOne
	private EsaTable esaTableElementId;
	@JoinColumn(name = "paragraph_table_paragraph_element_id", referencedColumnName = "paragraph_element_id")
	@ManyToOne
	private ParagraphTable paragraphTableParagraphElementId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tableHeaderId")
	private List<TableCell> tableCellList;

	public TableHeader() {
	}

	public TableHeader(Integer tableHeaderId) {
		this.tableHeaderId = tableHeaderId;
	}

	public Integer getTableHeaderId() {
		return tableHeaderId;
	}

	public void setTableHeaderId(Integer tableHeaderId) {
		this.tableHeaderId = tableHeaderId;
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
	public int hashCode() {
		int hash = 0;
		hash += (tableHeaderId != null ? tableHeaderId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TableHeader)) {
			return false;
		}
		TableHeader other = (TableHeader) object;
		if ((this.tableHeaderId == null && other.tableHeaderId != null) || (this.tableHeaderId != null && !this.tableHeaderId.equals(other.tableHeaderId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "eu.europa.ec.estat.esa.entity.TableHeader[ tableHeaderId=" + tableHeaderId + " ]";
	}

	@Override
	public void setTableId(BaseTable bt) {
		if (bt instanceof EsaTable) {
			this.setEsaTableElementId((EsaTable) bt);
		} else {
			this.setParagraphTableParagraphElementId((ParagraphTable) bt);
		}
	}

}
