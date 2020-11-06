package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class EsaTextDto {

	private String id_type;
	private Integer id;
	private String text;
	private String heading_path_id;
	private String heading_path_text;

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
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

	public String getHeading_path_id() {
		return heading_path_id;
	}

	public void setHeading_path_id(String heading_path_id) {
		this.heading_path_id = heading_path_id;
	}

	public String getHeading_path_text() {
		return heading_path_text;
	}

	public void setHeading_path_text(String heading_path_text) {
		this.heading_path_text = heading_path_text;
	}

}
