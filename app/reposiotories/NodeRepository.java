package reposiotories;

import models.ExcelData;
import models.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodeRepository implements Files, Nodes {

    public final String filePath = "/srv/data/test1.xlsx";

    public List<Node> createNodes(){

        List<ExcelData> excelDataList = readFile(filePath);
        List<Node> nodes = getNodes(excelDataList);
        return nodes;
    }

    public List<Node> getNodes(List<ExcelData> excelDataList){

        List<Node> nodes = new LinkedList<>();
        for(ExcelData excelData: excelDataList){

            if(!excelData.firstLevel.toString().trim().equals("")){
                createFirstNode(nodes, excelData);
            } else if(!excelData.secondLevel.toString().trim().equals("")){

                createSecondNode(nodes, excelData);
            } else if (!excelData.thirdLevel.toString().trim().equals("")){

                createThirdNode(nodes, excelData);
            } else {

            }

        }

        return nodes;
    }

    private void createThirdNode(List<Node> nodes, ExcelData excelData) {
        Node node = new Node();
        Double id = excelData.id.getNumericCellValue();
        node.id = id.longValue();
        node.name = excelData.thirdLevel.getStringCellValue();
        Node firstNode = nodes.get(nodes.size() - 1);
        Node secondNode = firstNode.nodes.get(firstNode.nodes.size() - 1);
        secondNode.nodes.add(node);
    }

    private void createSecondNode(List<Node> nodes, ExcelData excelData) {
        Node node = new Node();
        Double id = excelData.id.getNumericCellValue();
        node.id = id.longValue();
        node.name = excelData.secondLevel.getStringCellValue();
        node.nodes = new ArrayList<>();
        Node firstNode = nodes.get(nodes.size() - 1);
        firstNode.nodes.add(node);
    }

    private void createFirstNode(List<Node> nodes, ExcelData excelData) {
        Node node = new Node();
        Double id = excelData.id.getNumericCellValue();
        node.id = id.longValue();
        node.name = String.valueOf(excelData.firstLevel);
        node.nodes = new ArrayList<>();
        nodes.add(node);
    }

    public List<ExcelData> readFile(String filePath){

        ReadFile readFile = new ReadFile();
        return readFile.readFile(filePath);
    }
}
