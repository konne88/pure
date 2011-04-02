package org.pure.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.pure.model.PureExpression;
import org.pure.model.PureObject;

public class PureExpressionImpl implements PureExpression {
	public PureExpressionImpl(PureObject a, PureObject b) {
		list = new ArrayList<PureObject>();
		list.add(a);
		list.add(b);
	}
	
	public boolean add(PureObject e) {
		return list.add(e);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// list has at least two items
		for(PureObject item : list){
			sb.append(item.toString()).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	private List<PureObject> list;
}
