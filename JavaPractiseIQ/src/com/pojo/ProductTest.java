package com.pojo;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {

	public static void main(String[] args) {
		// POJO to JSON
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		String[] sellerArray = { "XYZ", "Private Solutins", "GRANT" };
		Product product = new Product("Mac Book", 1000, "White", sellerArray);
		try {
			String jsonString = jsonSerializer.serialize(product);
			System.out.println(jsonString);
		} catch (SerializeException e) {
			e.printStackTrace();
		}

		// POJO to XML
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_SQ_READABLE;
		try {
			System.out.println(xmlSerializer.serialize(product));
		} catch (SerializeException e) {
			e.printStackTrace();
		}

		// POJO to HTML => Table is getting created
		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
		try {
			System.out.println(htmlSerializer.serialize(product));
		} catch (SerializeException e) {
			e.printStackTrace();
		}
		
		
		// Deserialization JSON to POJO
		JsonParser jsonParser = JsonParser.DEFAULT;
		String jsonVal = "{\r\n"
				+ "	\"color\": \"White\",\r\n"
				+ "	\"name\": \"Mac Book\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellerNames\": [\r\n"
				+ "		\"XYZ\",\r\n"
				+ "		\"Private Solutins\",\r\n"
				+ "		\"GRANT\"\r\n"
				+ "	]\r\n"
				+ "}";
		try {
			Product pro = jsonParser.parse(jsonVal, Product.class);
			System.out.println(pro);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
