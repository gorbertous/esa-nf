package eu.europa.ec.estat.esa.dto;

/**
 *
 * @author fabrix
 */
public class TextBlockDto extends ElementDto {

	private String text;
	private FootnoteDto footnote;
	private LinkDto link;
	private ContainerElement containerType;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public FootnoteDto getFootnote() {
		return footnote;
	}

	public void setFootnote(FootnoteDto footnote) {
		this.footnote = footnote;
	}

	public LinkDto getLink() {
		return link;
	}

	public void setLink(LinkDto link) {
		this.link = link;
	}

	public ContainerElement getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerElement containerType) {
		this.containerType = containerType;
	}

	@Override
	public String toString() {
		return "TextBlockDto{" + "text=" + text + ", footnote=" + footnote + ", link=" + link + ", containerType=" + containerType + '}';
	}

}
