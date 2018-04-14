package modules;

import actors.NodeActor;
import com.google.inject.AbstractModule;
import play.libs.akka.AkkaGuiceSupport;

public class NodeModule extends AbstractModule implements AkkaGuiceSupport {

    @Override
    protected void configure() {

        bindActor(NodeActor.class,"node-actor");
    }
}
