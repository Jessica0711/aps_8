package br.com.aps.service.util;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public final class XmlToStringJson {
	
	private XmlToStringJson() {}

	private static int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static String converter(BufferedReader buffereReader) {
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(buffereReader.readLine());
			return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		} catch (JSONException | IOException je) {
			System.out.println(je.toString());
			return null;
		}
	}
}
