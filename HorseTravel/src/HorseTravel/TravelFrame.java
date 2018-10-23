package HorseTravel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class TravelFrame extends JFrame implements ActionListener,Runnable {
	private JButton Butt[];
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
		this.setSize(650,n*60+380);
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
		FlowLayout f=new FlowLayout();
		f.setVgap(15);
		JPanel F0=new JPanel(f);
		JLabel jlb[];
		String jlbstr[]={"棋盘大小:",n+"","    ","起点:(",x+"",",",y+"",")","    ","提示:",tvl.response};
		jlb=new JLabel[jlbstr.length];
		for (int i=0;i<jlbstr.length;i++){
			jlb[i]=new JLabel(jlbstr[i]);
			F0.add(jlb[i]);
		}
		String Buttstr[]={"下一步","重置"};
		Butt=new JButton[Buttstr.length];
		for (int i=0;i<Buttstr.length;i++){
			Butt[i]=new JButton(Buttstr[i]);
			Butt[i].addActionListener(this);
			F0.add(Butt[i]);
		}
		JPanel F1=new JPanel(new GridLayout(n+1,n+1));
  		F1.add(new Label(""));
		for (int i=1;i<n+1;i++) {
			JLabel L1=new JLabel(i+"");
			L1.setHorizontalAlignment(SwingConstants.CENTER);
			F1.add(L1);
		}
		for(int i=0;i<n;i++) {
			JLabel L2=new JLabel(i+1+"");
			L2.setHorizontalAlignment(SwingConstants.CENTER);
			F1.add(L2);
			for(int j=0;j<n;j++) {
				Butt0[i][j]=new JButton("");
				Butt0[i][j].setPreferredSize(new Dimension(60,60));
				F1.add(Butt0[i][j]);
			}
		}
		JPanel F2=new JPanel(new GridLayout(2,1));
		JScrollPane js[];
		js=new JScrollPane[jta.length];
		for (int i=0;i<jta.length;i++){
			jta[i]=new JTextArea(3,75);
			js[i]=new JScrollPane(jta[i]);
			F2.add(js[i]);
		}
		JPanel F3=new JPanel(new FlowLayout());
		F3.add(F0);
		F3.add(F1);
		F3.add(F2);
		this.add(F3);
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
							Font font=new Font("宋体",Font.BOLD,14);
							Butt0[i][j].setFont(font);
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
			jmi[2].setEnabled(false);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(tvl.chessboard[i][j]!=0){
						Font font=new Font("宋体",Font.BOLD,14);
						Butt0[i][j].setFont(font);
						Butt0[i][j].setText(Integer.toString(tvl.chessboard[i][j]));
					}
				}
			}
		}
		if (message.getSource() == jmi1[0]) {
			this.jta[0].setText("");
			ioFile io=new ioFile();
			try {
				io.BufWriter(tvl.result);
				Font font=new Font("宋体",Font.BOLD,14);
				jta[0].setFont(font);
				this.jta[0].setText("字符流:" + io.BufReader());
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (message.getSource() == jmi1[2]) {
			ioFile io=new ioFile();
			this.jta[1].setText("");
			try {
				io.BufOutput(tvl.result);
				Font font=new Font("宋体",Font.BOLD,14);
				jta[1].setFont(font);
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
						Font font=new Font("楷体",Font.BOLD,14);
						Butt0[i][j].setFont(font);
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