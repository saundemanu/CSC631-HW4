using UnityEngine;

using System;

public class RequestGameStatus : NetworkRequest {

	public RequestGameStatus() {
		request_id = Constants.CMSG_GM_STATUS;
	}
	
	public void send(string name, float time, bool win) {
	    packet = new GamePacket(request_id);
		packet.addString(name);
		packet.addFloat32(time);
		packet.addBool(win);
	}
}