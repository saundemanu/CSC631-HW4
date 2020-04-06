/*
NEW LOBBY RESPONSE
CREATED FOR FLOODED GROUNDS 2.0 4/2
This class is modified from the original WOB
to fit the flooded ground servers.

created by Emanuel.

 */

package networking.response;

import metadata.Constants;
import model.Lobby;
import utility.GamePacket;

public class ResponseLobby extends GameResponse{
    private short status;
    private Lobby lobby;

    public ResponseLobby() {
        responseCode = Constants.SMSG_LOBBY;
    }

    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            for (int id : lobby.getPlayers()) {
                packet.addInt32(id);
            }
            packet.addInt32(lobby.getSize());
            packet.addString(lobby.getPassword());

        }
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
