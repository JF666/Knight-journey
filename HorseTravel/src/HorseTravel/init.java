package HorseTravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class init  extends JFrame implements ActionListener {
    private JTextField jt[]=new JTextField[3];
    private JButton but[];
    init(){
        super("���������̴�С�����");
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        JPanel P=new JPanel(new GridLayout(3,1));
        JPanel P1[]=new JPanel[3];
        for (int i=0;i<P1.length;i++) {
            P1[i]=new JPanel(new FlowLayout());
        }
        JLabel jlb[];
        String jlbstr[]={"���̴�С:","���:(",",",")"};
        jlb=new JLabel[jlbstr.length];
        for (int i=0;i<jlbstr.length;i++){
            jlb[i]=new JLabel(jlbstr[i]);
        }
        P1[0].add(jlb[0]);
        P1[0].add(jt[0]=new JTextField(5));
        P1[1].add(jlb[1]);
        P1[1].add(jt[1]=new JTextField(5));
        P1[1].add(jlb[2]);
        P1[1].add(jt[2]=new JTextField(5));
        P1[1].add(jlb[3]);
        String butstr[]={"ȷ��","����"};
        but=new JButton[butstr.length];
        for (int i=0;i<butstr.length;i++){
            but[i]=new JButton(butstr[i]);
            but[i].addActionListener(this);
            P1[2].add(but[i]);
        }
        for (int i=0;i<P1.length;i++) {
            P.add(P1[i]);
        }
        this.add(P);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent message) {
        if(message.getSource() == but[0]) {
            for(int i=0;i<jt.length;i++) {
                if (jt[i].getText().equals("")) {
                    for (int j = 0; j < jt.length; j++) {
                        jt[j].setText("");
                    }
                    JOptionPane.showMessageDialog(null, "����������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                    throw new IllegalArgumentException("����������");
                }
            }
            try{
                int n[]=new int[3];
                for(int j=0;j<jt.length;j++) {
                    n[j]=Integer.parseInt(jt[j].getText());
                }
                if(n[0]<5||n[0]>8){
                    for(int j=0;j<jt.length;j++) {
                        jt[j].setText("");
                    }
                    JOptionPane.showMessageDialog(null,"���̳ߴ�̫���̫С","��ʾ",JOptionPane.PLAIN_MESSAGE);
                    throw new IllegalArgumentException("���̳ߴ�̫���̫С");
                }
                if(n[1]<1||n[1]>n[0]||n[2]<1||n[2]>n[0]){
                    for(int j=0;j<jt.length;j++) {
                        jt[j].setText("");
                    }
                    JOptionPane.showMessageDialog(null,"��㲻��������","��ʾ",JOptionPane.PLAIN_MESSAGE);
                    throw new IllegalArgumentException("��㲻��������");
                }
                this.dispose();
                new TravelFrame(n[0],n[1],n[2]);
            }catch(NumberFormatException ne){
                for(int j=0;j<jt.length;j++) {
                    jt[j].setText("");
                }
                JOptionPane.showMessageDialog(null,"����������","��ʾ",JOptionPane.PLAIN_MESSAGE);
                throw new IllegalArgumentException("����������");
            }
        }
        if(message.getSource() == but[1]) {
            for(int i=0;i<jt.length;i++) {
                jt[i].setText("");
            }
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new init();
    }
}