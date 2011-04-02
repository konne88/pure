package org.pure.model.impl;

import org.pure.model.PureIdentifier;

public class PureIdentifierImpl implements PureIdentifier {
	public PureIdentifierImpl(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	private String name;
}
