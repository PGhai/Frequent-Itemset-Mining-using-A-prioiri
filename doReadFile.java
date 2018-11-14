package co.dataMining;

import java.io.*;
import java.util.*;

public class doReadFile {

	createHashTable hash = new createHashTable();
	countItems ci = new countItems();
	static int ST, T;
	String fLine;

	public void ReadFile(String path) throws FileNotFoundException {

		File file = new File(path);

		Scanner sc = new Scanner(file);
		fLine = sc.nextLine();
		System.out.println("it is the first line" + fLine);
		int ind = fLine.indexOf(" ");
		String ed = fLine.substring(0, ind).trim();
		T = Integer.parseInt(ed);
		System.out.println(T);
		String nL = fLine.substring(ind).trim();
		ST = Integer.parseInt(nL);

		System.out.println("Value is....." + ST);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			int indexOfFirst = line.indexOf(",");
			System.out.println(indexOfFirst);
			String newLine = line.substring(indexOfFirst);
			StringTokenizer st = new StringTokenizer(newLine, ",");
			
			if (st.countTokens() > 2 && ST > 2) {

				while (st.hasMoreTokens()) {

					String item = st.nextToken();

					boolean b = hash.checkIfExist(item);
					if (b == false) {
						hash.addToHash(item);
						ci.addCount();
					} else {

						int key = hash.getKey(item);

						ci.incCount(key);

					}

				}
			}
			else {
				if(st.countTokens() < 3) {
					
				}
				else {
					System.out.println("Invalid ST");
					break;
				}
			}
		}

		hash.displayHash();
		ci.displayCL();
		ci.filter(ST);

		sc.close();
	}

	public int getST() {

		return ST;
	}

}
