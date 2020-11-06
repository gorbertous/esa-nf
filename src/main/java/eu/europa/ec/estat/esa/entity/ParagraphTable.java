package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "paragraph_table")
@NamedQueries({
	@NamedQuery(name = "ParagraphTable.findAll", query = "SELECT p FROM ParagraphTable p")})
public class ParagraphTable extends ParagraphElement implements Serializable, BaseTable {

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paragraphTableParagraphElementId")
	private List<TableRow> tableRowList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paragraphTableParagraphElementId")
	private List<TableHeader> tableHeaderList;

	public ParagraphTable() {
	}

	public ParagraphTable(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<TableRow> getTableRowList() {
		if (this.tableRowList == null) {
			this.tableRowList = new ArrayList<>();
		}
		return tableRowList;
	}

	@Override
	public void setTableRowList(List<TableRow> tableRowList) {
		this.tableRowList = tableRowList;
	}

	@Override
	public List<TableHeader> getTableHeaderList() {
		if (this.tableHeaderList == null) {
			this.tableHeaderList = new ArrayList<>();
		}
		return tableHeaderList;
	}
	
	public void setTableHeaderList(List<TableHeader> tableHeaderList) {
		this.tableHeaderList = tableHeaderList;
	}

	@Override
	public String toString() {
		return "ParagraphTable{" + "code=" + code + ", description=" + description + '}';
	}

	@Override
	public void setContainerId(Object id) {
		this.setParagraphId((Paragraph) id);
	}

}
