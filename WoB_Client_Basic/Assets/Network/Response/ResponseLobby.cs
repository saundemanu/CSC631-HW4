using UnityEngine;

using System;

public class ResponseLobbyEventArgs : ExtendedEventArgs {
		
	public short status { get; set; }
	public int user_id { get; set; }
	public int size { get; set; }
    public string password { get; set; }

	
	public ResponseLobbyEventArgs() {
		event_id = Constants.SMSG_AUTH;
	}
}

public class ResponseLobby : NetworkResponse {
	
	private short status;
	private int user_id;
	private int size;
	private string password;

	public ResponseLobby() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		if (status == 0) {
			user_id = DataReader.ReadInt(dataStream);
			size = DataReader.ReadInt(dataStream);
			password = DataReader.ReadString(dataStream);
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseLobbyEventArgs args = null;
		if (status == 0) {
			args = new ResponseLobbyEventArgs();
			args.status = status;
			args.user_id = user_id;
			args.size = size;
			args.password = password;
		}

		return args;
	}
}