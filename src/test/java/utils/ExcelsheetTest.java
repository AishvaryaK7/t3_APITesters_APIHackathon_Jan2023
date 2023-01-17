package utils;
public class ExcelsheetTest {
	public static void main(String[] args) {
		String Excelpath = "./ExcelData/TestData.xlsx";
		String Sheetname = "Sheet1";
		Excelutils excel = new Excelutils(Excelpath, Sheetname);
		excel.getCellData(0, 2);
		excel.getrowcount();
	}
}