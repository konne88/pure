package org.pure.model.impl;

import org.pure.model.PureChars;

public class PureCharsImpl extends PureStringImpl implements PureChars {
	public PureCharsImpl(String s){
		super(s);
	}
	
	@Override
	public String toString() {
		return SyntaxString.escape(str, '\'');
	}
}
