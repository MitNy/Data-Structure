package DS01_07_201602038;

/* 선형 조사 */
public class LinearProbingHashTable {
	int Collision=0;
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	
	public LinearProbingHashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public LinearProbingHashTable(int capacity) {
		this(capacity, 0.75F);
	}
	
	public LinearProbingHashTable() {
		this(101);
	}
	
	public Object get(Object key) {
		int h = hash(key);
		for(int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;
	}
	
	public Object put(Object key, Object value) {
		if( used > loadFactor*entries.length ) rehash();
		int h = hash(key);
		for(int i = 0; i < entries.length; i++) {
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			if(entry == null){
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null;	//  삽입 성공
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue;	// 업데이트
			}
			++Collision;	// 충돌 횟수 증가
		}
		return null;	// 테이블 오버플로우
	}
	
	public Object remove(Object key) {
		int h = hash(key);
		for(int i = 0; i < entries.length; i++) {
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;	// remove 성공
			}
		}
		return null;	// 키를 찾을 수 없음
	}
	
	public int size() { return size; }
	
	private class Entry{
		Object key, value;
		Entry(Object k, Object v) {key = k; value = v;}
	}
	
	private int hash(Object key){
		if(key == null) throw new IllegalArgumentException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}
	
	private int nextProbe(int h, int i){
		return (h+i) % entries.length;	// Linear Probing
	}
	
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[ 2*oldEntries.length+1 ];
		
		for(int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key);

			for(int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, i);
				if(entries[j] == null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
}