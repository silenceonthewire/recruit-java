package repositories;

import models.ExcelData;

import java.util.List;

public interface Files {

    List<ExcelData> readFile(String filePath);
}
