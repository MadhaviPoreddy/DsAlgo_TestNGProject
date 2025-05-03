package com.dsalgo.automation.utils;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "Register")
	public Object[][] getRegisterData() {

		List<Map<String, String>> allRows = ExcelReader.getAllRows("Register");
		return processRows(allRows);
	}
	
	@DataProvider(name = "CodeEditor")
	public Object[][] getTryEditordata() {
		List<Map<String, String>> allRows = ExcelReader.getAllRows("CodeEditor");
		return processRows(allRows);
	}
	
	private Object[][] processRows(List<Map<String, String>> allRows) {
	    Object[][] result = new Object[allRows.size()][1];
	    for (int i = 0; i < allRows.size(); i++) {
	        result[i][0] = allRows.get(i);
	    }
	    return result;
	}
}
