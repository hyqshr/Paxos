package shared;

import java.io.Serializable;

public class Message implements Serializable{
	public String type;
	public String key;
	public String val;
	public String method;
	public Message(String type){
		this.type = type;
	}
	public Message(String type, String key, String val, String method){
		this.type = type;
		this.key = key;
		this.val = val;
		this.method = method;
	}
	
	public boolean equals(Object other){
		if(other instanceof Message){
			return (((Message) other).type.equals(type));
		}else{
			return false;
		}
		
	}
}
