package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class ListItemDto extends TextBlockDto {

	private short indentationLevel;

	private ListDto childNestedListId;

	public short getIndentationLevel() {
		return indentationLevel;
	}

	public void setIndentationLevel(short indentationLevel) {
		this.indentationLevel = indentationLevel;
	}

	public ListDto getChildNestedListId() {
		return childNestedListId;
	}

	public void setChildNestedListId(ListDto childNestedListId) {
		this.childNestedListId = childNestedListId;
	}

	@Override
	public String toString() {
		return super.toString() + " ListItemDto{" + "indentationLevel=" + indentationLevel + ", childNestedListId=" + childNestedListId + '}';
	}

}
