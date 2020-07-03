package Data;

public enum DataValues {
	
	Amazon("Best Sellers in Beauty & Personal Care");
	
	public final String label;
	
	private DataValues(String label) {
		this.label = label;
	}
	
	public String get() {
		return this.label;
	}
	
}
