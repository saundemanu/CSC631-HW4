package networking.response;

import metadata.Constants;
import model.Game;
import utility.GamePacket;

public class ResponseGameStatus extends GameResponse {

    private Game game;

    public ResponseGameStatus() {
        responseCode = Constants.SMSG_STATUS;
    }

    @Override
    public byte[] constructResponseInBytes() {

        GamePacket packet = new GamePacket(responseCode);
        for (String name : game.getPlayers()) {
            packet.addString(name);
        }
        packet.addFloat(game.getTime());
        packet.addBoolean(game.isHumanWin());
        return packet.getBytes();
    }
}
