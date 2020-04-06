package networking.response;

import metadata.Constants;
import model.Player;
import utility.GamePacket;

public class ResponseRegisterFG extends GameResponse {

    private short status;
    private Player player;

    public ResponseRegisterFG() {
        responseCode = Constants.SMSG_AUTHFG;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            packet.addInt32(player.getID());
            packet.addString(player.getUsername());
            packet.addString(player.getPassword());

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
