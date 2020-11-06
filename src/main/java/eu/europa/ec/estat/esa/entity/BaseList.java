package eu.europa.ec.estat.esa.entity;

/**
 *
 * @author fabrix
 */
public interface BaseList {

	public ListType getListTypeId();

	public java.util.List<ListItem> getListItemList();
	
	public Object getParent();

}
