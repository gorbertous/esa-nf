package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "esa_text")
@IdClass(EsaTextId.class)
@NamedQueries({ @NamedQuery(name = "EsaText.findAll", query = "SELECT e FROM EsaText e") })
public class EsaText implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id_type")
	private String idType;
	@Id
	@Column(name = "id")
	private Integer id;
	@Id
	@Lob
	@Column(name = "text")
	private String text;
	@Column(name = "heading_path_id")
	private String headingPathId;
	@Column(name = "heading_path_text")
	private String headingPathText;

	public EsaText() {
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHeadingPathId() {
		return headingPathId;
	}

	public void setHeadingPathId(String headingPathId) {
		this.headingPathId = headingPathId;
	}

	public String getHeadingPathText() {
		return headingPathText;
	}

	public void setHeadingPathText(String headingPathText) {
		this.headingPathText = headingPathText;
	}

}
