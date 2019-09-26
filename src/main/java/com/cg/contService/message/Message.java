package com.cg.contService.message;

import java.util.UUID;

public class Message<T> {
	
	private String messageType;
	private String sender = "contable-service";
	private String label = "";
	//private String id = UUID.randomUUID().toString();
	private T payload;
	
	public Message() {
		
	}
	public Message(String messageType, T payload) {
		this.messageType = messageType;
		this.payload = payload;
		//this.id = UUID.randomUUID().toString();
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}
//	@Override
//	public String toString() {
//		return "Message [messageType=" + messageType + ", sender=" + sender +  ", payload=" + payload
//				+ "]";
//	}

}
