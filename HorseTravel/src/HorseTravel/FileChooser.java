package HorseTravel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileChooser extends JFrame implements ActionListener{
    JButton open;
    private String s="";
    public static void main(String[] args) {
        new FileChooser();
    }
    public FileChooser(){
        open=new JButton("open");
        this.add(open);
        this.setBounds(400, 200, 100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser jfc=new JFileChooser(new File("C:\\Users\\JF\\Desktop"));
        jfc.showDialog(new JLabel(), "Ñ¡Ôñ");
        File file=jfc.getSelectedFile();
        s+=file.getAbsolutePath();
    }
}
