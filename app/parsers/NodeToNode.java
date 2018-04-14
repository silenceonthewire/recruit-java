package parsers;

import models.Node;

import java.util.function.Function;

public class NodeToNode implements Function<Node, Node> {


    @Override
    public Node apply(Node node) {
        return node;
    }
}
