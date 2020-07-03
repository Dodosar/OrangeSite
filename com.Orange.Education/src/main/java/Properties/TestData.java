package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
	public static final String PATH_TO_TEST_DATA = "C:\\Users\\Dima\\git\\OrangeSite\\com.Orange.Education\\src\\main\\resources\\config.properties";
	
	public static String value(String inputValue) {
		FileInputStream fileinputStream;
		Properties properties = new Properties();
		try {
			fileinputStream = new FileInputStream(PATH_TO_TEST_DATA);
			properties.load(fileinputStream);
			return properties.getProperty(inputValue);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
