package co.dataMining;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Runner {

	static Path fullPath = new File("F:\\Study\\Advacne Database\\FrequentDataSetMining", "input5.txt").toPath();

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		// TODO Auto-generated method stub
		doReadFile rf = new doReadFile();
		Pass p = new Pass();
		MPass mp = new MPass();
		try {
			rf.ReadFile(fullPath.toAbsolutePath().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConstructCandidate c = new ConstructCandidate();

		c.checkCandidate(fullPath.toAbsolutePath().toString(), p.hm);
		p.displayMap();
		while (p.hm.size() > 0) {
			p.hm = mp.createCand(p.hm);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("exe time=" + ((double) (end - start) / 1000) + "sec");
	}

	public Path getPath() {
		// Getter of path name
		return fullPath;
	}

}
