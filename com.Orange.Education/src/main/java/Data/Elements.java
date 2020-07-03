package Data;


public enum Elements {	
	
	logintext("logintext","//*[@id='logInPanelHeading']");	
	
	private final String label;
	private final String xpath;
	
	private Elements(String label, String xpath) {
		this.label = label;
		this.xpath = xpath;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getXpath() {
		return xpath;
	}
	
	public static Elements getEntryForElementName(String fieldNameToFind) {
		for(Elements element : values()) {
			if(element.name().equals(fieldNameToFind)) {
				return element;
			}
		}
		throw new RuntimeException(
			"Cannot find entry for fieldName: '" + fieldNameToFind + "'"
		);
		
	}
	
	
}
