package org.pure.model.impl;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import org.pure.model.PureString;

public class PureStringImpl implements PureString {
	public PureStringImpl(String str) {
		this.str = SyntaxString.unescape(str,'"');
	}

	protected String str;

	@Override
	public String toString() {
		return SyntaxString.escape(str, '"');
	}
	
	// delegate all String methods
	
	public char charAt(int index) {
		return str.charAt(index);
	}

	public int codePointAt(int index) {
		return str.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return str.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return str.codePointCount(beginIndex, endIndex);
	}

	public int compareTo(String arg0) {
		return str.compareTo(arg0);
	}

	public int compareToIgnoreCase(String str) {
		return str.compareToIgnoreCase(str);
	}

	public String concat(String str) {
		return str.concat(str);
	}

	public boolean contains(CharSequence s) {
		return str.contains(s);
	}

	public boolean contentEquals(CharSequence arg0) {
		return str.contentEquals(arg0);
	}

	public boolean contentEquals(StringBuffer sb) {
		return str.contentEquals(sb);
	}

	public boolean endsWith(String suffix) {
		return str.endsWith(suffix);
	}

	public boolean equals(Object arg0) {
		return str.equals(arg0);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return str.equalsIgnoreCase(anotherString);
	}

	public byte[] getBytes() {
		return str.getBytes();
	}

	public byte[] getBytes(Charset charset) {
		return str.getBytes(charset);
	}

	public byte[] getBytes(String charsetName)
			throws UnsupportedEncodingException {
		return str.getBytes(charsetName);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		str.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public int hashCode() {
		return str.hashCode();
	}

	public int indexOf(int arg0, int arg1) {
		return str.indexOf(arg0, arg1);
	}

	public int indexOf(int ch) {
		return str.indexOf(ch);
	}

	public int indexOf(String str, int fromIndex) {
		return str.indexOf(str, fromIndex);
	}

	public int indexOf(String str) {
		return str.indexOf(str);
	}

	public String intern() {
		return str.intern();
	}

	public boolean isEmpty() {
		return str.isEmpty();
	}

	public int lastIndexOf(int arg0, int arg1) {
		return str.lastIndexOf(arg0, arg1);
	}

	public int lastIndexOf(int ch) {
		return str.lastIndexOf(ch);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return str.lastIndexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return str.lastIndexOf(str);
	}

	public int length() {
		return str.length();
	}

	public boolean matches(String regex) {
		return str.matches(regex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return str.offsetByCodePoints(index, codePointOffset);
	}

	public boolean regionMatches(boolean arg0, int arg1, String arg2, int arg3,
			int arg4) {
		return str.regionMatches(arg0, arg1, arg2, arg3, arg4);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return str.regionMatches(toffset, other, ooffset, len);
	}

	public String replace(char arg0, char arg1) {
		return str.replace(arg0, arg1);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return str.replace(target, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return str.replaceAll(regex, replacement);
	}

	public String replaceFirst(String regex, String replacement) {
		return str.replaceFirst(regex, replacement);
	}

	public String[] split(String regex, int limit) {
		return str.split(regex, limit);
	}

	public String[] split(String regex) {
		return str.split(regex);
	}

	public boolean startsWith(String prefix, int toffset) {
		return str.startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return str.startsWith(prefix);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return str.subSequence(beginIndex, endIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}

	public String substring(int beginIndex) {
		return str.substring(beginIndex);
	}

	public char[] toCharArray() {
		return str.toCharArray();
	}

	public String toLowerCase() {
		return str.toLowerCase();
	}

	public String toLowerCase(Locale arg0) {
		return str.toLowerCase(arg0);
	}

	public String toUpperCase() {
		return str.toUpperCase();
	}

	public String toUpperCase(Locale arg0) {
		return str.toUpperCase(arg0);
	}

	public String trim() {
		return str.trim();
	}
}
