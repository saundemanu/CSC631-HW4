using UnityEngine;

using System;

public class RequestLobby : NetworkRequest {

	public RequestLobby() {
		request_id = Constants.CMSG_AUTH;
	}
	
	public void send(string lobby, string username, string password) {
	    packet = new GamePacket(request_id);
		packet.addString(lobby);
        packet.addString(username);
		packet.addString(password);
	}
}