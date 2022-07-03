package com.devsuperior.work.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String nome) {
		super(nome);
	}
	

}
