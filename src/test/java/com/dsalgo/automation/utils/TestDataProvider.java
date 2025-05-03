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
		List<Map<String, String>> allRows = ExcelReader.getAllRows("TryCodeEditor");
		return processRows(allRows);
	}

	private Object[][] processRows(List<Map<String, String>> allRows) {
		Object[][] result = new Object[allRows.size()][1];
		for (int i = 0; i < allRows.size(); i++) {
			result[i][0] = allRows.get(i);
		}
		return result;
	}

	@DataProvider(name = "arrayPractieceCode")
	public Object[][] PractieceCode() {

		List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_SearchArray");

		return processRows(allData1);
	}

	@DataProvider(name = "arrayPractieceCode1")
	public Object[][] PractieceCode1() {

		List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_MaxConse");

		return processRows(allData1);
	}

	@DataProvider(name = "arrayPractieceCode2")
	public Object[][] PractieceCode2() {

		List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_FindEvenNum");

		return processRows(allData1);
	}

	@DataProvider(name = "arrayPractieceCode3")
	public Object[][] PractieceCode3() {
		List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_SquaresOfSortedArray");
		return processRows(allData1);
	}

	@DataProvider(name = "pythoncode")
	public Object[][] getData() {

		List<Map<String, String>> allData = ExcelReader.getAllRows("CodeEditor");
		return processRows(allData);
	}

	@DataProvider(name = "pythoncodeData")
	public Object[][] getPythoncodeData() {
		List<Map<String, String>> allData = ExcelReader.getAllRows("Try Here");
		return processRows(allData);
	}

	@DataProvider(name = "dropdownOptions")
	public Object[][] options() {
		return new Object[][] { { "Array" }, { "Linked List" }, { "Stack" }, { "Queue" }, { "Tree" }, { "Graph" } };
	}

	@DataProvider(name = "getstartedOptions")
	public Object[][] getstartedOptions() {
		return new Object[][] { { "Data Structures-Introduction" }, { "Arrays" }, { "Linked List" }, { "Stack" },
				{ "Queue" }, { "Tree" }, { "Graph" } };
	}

	@DataProvider(name = "allInvalidLoginData")
	public Object[][] getAllLoginData() {
		List<Map<String, String>> allData = ExcelReader.getAllRows("SignIn"); // No filtering now!
		return processRows(allData);
	}
}
