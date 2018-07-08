package com.dise.tickets.enums;

public enum ExceptionsController {

	 CATEGORY("01"),SOCIALEVENT("02"),TICKET("03");
	
	 
	 private String Cod;

	private ExceptionsController(String cod) {
		Cod = cod;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}
	 
	
}
