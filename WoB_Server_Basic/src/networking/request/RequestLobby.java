package networking.request;

import model.Lobby;
import model.Player;
import networking.response.ResponseLobby;
import utility.Log;

import java.io.IOException;
import java.util.ArrayList;

public class RequestLobby extends GameRequest{

    private String host;
    private ResponseLobby responseLobby;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void parse() throws IOException {
        responses.add(responseLobby = new ResponseLobby());
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("Lobby request recieved");
    }
}
