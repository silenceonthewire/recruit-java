package repositories;

import models.ExcelData;
import models.Node;

import java.util.List;

public interface Nodes {

    List<Node> getNodes(List<ExcelData> excelDataList);
}
