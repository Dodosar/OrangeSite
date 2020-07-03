package Data;

public enum DataValues {	
	
	LoginText("LOGIN Panel"),
	
	TitleMainPage("OrangeHRM");
	
	
	
	private final String label;
	
	private DataValues(String label) {
		this.label = label;
	}
	
	public String get() {
		return this.label;
	}
	
}
