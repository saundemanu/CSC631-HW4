/*
NEW LOGIN REQUEST
CREATED FOR FLOODED GROUNDS 2.0 4/4
This class is modified from the original WOB
to fit the flooded ground servers.

created by Emanuel.

 */


package networking.request;

import core.GameClient;
import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseLoginFG;
import utility.DataReader;
import utility.Log;

import java.io.IOException;

public class RequestLoginFG extends GameRequest {

    private String username;
    private String password;
    private String version;

    private ResponseLoginFG responseLoginFG;

    public RequestLoginFG() {
        responses.add(responseLoginFG = new ResponseLoginFG());
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
        Player player = null;
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
            if (!username.isEmpty()) {
                if (username.equalsIgnoreCase("test") && password.equals("fg")) {
                    player = new Player(100, "test", "fg", (short) 1);
                } else {
                    player = null;
                }
                if (player == null) {
                    responseLoginFG.setStatus((short) 1);
                    Log.printf("User: '%s' has incorrect credentials");
                } else {
                    player.setClient(client);
                    //TODO: Refactor playerID as username
                    if (client.getPlayer() == null || !player.getUsername().equals(client.getPlayer().getUsername())) {
                        GameClient thread = GameServer.getInstance().getThreadByPlayerID(player.getID());
                        if (thread != null) {
                            responseLoginFG.setStatus((short) 2); // Account is in use
                            thread.removePlayerData();
                            thread.newSession();
                            Log.printf(" User '%s's account is already in use.", username);
                        } else {
                            GameServer.getInstance().setActivePlayer(player);
                            player.setClient(client);
                            client.setPlayer(player);
                            responseLoginFG.setStatus((short) 0); // Login is a success
                            responseLoginFG.setPlayer(player);
                            Log.printf("User '%s' has successfully logged in.", player.getUsername());
                        }
                    }
                }
            }
            } else {
                responseLoginFG.setStatus((short) 3); // Client version not compatible
                Log.printf("User '%s' has failed to log in. (v%s)", player.getUsername(), version);
            }

    }

}

