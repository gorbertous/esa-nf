package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class FileElementDto {

	private int documentId;
	private String fileName;
	private String mimeType;
	private String data;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileElementDto{" + "documentId=" + documentId + ", fileName=" + fileName + ", mimeType=" + mimeType + '}';
	}

}
