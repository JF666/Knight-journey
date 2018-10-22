package HorseTravel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class TravelFrame extends JFrame implements ActionListener,Runnable {
	private JButton Butt[]=new JButton[6];
	private JButton Butt0[][];
	private JTextArea jta[]=new JTextArea[2];
	private int size,num;
	private Travel tvl;
	private Thread t;
	TravelFrame(int n,int x,int y) {
		super("��ʿ����");
		tvl=new Travel(n,x,y);
		size=n;
		Butt0=new JButton[n][n];
		JLabel L3[]=new JLabel[9];
		this.setSize(650,n*60+350);
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
				Butt0[i][j]=new JButton("");
				Butt0[i][j].setPreferredSize(new Dimension(60,60));
				F0.add(Butt0[i][j]);
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
		L3[8]=new JLabel(tvl.response);
		F1.add(L3[8]);
		JPanel F2=new JPanel(new FlowLayout());
		Butt[0]=new JButton("��һ��");
		Butt[0].addActionListener(this);
		F2.add(Butt[0]);
		Butt[1]=new JButton("����Ч��");
		Butt[1].addActionListener(this);
		F2.add(Butt[1]);
		Butt[2]=new JButton("����");
		Butt[2].addActionListener(this);
		F2.add(Butt[2]);
		Butt[3]=new JButton("�ַ���");
		Butt[3].addActionListener(this);
		F2.add(Butt[3]);
		Butt[4]=new JButton("�ֽ���");
		Butt[4].addActionListener(this);
		F2.add(Butt[4]);
		Butt[5]=new JButton("����");
		Butt[5].addActionListener(this);
		F2.add(Butt[5]);
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
		t=new Thread(this);
	}
	public void actionPerformed(ActionEvent message) {
		if (message.getSource() == Butt[0]) {
			if (num != size*size) {
				num++;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if(tvl.chessboard[i][j]==num){
							Butt0[i][j].setText(Integer.toString(num));
						}
					}
				}
			}
		}
		if (message.getSource() == Butt[1]) {
			Butt[1].setEnabled(false);
			t.start();
		}
		if (message.getSource() == Butt[2]) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(tvl.chessboard[i][j]!=0){
						Butt0[i][j].setText(Integer.toString(tvl.chessboard[i][j]));
					}
				}
			}
		}
		if (message.getSource() == Butt[3]) {
			Butt[3].setEnabled(false);
			ioFile io=new ioFile();
			this.jta[0].setText("");
			try {
				io.BufWriter(tvl.result);
				this.jta[0].setText("�ַ���:" + io.BufReader());
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (message.getSource() == Butt[4]) {
			Butt[4].setEnabled(false);
			ioFile io=new ioFile();
			this.jta[1].setText("");
			try {
				io.BufOutput(tvl.result);
				this.jta[1].setText("�ֽ���:"+io.BufInput());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (message.getSource() == Butt[5]) {
			this.dispose();
			new init();
		}
	}
	public void run() {
		while (num != size * size) {
			num++;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (tvl.chessboard[i][j] == num) {
						Butt0[i][j].setText(Integer.toString(num));
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}