package HorseTravel;

import javax.swing.*;
import java.io.*;

public class ioFile {
	String s="";
	public void getPath() {
		JFileChooser jfc=new JFileChooser(new File("C:\\Users\\JF\\Desktop"));
		jfc.showDialog(new JLabel(), "Ñ¡Ôñ");
		File file=jfc.getSelectedFile();
		s+=file.getAbsolutePath();
	}
	public String BufReader() throws FileNotFoundException {
		File f=new File(s);
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
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return str;
	}
	public void BufWriter(String ss) throws IOException {
		getPath();
		File f=new File(s);
		FileWriter fw=new FileWriter(f);
		try {
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(ss);
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public String BufInput() throws FileNotFoundException {
		File f=new File(s);
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
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return content;
	}
	public void BufOutput(String ss) throws IOException {
		getPath();
		File f=new File(s);
		FileOutputStream fo = new FileOutputStream(f);
		try {
			BufferedOutputStream bo = new BufferedOutputStream(fo);
			bo.write(ss.getBytes());
			bo.close();
			fo.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}