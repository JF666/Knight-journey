package Knightjourney;

import java.awt.*;

import javax.swing.*;

public class TravelFrame extends JFrame {
	public TravelFrame(int n,int x,int y) {
		super("��ʿ����");
		JButton Butt[]=new JButton[6];
		JButton Butt0[][]=new JButton[n][n];
		JTextArea jta[]=new JTextArea[2];
		JLabel L3[]=new JLabel[9];
		this.setSize(650,n*60+330);
		this.setLocation(450, 50);
		JPanel F0=new JPanel(new GridLayout(n+1,n+1));
		F0.add(new Label(""));
		for (int i=1;i<n+1;i++) {
			JLabel L1=new JLabel(i+"");
			L1.setHorizontalAlignment(SwingConstants.CENTER);
			F0.add(L1);
		}
		for(int i=0;i<n;i++) {
			JLabel L2=new JLabel(i+1+"");
			L2.setHorizontalAlignment(SwingConstants.CENTER);
			F0.add(L2);
			for(int j=0;j<n;j++) {
				Butt0[j][i]=new JButton("");
				Butt0[j][i].setPreferredSize(new Dimension(60,60));
				F0.add(Butt0[j][i]);
			}
		}
		JPanel F1=new JPanel(new FlowLayout());
		L3[0]=new JLabel("���̴�С:");
		F1.add(L3[0]);
		L3[1]=new JLabel(n+"");
		F1.add(L3[1]);
		JLabel L4=new JLabel("        ");
		F1.add(L4);
		L3[2]=new JLabel("���:(");
		F1.add(L3[2]);
		L3[3]=new JLabel(x+"");
		F1.add(L3[3]);
		L3[4]=new JLabel(",");
		F1.add(L3[4]);
		L3[5]=new JLabel(y+"");
		F1.add(L3[5]);
		L3[6]=new JLabel(")");
		F1.add(L3[6]);
		JLabel L5=new JLabel("        ");
		F1.add(L5);
		L3[7]=new JLabel("��ʾ:");
		F1.add(L3[7]);
		L3[8]=new JLabel("���̷�ΧΪ[5,8]");
		F1.add(L3[8]);
		JPanel F2=new JPanel(new FlowLayout());
		Butt[0]=new JButton("��һ��");
		F2.add(Butt[0]);
		Butt[3]=new JButton("����Ч��");
		F2.add(Butt[3]);
		Butt[1]=new JButton("����");
		F2.add(Butt[1]);
		Butt[4]=new JButton("�ַ���");
		F2.add(Butt[4]);
		Butt[5]=new JButton("�ֽ���");
		F2.add(Butt[5]);
		Butt[2]=new JButton("����");
		F2.add(Butt[2]);
		JPanel F3=new JPanel(new GridLayout(2,1));
		jta[0]=new JTextArea(3,50);
		JScrollPane js=new JScrollPane(jta[0]);
		F3.add(js);
		jta[1]=new JTextArea(3,50);
		JScrollPane js1=new JScrollPane(jta[1]);
		F3.add(js1);
		JPanel F4=new JPanel(new FlowLayout());
		F4.add(F0);
		F4.add(F1);
		F4.add(F2);
		F4.add(F3);
		this.add(F4);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}