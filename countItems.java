package co.dataMining;

import java.util.ArrayList;

public class countItems {

	Candidate cad = new Candidate();
	Pass p1 = new Pass();
	ArrayList<Integer> CountList = new ArrayList<Integer>();

	public void addCount() {

		CountList.add(1);
	}

	public void incCount(int index) {

		int temp = CountList.get(index);
		temp++;
		CountList.set(index, temp);

	}

	public void displayCL() {

		for (int i = 0; i < CountList.size(); i++) {

			System.out.println("Item -" + i + " count is" + CountList.get(i));
		}
	}

	public void filter(int ST) {

		CountList = cad.getCandidate(CountList, ST);
		p1.genCand(CountList);
	}

	public ArrayList<Integer> getArrList() {

		return CountList;
	}
}
