package networking.request;

import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseRegisterFG;
import utility.DataReader;
import utility.Log;

import java.io.IOException;

public class RequestRegisterFG extends GameRequest {

    private String username;
    private String password;
    private String version;

    private ResponseRegisterFG responseRegisterFG;

    public RequestRegisterFG() {
        responses.add(responseRegisterFG = new ResponseRegisterFG());
    }

    @Override
    public void parse() throws IOException {
        version = DataReader.readString(dataInput).trim();
        username = DataReader.readString(dataInput).trim();
        password = DataReader.readString(dataInput).trim();
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("%Connecting to user '%s'", username);
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
            Player player = null;
            if (!username.isEmpty()) {
                //selectID from DB
                //add account to DB
                player = new Player(100, username, password, (short) 1);
                player.setClient(client);
                GameServer.getInstance().setActivePlayer(player);
                client.setPlayer(player);
                responseRegisterFG.setStatus((short) 0); // Login is a success
                responseRegisterFG.setPlayer(player);
                Log.printf("User '%s' has successfully logged in.", player.getUsername());
            } else {
                responseRegisterFG.setStatus((short) 3);
                Log.printf("Please input a username. (v%s)", player.getUsername(), version);
            }
        }

    }
}
