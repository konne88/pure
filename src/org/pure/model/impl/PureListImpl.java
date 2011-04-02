package org.pure.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.pure.model.PureList;
import org.pure.model.PureObject;
import org.pure.model.impl.CollectionFormater.Brackets;

class ListFormater extends CollectionFormater {
	public ListFormater(List<PureObject> l){
		iter = l.iterator();
	}
	
	@Override
	protected String nextItem() {
		return iter.hasNext()?
					iter.next().toString():
					null;
	}

	@Override
	protected Brackets getBrackets() {
		return Brackets.BRACKETS;
	}
	
	private Iterator<PureObject> iter;
}

public class PureListImpl implements PureList {
	public PureListImpl() {
		this.list = new ArrayList<PureObject>();
	}
	
	public PureListImpl(List<PureObject> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return (new ListFormater(list)).toString();
	}
	
	private List<PureObject> list;
}
