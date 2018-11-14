package co.dataMining;

import java.util.ArrayList;

public class Candidate {
	
	public ArrayList getCandidate(ArrayList<Integer> loc, int st) {

		countItems ci = new countItems();
		doReadFile r = new doReadFile();
		
		for (int i = 0; i < loc.size(); i++) {
			if ((Integer) loc.get(i) < st) {
				loc.set(i,0);
			} else {
				continue;
			}
		}
		return loc;
	}
}
