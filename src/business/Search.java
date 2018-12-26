package business;

import java.util.Collection;

public class Search<T> {
	
	public T searchByName(Collection<T> collection, String name) {
		for( T person : collection ) {
			if(collection.contains(person)) {
				return person;
			}
		}
		return null;
	}
}
