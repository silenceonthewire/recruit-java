package models;

import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;

public class Node {

    @Constraints.Required
    public Long id;

    public String name;

    public List<Node> nodes = new ArrayList<Node>();
}
