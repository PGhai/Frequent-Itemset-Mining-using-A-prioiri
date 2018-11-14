package co.dataMining;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

public class createHashTable {

	static HashMap<String, Integer> ht = new HashMap<String, Integer>();
	int i = 0;

	public void addToHash(String item) {
		ht.put(item, i);
		i++;
	}

	public boolean checkIfExist(String item) {

		return ht.containsKey(item);

	}

	public int getKey(String item) {
		return ht.get(item);
	}

	public void displayHash() {
for(String s: ht.keySet()) {
	System.out.println(s +": " + ht.get(s).toString());
}
	
	}

	public HashMap<String, Integer> getHashtable() {

		return ht;
	}

	public String getHashKey(int itemCode) {

		String key ="";
		for (Entry<String, Integer> entry : ht.entrySet()) {
			if (itemCode == entry.getValue()) {
			key = entry.getKey();

			}
			
		}
		return key;

	}
}
