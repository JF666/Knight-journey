package Knightjourney;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ioFile {
	public String BufReader() throws FileNotFoundException {
		File f=new File("C:\\Users\\JF\\Desktop\\111.txt");
		FileReader fr=new FileReader(f);
		String str = "";
		try {
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				str += line;
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return str;
	}
	public void BufWriter(String s) throws IOException {
		File f=new File("C:\\Users\\JF\\Desktop\\111.txt");
		FileWriter fw=new FileWriter(f);
		try {
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
