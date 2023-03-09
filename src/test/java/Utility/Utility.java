package Utility;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utility {

	public static RequestSpecification reqspec;
	
	
	public RequestSpecification requestSpec() throws IOException {
		if (reqspec==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqspec = new RequestSpecBuilder()
				.setBaseUri(getPropertyVal("url"))
				.setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return reqspec;
		}
		return reqspec;
	}
	public String getPropertyVal(String key) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\java\\utility\\data.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
}
