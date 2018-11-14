package co.dataMining;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class MPass {
	createHashTable cht = new createHashTable();
	ConstructCandidate cc = new ConstructCandidate();
	doReadFile d = new doReadFile();
	HashMap<ArrayList<Integer>, Integer> ham = new HashMap<ArrayList<Integer>, Integer>();
	Pass p = new Pass();
	ArrayList list = new ArrayList();
	Set<Integer> s = new HashSet();
	int fSize;
	static boolean b = true;

	public HashMap createCand(HashMap<ArrayList<Integer>, Integer> hm) throws FileNotFoundException {

		for (ArrayList arr : hm.keySet()) {
			arr.sort(null);
			list.add(arr);
			s.addAll(arr);
			fSize = arr.size();
		}
		fSize = fSize + 1;

		for (int i = 0; i < list.size(); i++) {

			Set<Integer> tempSet = new HashSet();

			tempSet.addAll((ArrayList) list.get(i));
			for (int j = i + 1; j < list.size(); j++) {

				tempSet.addAll((ArrayList) list.get(j));
				if (tempSet.size() > fSize) {
					tempSet.clear();
					tempSet.addAll((ArrayList) list.get(i));
				} else if (tempSet.size() == fSize) {
					ArrayList check = new ArrayList();
					Iterator itr = tempSet.iterator();
					while (itr.hasNext()) {
						check.add(itr.next());
					}
					tempSet.clear();
					tempSet.addAll((ArrayList) list.get(i));
					// System.out.println(check.toString());
					int flag;
					if ((flag = doCheck(check)) == 1) {
						ham.put(check, 0);

					}

				}

			}
			tempSet.clear();

		}
		list.clear();

		
		cc.checkCandidate(new Runner().getPath().toAbsolutePath().toString(), ham);

		hm.clear();
		hm = (HashMap<ArrayList<Integer>, Integer>) ham.clone();
		for (ArrayList<Integer> al : hm.keySet()) {
			for (int i : al) {

				String key = cht.getHashKey(i);
				System.out.print(key + " ");

			}
			System.out.println("Support" + (float) hm.get(al) / (d.T));
		}
		ham.clear();
		return hm;
	}
	

	public int doCheck(ArrayList check) {
		int flag = 1;

		if (flag == 1) {
			for (int i = 0; i < fSize; i++) {

				ArrayList ar = new ArrayList();

				for (int j = i; j < fSize; j++) {
					// System.out.println("ar.size"+ ar.size()+" "+ fSize);
					if (ar.size() < fSize - 1) {
						ar.add(check.get(j));
					} else if (ar.size() == fSize - 1) {
						break;
					}

				}
				int t = 0;
				while (ar.size() != fSize - 1) {
					ar.add(check.get(t));
					t++;

				}
				ar.sort(null);
				if (list.contains(ar)) {
					flag = 1;
				} else {
					flag = 0;
					break;
				}
				ar.clear();
			}
		}
		return flag;
	}
}
