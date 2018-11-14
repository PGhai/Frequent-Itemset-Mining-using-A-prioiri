package co.dataMining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Pass {

	static HashMap<ArrayList<Integer>, Integer> hm = new HashMap<ArrayList<Integer>, Integer>();
	int com = 0;

	public void genCand(ArrayList CountList) {

		int size = CountList.size();
        int count =0;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
					if((int)CountList.get(i) != 0 && (int)CountList.get(j)!= 0) {
					
				ArrayList temp = new ArrayList();
					temp.add(i);
					temp.add(j);

					if (checkExistance(temp) == true) {

					} else {

						hm.put(temp, com);
						count++;
					}
					}
				
			}

		}
		
		
		System.out.println(count);
	}

	public void displayMap() {
		for (ArrayList name : hm.keySet()) {

			String key = name.toString();
			String value = hm.get(name).toString();
			System.out.println(key + " " + value);

		}
	}

	public boolean checkExistance(ArrayList<Integer> check) {

		ArrayList rev;

		rev = (ArrayList) check.clone();
		Collections.reverse(rev);

		if (hm.containsKey(rev) == true || hm.containsKey(check)==true) {

			return true;
		} else {
			return false;
		}

	}
	
	public HashMap<ArrayList<Integer>, Integer> getHashMap() {
		
		return hm;
	}
}
