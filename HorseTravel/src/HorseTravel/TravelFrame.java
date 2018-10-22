package HorseTravel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class TravelFrame extends JFrame implements ActionListener,Runnable {
	private JButton Butt[]=new JButton[2];
	private JButton Butt0[][];
	private JTextArea jta[]=new JTextArea[2];
	private JMenuItem jmi[];
	private JMenuItem jmi1[];
	private int size,num;
	private Travel tvl;
	TravelFrame(int n,int x,int y) {
		super("骑士游历");
		tvl=new Travel(n,x,y);
		size=n;
		Butt0=new JButton[n][n];
		JLabel L3[]=new JLabel[9];
		this.setSize(650,n*60+350);
		this.setLocationRelativeTo(null);
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm[];
		String jmstr[]={"文件","开始"};
		jm=new JMenu[jmstr.length];
		for(int i=0;i<jmstr.length;i++) {
			jm[i] = new JMenu(jmstr[i]);
			jmb.add(jm[i]);
		}
		String jmistr[]={"动画演示","|","走完"};
		jmi=new JMenuItem[jmistr.length];
		JMenu jm1=new JMenu("流操作");
		String jmistr1[]={"字符流","|","字节流"};
		jmi1=new JMenuItem[jmistr1.length];
		for(int i=0;i<jmistr1.length;i++) {
			if(jmistr1[i].equals("|")) {
				jm1.addSeparator();
			}
			else {
				jmi1[i]=new JMenuItem(jmistr1[i]);
				jm1.add(jmi1[i]);
				jmi1[i].addActionListener(this);
			}
		}
		jm[0].add(jm1);
		for(int i=0;i<jmistr.length;i++) {
			if(jmistr[i].equals("|")) {
				jm[1].addSeparator();
			}
			else {
				jmi[i]=new JMenuItem(jmistr[i]);
				jm[1].add(jmi[i]);
				jmi[i].addActionListener(this);
			}
		}
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
		L3[0]=new JLabel("棋盘大小:");
		F1.add(L3[0]);
		L3[1]=new JLabel(n+"");
		F1.add(L3[1]);
		JLabel L4=new JLabel("        ");
		F1.add(L4);
		L3[2]=new JLabel("起点:(");
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
		L3[7]=new JLabel("提示:");
		F1.add(L3[7]);
		L3[8]=new JLabel(tvl.response);
		F1.add(L3[8]);
		Butt[0]=new JButton("下一步");
		Butt[0].addActionListener(this);
		F1.add(Butt[0]);
		Butt[1]=new JButton("重置");
		Butt[1].addActionListener(this);
		F1.add(Butt[1]);
		JPanel F2=new JPanel(new GridLayout(2,1));
		jta[0]=new JTextArea(3,50);
		JScrollPane js=new JScrollPane(jta[0]);
		F2.add(js);
		jta[1]=new JTextArea(3,50);
		JScrollPane js1=new JScrollPane(jta[1]);
		F2.add(js1);
		JPanel F4=new JPanel(new FlowLayout());
		F4.add(F0);
		F4.add(F1);
		F4.add(F2);
		this.add(F4);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		if (message.getSource() == jmi[0]) {
			jmi[0].setEnabled(false);
			Thread t=new Thread(this);
			t.start();
		}
		if (message.getSource() == jmi[2]) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(tvl.chessboard[i][j]!=0){
						Butt0[i][j].setText(Integer.toString(tvl.chessboard[i][j]));
					}
				}
			}
		}
		if (message.getSource() == jmi1[0]) {
			jmi1[0].setEnabled(false);
			ioFile io=new ioFile();
			this.jta[0].setText("");
			try {
				io.BufWriter(tvl.result);
				this.jta[0].setText("字符流:" + io.BufReader());
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (message.getSource() == jmi1[2]) {
			jmi1[2].setEnabled(false);
			ioFile io=new ioFile();
			this.jta[1].setText("");
			try {
				io.BufOutput(tvl.result);
				this.jta[1].setText("字节流:"+io.BufInput());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (message.getSource() == Butt[1]) {
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