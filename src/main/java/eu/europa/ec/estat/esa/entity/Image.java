package eu.europa.ec.estat.esa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "image")
@NamedQueries({
	@NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")})
public class Image extends ParagraphElement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Lob
	@Column(name = "data")
	private byte[] data;

	public Image() {
	}

	public Image(byte[] data) {
		this.data = data;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Image{" + "data=" + data + '}';
	}

}
