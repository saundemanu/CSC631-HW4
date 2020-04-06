/*
NEW LOGIN RESPONSE
CREATED FOR FLOODED GROUNDS 2.0 4/4
This class is modified from the original WOB
to fit the flooded ground servers.

created by Emanuel.

 */


package networking.response;

import metadata.Constants;
import model.Player;
import utility.GamePacket;

public class ResponseLoginFG extends GameResponse {

    private short status;
    private Player player;

    public ResponseLoginFG() {
        responseCode = Constants.SMSG_AUTHFG;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            packet.addInt32(player.getID());
            packet.addString(player.getUsername());
            packet.addShort16(player.getLevel());
        }
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
