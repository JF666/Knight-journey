package Knightjourney;

import java.io.*;

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
	public String BufInput() throws FileNotFoundException {
		File f=new File("C:\\Users\\JF\\Desktop\\111.txt");
		FileInputStream fi = new FileInputStream(f);
		String content = "";
		int flag;
		try {
			BufferedInputStream bi = new BufferedInputStream(fi);
			byte[] buffer = new byte[10240];
			while ((flag = bi.read(buffer)) != -1) {
				content += new String(buffer, 0, flag);
			}
			bi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return content;
	}
	public void BufOutput(String s) throws IOException {
		File f=new File("C:\\Users\\JF\\Desktop\\111.txt");
		FileOutputStream fo = new FileOutputStream(f);
		try {
			BufferedOutputStream bo = new BufferedOutputStream(fo);
			bo.write(s.getBytes());
			bo.close();
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}