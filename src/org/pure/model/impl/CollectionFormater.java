package org.pure.model.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

abstract public class CollectionFormater {
	protected enum Brackets {
		PARENTHESIS('(',')'),
		BRACKETS('[',']'),
		BRACES('{','}');
		
		Brackets(char open,char close) {
			this.open = open;
			this.close = close;
		}
		
		final public char open;
		final public char close;
	}
	
	/**
	 * @return	returns the next item in the collection
	 * 			return null if there is no more item
	 */
	protected abstract String nextItem();
	/** 
	 * sets open and close to the according parenthesis
	 */
	protected abstract Brackets getBrackets();
	
	@Override
	/** Formats a collection
	 *  If the parenthesis are [ and ]
	 *  An empty collection is rendered as 
	 *  []
	 *  A collection with one single line item is rendered as
	 *  [object]
	 *  A collection with multiple items is rendered as
	 *  [
	 *    item,
	 *    item_line1
	 *    item_line2,
	 *    item
	 *  ]
	 */
	public String toString() {
		Brackets br = getBrackets();
		StringBuilder sb = new StringBuilder();
		sb.append(br.open);
		try {
			String item = nextItem();
			if(item != null){
				// there is at least one item
				BufferedReader reader;
				String line;
				// number of lines
				int count = 0;
				sb.append('\n');
				// iterate over all objects in the list
				do {
					// iterate over every single line in the item
					// to prepend whitespace for indentation
					reader = new BufferedReader(new StringReader(item));
					line = reader.readLine();
					// line shouldn't be null, which object would map to an empty string?
					sb.append("  ").append(line);
					++count;
					while((line = reader.readLine()) != null) {
						sb.append("\n  ").append(line);
						++count;
					};
					sb.append(",\n");
				} while ((item = nextItem()) != null);
				// remove the last ,
				sb.deleteCharAt(sb.length()-2);
				if(count == 1){
					// also remove the first and last newline
					// also remove first indentation
					sb.deleteCharAt(sb.length()-1);
					sb.delete(1,4);
				}
			}
		} catch (IOException e) {
			// StringBuffers don't have IOExceptions
			assert false;
		}
		sb.append(br.close);
		return sb.toString();
	}
}
