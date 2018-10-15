import java.io.*;

public class main {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("C:\\Users\\JF\\Desktop\\111.txt");
            BufferedInputStream bis=new BufferedInputStream(fis);
            String content="";
            //自己定义一个缓冲区
            byte[] buffer=new byte[10240];
            int flag=0;
            while((flag=bis.read(buffer))!=-1){
                content+=new String(buffer, 0, flag);
            }
            System.out.print(content);
            //关闭的时候只需要关闭最外层的流就行了
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}