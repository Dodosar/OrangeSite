package Data;

public enum Elements {

	logintext("logintext", "//*[@id='logInPanelHeading']"),

	loginbtn("loginbtn", "//*[@value='LOGIN']"),

	username("username", "//input[@id='txtUsername']"),

	password("password", "//input[@id='txtPassword']"),

	logout("logout", "//a[@href='/index.php/auth/logout']"),

	userpanel("userpanel", "//*[@id='welcome']"),

	admintab("admintab", "//*[@id='menu_admin_viewAdminModule']"),

	addbtn("addbtn", "//*[@id='btnAdd']"),

	userrole("userrole", "//select[@id='systemUser_userType']"),

	addempname("addempname", "//input[@id='systemUser_employeeName_empName']"),

	addusername("addusername", "//input[@class='formInputText']|//input[@id='systemUser_userName']"),

	addstatus("addstatus", "//select[@id='systemUser_status']"),

	addpassword("addpassword", "//input[@id='systemUser_password']"),

	addconfpassword("addconfpassword", "//input[@id='systemUser_confirmPassword']"),

	addsavebtn("addsavebtn", "//*[@value='Save']|//*[@name='btnSave']"),

	listoftable("listoftable", "//tbody[tr]//td[2]"),

	invalidcredentials("invalidcredentials", "//*[@id='spanMessage']");

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
		for (Elements element : values()) {
			if (element.name().equals(fieldNameToFind)) {
				return element;
			}
		}
		throw new RuntimeException("Cannot find entry for fieldName: '" + fieldNameToFind + "'");

	}

}
