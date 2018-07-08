package com.dise.tickets.util;

import com.dise.tickets.enums.ExceptionsController;
import com.dise.tickets.enums.ExceptionsModules;
import com.dise.tickets.enums.ExceptionsOperations;
import com.dise.tickets.enums.ExceptionsSpecificError;

public class CreateMessageError {

	ExceptionsModules module;
	ExceptionsController controller;
	ExceptionsOperations operation;
	ExceptionsSpecificError error;
	
	public CreateMessageError(ExceptionsModules module, ExceptionsController controller, ExceptionsOperations operation,
			ExceptionsSpecificError error) {
		super();
		this.module = module;
		this.controller = controller;
		this.operation = operation;
		this.error = error;
	}
	
	public String fullMessageError() {
		return codError()+"-"+messageError();
	}
	
	public String messageError() {
		return "Modulo: "+module+" Controllador: "+controller+" Operacion: "+operation+" Error: "+error;
	}
	public String codError() {
		return module.getCod()+controller.getCod()+operation.getCod()+error.getCod();
	}
	
	
	
	
	
	
}
