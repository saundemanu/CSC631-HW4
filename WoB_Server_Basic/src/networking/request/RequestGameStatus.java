package networking.request;

import networking.response.ResponseGameStatus;
import utility.Log;

import java.io.IOException;

public class RequestGameStatus extends GameRequest {

    private ResponseGameStatus responseGameStatus;

    //Do not remove this constructor even though the IDE claims it is not being used anywhere. It is being called by reflection.
    public RequestGameStatus() {
        responses.add(responseGameStatus = new ResponseGameStatus());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("Game Status Requested");
    }
}


