package co.dataMining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FilterCandidate {
	
Pass p = new Pass();

	public void doFilter(HashMap<ArrayList<Integer>, Integer> hm) {

		int st = new doReadFile().getST();

		Iterator<ArrayList<Integer>> itr = hm.keySet().iterator();

		while (itr.hasNext()) {

			ArrayList key = itr.next();
			int val = hm.get(key);
			if (val < st) {
				itr.remove();
			}
		}

	}

}
