package org.pure.model.impl;

import org.pure.model.PureNumber;

public class PureNumberImpl implements PureNumber {
	public PureNumberImpl(String v) {
		num = Double.valueOf(v);
	}
	
	@Override
	public String toString() {
		String s = Double.toString(num);
		// remove 0 after the comma
		return s.replaceFirst("\\.0+$", "");
	}
	
	private double num;
}
