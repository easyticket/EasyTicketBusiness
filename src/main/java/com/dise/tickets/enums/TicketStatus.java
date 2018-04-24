package com.dise.tickets.enums;

public enum TicketStatus {

	ACTIVE(1),GENERATE(2),DEFUSE(3);
	
	private int state;
	
	private TicketStatus(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}

