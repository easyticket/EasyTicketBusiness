package com.dise.tickets.enums;

public enum ExceptionsOperations {
	
	 GET("01"),POST("02"),PUT("03"),DELETE("04");
	
	 
	 private String Cod;

	private ExceptionsOperations(String cod) {
		Cod = cod;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}
	 
	
}
