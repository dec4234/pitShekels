package pitShekelsSrc;

public enum ShekelData {

	CMD1("balance"),
	CMD2("givemoney");
	
	private String value;
	
	private ShekelData(String value) {
		this.value = value;
	}
	
	public String getValue() { return value; }
}
