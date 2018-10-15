import java.io.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("C:\\Users\\JF\\Desktop\\111.txt");
        FileReader fr=new FileReader(f);
        String Str = "";
        try {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                Str += line;
            }
            System.out.print(Str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}