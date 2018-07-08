package com.dise.tickets.enums;

public enum ExceptionsModules {
	
	 BUSUNESS("01");
	 
	 private String Cod;

	private ExceptionsModules(String cod) {
		Cod = cod;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}
	 
	 

}
