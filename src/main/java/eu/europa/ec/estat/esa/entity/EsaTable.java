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
@Table(name = "esa_table")
@NamedQueries({
	@NamedQuery(name = "EsaTable.findAll", query = "SELECT e FROM EsaTable e")})
public class EsaTable extends Element implements Serializable, BaseTable {

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "esaTableElementId")
	private List<TableRow> tableRowList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "esaTableElementId")
	private List<TableHeader> tableHeaderList;

	public EsaTable() {
	}

	public EsaTable(String code) {
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
	public String toString() {
		return "EsaTable{" + "code=" + code + ", description=" + description + '}';
	}

	@Override
	public void setContainerId(Object id) {
		this.setHeadingId((Heading) id);
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

}
