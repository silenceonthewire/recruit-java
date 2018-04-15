package actors;

import akka.actor.AbstractActor;
import models.Node;
import protocols.NodeProtocol;
import repositories.NodeRepository;

import java.util.List;

public class NodeActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(NodeProtocol.class, nodeProtocol -> {
                    switch (nodeProtocol.getAction()){
                        case GET_ALL:
                            sender().tell(getAll(), self());
                            break;
                    }
                }).build();
    }

    private List<Node> getAll() {

        NodeRepository nodeRepository = new NodeRepository();
        return nodeRepository.createNodes();
    }
}
