package HorseTravel;

import javax.swing.*;
import java.io.*;

class ioFile {
	private String s="";
	void getPath() {
		JFileChooser jfc=new JFileChooser(new File("C:\\Users\\JF\\Desktop"));
		jfc.showDialog(new JLabel(), "Ñ¡Ôñ");
		File file=jfc.getSelectedFile();
		try{
			s+=file.getAbsolutePath();
		}catch (NullPointerException npe){
			npe.printStackTrace();
		}
	}
	String BufReader() throws IOException {
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
	void BufWriter(String ss) throws IOException {
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
	int BufInput() throws IOException {
		File f=new File(s);
		FileInputStream fi = new FileInputStream(f);
		int content=0;
		try {
			DataInputStream di=new DataInputStream(fi);
			content = di.readInt();
			di.close();
			fi.close();
		}catch (EOFException ee){
			ee.printStackTrace();
		}
		return content;
	}
	void BufOutput(int a) throws IOException {
		File f=new File(s);
		FileOutputStream fo = new FileOutputStream(f);
		try {
			DataOutputStream dos = new DataOutputStream(fo);
			dos.writeInt(a);
			dos.close();
			fo.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}