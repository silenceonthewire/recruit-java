package protocols;

public class NodeProtocol {

    public NodeAction nodeAction;

    public NodeProtocol(){

    }

    public NodeProtocol(NodeAction action){

        this.nodeAction = action;
    }

    public NodeAction getAction() {
        return nodeAction;
    }
}
