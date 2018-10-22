package HorseTravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class init  extends JFrame implements ActionListener {
    private JTextField jt1;
    private JTextField jt2;
    private JTextField jt3;
    private JButton but1;
    private JButton but2;
    init(){
        super("请输入棋盘大小和起点");
        this.setBounds(800,400,350,200);
        JPanel P=new JPanel(new GridLayout(3,1));
        JPanel P1=new JPanel(new FlowLayout());
        JLabel L1=new JLabel("棋盘大小:");
        P1.add(L1);
        jt1=new JTextField(5);
        P1.add(jt1);
        JPanel P2=new JPanel(new FlowLayout());
        JLabel L2=new JLabel("起点:(");
        P2.add(L2);
        jt2=new JTextField(5);
        P2.add(jt2);
        JLabel L3=new JLabel(",");
        P2.add(L3);
        jt3=new JTextField(5);
        P2.add(jt3);
        JLabel L4=new JLabel(")");
        P2.add(L4);
        JPanel P3=new JPanel(new FlowLayout());
        but1=new JButton("确定");
        but1.addActionListener(this);
        but2=new JButton("重置");
        but2.addActionListener(this);
        P3.add(but1);
        P3.add(but2);
        P.add(P1);
        P.add(P2);
        P.add(P3);
        this.add(P);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent message) {
        if(message.getSource() == but1) {
            if (jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入数据", "提示", JOptionPane.PLAIN_MESSAGE);
                throw new IllegalArgumentException("请输入数据");
            }else {
                try{
                    int n=Integer.parseInt(jt1.getText());
                    int x=Integer.parseInt(jt2.getText());
                    int y=Integer.parseInt(jt3.getText());
                    if(n<5||n>8){
                        JOptionPane.showMessageDialog(null,"棋盘尺寸太大或太小","提示",JOptionPane.PLAIN_MESSAGE);
                        throw new IllegalArgumentException("棋盘尺寸太大或太小");
                    }
                    if(x<1||x>n||y<1||y>n){
                        JOptionPane.showMessageDialog(null,"起点不在棋盘内","提示",JOptionPane.PLAIN_MESSAGE);
                        throw new IllegalArgumentException("起点不在棋盘内");
                    }
                    this.dispose();
                    new TravelFrame(n,x,y);
                }catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null,"请输入整数","提示",JOptionPane.PLAIN_MESSAGE);
                    throw new IllegalArgumentException("请输入整数");
                }
            }
        }
        if(message.getSource() == but2) {
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
        }
    }
    public static void main(String[] args){
        new init();
    }
}
