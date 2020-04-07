using UnityEngine;

using System;

public class RequestLobby : NetworkRequest {

	public RequestLobby() {
		request_id = Constants.CMSG_AUTH;
	}
	
	public void send(string user_id,string lobby, string password) {
	    packet = new GamePacket(request_id);
		packet.addString(user_id);
		packet.addString(lobby);
		packet.addString(password);
	}
}