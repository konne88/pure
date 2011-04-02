package org.pure.model.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.pure.model.PureMap;
import org.pure.model.PureObject;
import org.pure.model.impl.CollectionFormater.Brackets;

class MapFormater extends CollectionFormater {
	public MapFormater(Map<PureObject,PureObject> m){
		iter = m.keySet().iterator();
		map = m;
	}
	
	@Override
	protected String nextItem() {
		if(!iter.hasNext()) 
			return null;
		
		PureObject key = iter.next();
		return key.toString() +": "+ map.get(key).toString();
	}

	@Override
	protected Brackets getBrackets() {
		return Brackets.BRACES;
	}
	
	private Map<PureObject,PureObject> map;
	private Iterator<PureObject> iter;
}

public class PureMapImpl implements PureMap {
	public PureMapImpl() {
		map = new HashMap<PureObject, PureObject>();
	}
	
	public PureMapImpl(Map<PureObject, PureObject> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		return (new MapFormater(map)).toString();
	}
	
	private Map<PureObject, PureObject> map;
}
