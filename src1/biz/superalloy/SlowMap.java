package biz.superalloy;

import java.util.*;

class MapEntry<K, V> implements Map.Entry<K, V>{
	private K key;
	private V value;
	public MapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	public K getKey(){
		return key;
	}
	public V getValue(){
		return value;
	}
	public V setValue(V v){
		V result = value;
		value = v;
		return result;
	}
	public int hashCode() {
		return (key == null ? 0 : key.hashCode() ^ (value == null ? 0 : value.hashCode()));
	}
	public boolean equals(Object o){
		if(!(o instanceof MapEntry)) return false;
		MapEntry me = (MapEntry)o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey())) && (value == null ? me.getValue() == null : value.equals(me.getValue()));
	}
	
	public String toString(){
		return key + "=" + value;
	}
}

public class SlowMap<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	public V put(K key, V value){
		V oldValue = get(key); // The old value or null
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);
		}		
		return oldValue;		
	}
	
	public V get(Object key){ // key is type Object, not K 因为接口Map<K,V>中是V get(Object key);所以这里参数也必须是Object key.这是将泛型注入到Java语言中的时刻如此之晚所导致的结果，如果泛型是Java语言最初就具备的属性，那么get()就可以执行其参数的类型。
		if(!keys.contains(key)){
			return null;
		}
		return values.get(keys.indexOf(key));
	}
	
	public Set<Map.Entry<K, V>> entrySet(){
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while (ki.hasNext()) {
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));			
		}
		
		return set;
	}
	
	public static void main(String[] args){
		SlowMap<String, String> m = new SlowMap<String, String>();
		//m.put(key, value)
		for(String s : "to be or not to be".split(" ")){
			System.out.println(s);
			m.put(s, s);
		}		
		System.out.println(m);
	}
}
