package org.pure.model.impl;

import org.pure.model.PureToken;

public class PureTokenImpl implements PureToken {
	public PureTokenImpl(String token){
		this.token = token.charAt(0);
	}
	
	@Override 
	public String toString() {
		return Character.toString(token);
	}
	
	private char token;
}
