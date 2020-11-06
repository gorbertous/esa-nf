package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class FileInfoDto {

	private String name;
	private long lenght;
	private long modificationDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLenght() {
		return lenght;
	}

	public void setLenght(long lenght) {
		this.lenght = lenght;
	}

	public long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(long modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		return "FileInfoDto{" + "name=" + name + ", lenght=" + lenght + ", modificationDate=" + modificationDate + '}';
	}

}
