package repositories;

import models.ExcelData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFile implements Files {

    public List<ExcelData> readFile(String filePath){

        List<ExcelData> excelDataList = new LinkedList<ExcelData>();

        try {

            readExcelFile(excelDataList, filePath);

        } catch(Exception e) {
            e.printStackTrace();
        }

        excelDataList.remove(0);
        return excelDataList;
    }

    private void readExcelFile(List<ExcelData> excelDataList, String filePath) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(filePath));
        Sheet sheet = workbook.getSheetAt(0);
        for(Row row: sheet) {

            ExcelData excelData = new ExcelData();
            excelData.firstLevel = row.getCell(0);
            excelData.secondLevel = row.getCell(1);
            excelData.thirdLevel = row.getCell(2);
            excelData.id = row.getCell(3);
            excelDataList.add(excelData);
        }
    }
}
