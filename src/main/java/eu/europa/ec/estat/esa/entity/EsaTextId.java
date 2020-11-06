package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fabrix
 */
public class EsaTextId implements Serializable {

	private String idType;
	private Integer id;
	private String text;

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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.idType);
		hash = 59 * hash + Objects.hashCode(this.id);
		hash = 59 * hash + Objects.hashCode(this.text);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final EsaTextId other = (EsaTextId) obj;
		if (!Objects.equals(this.idType, other.idType)) {
			return false;
		}
		if (!Objects.equals(this.text, other.text)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EsaTextId{" + "idType=" + idType + ", id=" + id + ", text=" + text + '}';
	}

}
