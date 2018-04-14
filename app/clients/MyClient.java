package clients;

import play.libs.ws.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class MyClient implements WSBodyReadables,WSBodyWritables {

    private final WSClient ws;

    @Inject
    public MyClient(WSClient ws){

        this.ws = ws;
    }

    public CompletionStage<WSResponse> currentRequest(){

        CompletionStage<WSResponse> wsRequest = ws.url("http://localhost:9000").get();
        return wsRequest;
    }
}
