package automateIt.utils;


import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class ExcelReader {
    private XSSFWorkbook workbook;
    private XSSFSheet worksSheet;

    //public List<Map<String,String>>


    private XSSFWorkbook getWorkBookInstance(String excelFilePath) {

        if(workbook==null) {
            try {
                return new XSSFWorkbook(new FileInputStream(new File(excelFilePath)));

            } catch (EncryptedDocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    private XSSFSheet getSheetByName(String sheetName) {
        return workbook.getSheet(sheetName);
    }

    public Map<String,List<Map<String,String>>> readDataFromExcel(String excelFilePath,String sheetName){
        workbook=getWorkBookInstance(excelFilePath);
        worksSheet=getSheetByName(sheetName);
        Map<String,List<Map<String,String>>> notationMappedRows= new HashMap<>();;
 
        List<String> notations = new ArrayList<String>();
		boolean skipFirstRow = true;
		for (Row row : worksSheet) {
			if (skipFirstRow) { skipFirstRow = false; continue; }
			Cell cell = row.getCell(0);
			if (cell != null) {
				String notation = cell.getStringCellValue();
				if (notation != null && !notation.isEmpty()) {
					if (! notations.contains(notation)) {
						notations.add(notation);
					}
				}
			}
		}
		
		int columnCount = 0;
		List<String> attributes = new ArrayList<String>();
		for (Iterator<Cell> ite = worksSheet.getRow(0).cellIterator(); 
													ite.hasNext();) {
			Cell cell = ite.next();
			if (Cell.CELL_TYPE_BLANK != cell.getCellType()) {
				attributes.add(cell.getStringCellValue());
				++columnCount;
			}
		}
		attributes.remove(0);
        
		for (String notation : notations) {
			 List<Map<String,String>> excelRows= null;
			if (notationMappedRows.containsKey(notation)) {
				excelRows = notationMappedRows.get(notation);
			} else {
				excelRows = new ArrayList<Map<String, String>>();
				notationMappedRows.put(notation, excelRows);
			}
			skipFirstRow = true;
			for (Row row : worksSheet) {
				if (skipFirstRow) { skipFirstRow = false; continue; }
				List<Cell> data = new ArrayList<Cell>();
				
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					data.add(cell);
				}
				if (data.size() > 0) {
					Map<String, String> keyValueRow = 
						new HashMap<String, String>();
					Cell notationCell = data.get(0);
					if (notationCell != null) {
						String cellNotation = notationCell
											.getStringCellValue();
						if (notation.equals(cellNotation)) {
							for (int j = 1; j < data.size(); j++) {
								String fKey = attributes.get(j - 1);
								String fValue=null;
								if(data.get(j)!=null)
								fValue = data.get(j).getStringCellValue();
								keyValueRow.put(fKey, fValue);
							}
							excelRows.add(keyValueRow);
						}	
					}
				}
			}
		}     
        return notationMappedRows;
    }
    
}
