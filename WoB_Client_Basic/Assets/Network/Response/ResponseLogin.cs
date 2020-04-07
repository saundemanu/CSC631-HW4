using UnityEngine;

using System;

public class ResponseLoginEventArgs : ExtendedEventArgs {
		
	public short status { get; set; }
	public int user_id { get; set; }
	public string username { get; set; }
	public short level { get; set; }
	public string last_logout { get; set; }
	
	public ResponseLoginEventArgs() {
		event_id = Constants.SMSG_AUTH;
	}
}

public class ResponseLogin : NetworkResponse {
	
	private short status;
	private int user_id;
	private string username;
	private short level;

	public ResponseLogin() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		if (status == 0) {
			user_id = DataReader.ReadInt(dataStream);
			username = DataReader.ReadString(dataStream);
			level = DataReader.ReadShort (dataStream);
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseLoginEventArgs args = null;
		if (status == 0) {
			args = new ResponseLoginEventArgs();
			args.status = status;
			args.user_id = user_id;
			args.username = username;
			args.level = level;
		}

		return args;
	}
}