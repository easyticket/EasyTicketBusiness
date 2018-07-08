package com.dise.tickets.enums;

public enum ExceptionsSpecificError {
	
	 NOTEXIST("01"),ISEMPTY("02");
	 
	 private String Cod;

	private ExceptionsSpecificError(String cod) {
		Cod = cod;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}
	 

}
