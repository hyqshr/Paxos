package Coordinator;

import shared.Message;

public interface ResponseEvent {
	public void notify(Message message);
}
