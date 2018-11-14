package co.dataMining;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConstructCandidate {

	FilterCandidate fc= new FilterCandidate();
	createHashTable h = new createHashTable();
	Pass p = new Pass();
    static MPass mp = new MPass();
	int counter = 0;

	public void checkCandidate(String path, HashMap<ArrayList<Integer>,Integer> hm) throws FileNotFoundException {

		File file = new File(path);
		Scanner sc = new Scanner(file);
		String fLine = sc.nextLine();

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			int indexOfFirst = line.indexOf(",");
			String newLine = line.substring(indexOfFirst);

			countCandidate(newLine,hm);
			
			
		}
		
		fc.doFilter(hm);
		
		sc.close();
	}

	public void countCandidate(String newLine, HashMap<ArrayList<Integer>, Integer> hm) {


		for (ArrayList ip : hm.keySet()) {

			int flag = 1;

			for (int i = 0; i < ip.size(); i++) {

				StringTokenizer st = new StringTokenizer(newLine, ",");

				int itemCode = (Integer) ip.get(i);

				String key = h.getHashKey(itemCode);

				if (flag == 1) {
					while (st.hasMoreTokens()) {
						if (st.nextToken().equals(key)) {

							flag = 1;
							break;
						} else {
							flag = 0;
						}
					}
				}
			}

			incCount(flag, ip, hm);
		}

	}

	public void incCount(int flag, ArrayList ip, HashMap<ArrayList<Integer>, Integer> hm) {

		if (flag == 1) {

			hm.replace(ip, hm.get(ip) + 1);

		}
	}
	
}
