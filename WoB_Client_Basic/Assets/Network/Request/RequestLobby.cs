using UnityEngine;

using System;

public class RequestLobby : NetworkRequest {

	public RequestLobby() {
		request_id = Constants.CMSG_LOBBY;
	}
	
	public void send(int user_id, int size, string password) {
	    packet = new GamePacket(request_id);
		packet.addInt32(user_id);
		packet.addInt32(size);
		packet.addString(password);
	}
}