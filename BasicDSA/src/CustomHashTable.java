import java.util.ArrayList;
import java.util.List;

public class CustomHashTable<T extends Object> {
	
	private T [] data;
	
	public CustomHashTable(int size) {
		super();
		data = (T[]) new Object[size];
	}

	private int hashKey(T key) {
		int hash = 0;
		String keyStr = (String) key;
		for ( int i = 0; i < keyStr.length(); i++ ) {
			Character character = keyStr.charAt(i);
			hash = (hash + (int) character *( i + 1 )) % this.data.length;
		}
		System.out.println("Hash value for " + key + " is : " + hash);
		return hash;
	}
	
	public Object get(T key) {
		Object value = null;
		int address = this.hashKey(key);
		List<List<T>> elements = (List<List<T>>) this.data[address];
		if ( elements != null ) {
			for ( int i = 0; i < elements.size(); i++ ) {
				List<T> element = elements.get(i);
				if ( key.equals(element.get(0)) ) {
					return element.get(1);
				}
			}
		}
		return value;
	}
	
	public void put(T key, Object value) {
		int hash = hashKey(key);
		List<List<T>> elements = null;
		if ( data[hash] == null ) {
			elements = new ArrayList();
			List<T> element = new ArrayList<>();
			element.add(key);
			element.add((T) value);
			elements.add(element);
		} else {
			elements = (List<List<T>>) data[hash];
			List<T> element = new ArrayList<>();
			element.add(key);
			element.add((T) value);
			elements.add(element);
		}
		data[hash] = (T) elements;
		for ( T element : data ) {
			if ( element != null ) {
				System.out.println(element);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomHashTable<String> customHashTable = new CustomHashTable<>(1);
		customHashTable.put("grapes", 10000);
		customHashTable.put("drapes", 10);
		System.out.println(customHashTable.get("drapes"));
	}

}
