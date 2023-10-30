package praticeTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
public class Excel {

	public static void main(String[] args) {
		

		   
		        String excelFilePath = "C:Users\\b.anil kumar setty\\Downloads\\anilkumar.xlsx";

		        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
		             Workbook workbook = new XSSFWorkbook(inputStream)) {

		            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

		            for (Row row : sheet) {
		                Cell empNoCell = row.getCell(0);
		                Cell empNameCell = row.getCell(1);
		                Cell empDesignationCell = row.getCell(2);
		                Cell empSalaryCell = row.getCell(3);
		                Cell empDepartmentCell = row.getCell(4);

		                if (empNoCell != null && empNameCell != null && empDesignationCell != null
		                        && empSalaryCell != null && empDepartmentCell != null) {

		                    String empNo = getStringValue(empNoCell);
		                    String empName = getStringValue(empNameCell);
		                    String empDesignation = getStringValue(empDesignationCell);
		                    String empSalary = getCellValueAsString(empSalaryCell);
		                    String empDepartment = getStringValue(empDepartmentCell);

		                    System.out.println("EMP No: " + empNo);
		                    System.out.println("EMP Name: " + empName);
		                    System.out.println("EMP Designation: " + empDesignation);
		                    System.out.println("EMP Salary: " + empSalary);
		                    System.out.println("EMP Department: " + empDepartment);
		                    System.out.println("-------------------------");
		                }
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    private static String getStringValue(Cell cell) {
		        if (cell.getCellType() == CellType.STRING) {
		            return cell.getStringCellValue();
		        } else {
		            return "";
		        }
		    }

		    private static String getCellValueAsString(Cell cell) {
		        if (cell.getCellType() == CellType.NUMERIC) {
		            return Double.toString(cell.getNumericCellValue());
		        } else if (cell.getCellType() == CellType.STRING) {
		            return cell.getStringCellValue();
		        } else {
		            return "";
		        }
		    }
	

	}


