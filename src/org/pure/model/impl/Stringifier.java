package org.pure.model.impl;

import org.pure.model.PureString;

abstract class SyntaxString {
	/**
	 * Transforms a String object into a string you would
	 * write in a sourcefile
	 * the string enclosed in >><<
	 * >>hello "
	 *  <<
	 * turns into
	 * "hello \"\n "
	 * 
	 * @param str	input string
	 * @param quote char to quote the string in
	 * @return		syntactic representation of str
	 */
	static String escape(String str,char quote) {
		StringBuilder sb = new StringBuilder();
		sb.append(quote);
		sb.append(str.replaceAll(Character.toString(quote), "\\"+quote));
		sb.append(quote);
		return sb.toString();
	}
	
	/**
	 * Reverses the effects in the function escape
	 */
	static String unescape(String str, char quote) {
		StringBuilder sb = new StringBuilder(
				str.replaceAll("\\"+quote, Character.toString(quote)));
		
		// remove quotes
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
