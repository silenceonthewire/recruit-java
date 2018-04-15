package controllers;

import akka.actor.ActorRef;
import akka.pattern.PatternsCS;
import clients.MyClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Node;
import parsers.NodeToNode;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSResponse;
import play.mvc.*;

import protocols.NodeAction;
import protocols.NodeProtocol;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class HomeController extends Controller {

    private final ActorRef actorRef;
    private final NodeToNode nodeToNode;
    private final HttpExecutionContext executionContext;
    private final MyClient myClient;
    @Inject
    public HomeController(
            @Named("node-actor") ActorRef actorRef, NodeToNode nodeToNode, HttpExecutionContext executionContext,
            MyClient myClient
    ) {
        this.actorRef = actorRef;
        this.nodeToNode = nodeToNode;
        this.executionContext = executionContext;
        this.myClient = myClient;
    }

    public CompletionStage<Result> index() {
        return PatternsCS.ask(actorRef, new NodeProtocol(NodeAction.GET_ALL),1000)
                .thenApply(response -> (List<Node>) response)
                .thenApply(list -> ok(Json.toJson(list.stream().map(nodeToNode).collect(Collectors.toList()))));
    }

    public CompletionStage<Result> getData(){

        return myClient.currentRequest().thenApplyAsync(response -> {

            try {

                return getMappedResult(response);
            } catch (IOException e) {
                e.printStackTrace();
                return badRequest();
            }
        }, executionContext.current());
    }

    private Result getMappedResult(WSResponse response) throws IOException {
        String body = response.getBody();
        ObjectMapper mapper = new ObjectMapper();

        List<Node> nodes = mapper.readValue(body, new TypeReference<List<Node>>(){});
        return ok(views.html.index.render(nodes));
    }

}
