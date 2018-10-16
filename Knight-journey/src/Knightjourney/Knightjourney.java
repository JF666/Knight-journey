package Knightjourney;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Knightjourney extends JFrame implements ActionListener,Runnable
{
	private JTextField text[]=new JTextField[4];
	private JButton Butt[]=new JButton[6];
	private JButton Butt0[][]=new JButton[8][8];
	private JTextArea jta[]=new JTextArea[2];
	private int num=0,show=1,size;
	private Thread t;
	private int chessboard[][] = new int[8][8];
	private int x,y;
	public Knightjourney()
	{
		super("骑士游历");
		this.setSize(900,680);
		this.setLocation(400, 150);
		JPanel F0=new JPanel(new GridLayout(1,9));
		JPanel P0=new JPanel(new FlowLayout());
		Butt[2]=new JButton("重置");
		Butt[2].addActionListener(this);
		P0.add(Butt[2]);
		F0.add(P0);
		JPanel P1=new JPanel(new FlowLayout());
		P1.add(new Label("1"));
		F0.add(P1);
		JPanel P2=new JPanel(new FlowLayout());
		P2.add(new Label("2"));
		F0.add(P2);
		JPanel P3=new JPanel(new FlowLayout());
		P3.add(new Label("3"));
		F0.add(P3);
		JPanel P4=new JPanel(new FlowLayout());
		P4.add(new Label("4"));
		F0.add(P4);
		JPanel P5=new JPanel(new FlowLayout());
		P5.add(new Label("5"));
		F0.add(P5);
		JPanel P6=new JPanel(new FlowLayout());
		P6.add(new Label("6"));
		F0.add(P6);
		JPanel P7=new JPanel(new FlowLayout());
		P7.add(new Label("7"));
		F0.add(P7);
		JPanel P8=new JPanel(new FlowLayout());
		P8.add(new Label("8"));
		F0.add(P8);
		JPanel F1=new JPanel(new GridLayout(1,9));
		JPanel P9=new JPanel(new FlowLayout());
		P9.add(new Label("1"));
		F1.add(P9);
		for(int i=0;i<8;i++) {
			F1.add(Butt0[0][i]=new JButton(""));
		}
		JPanel F2=new JPanel(new GridLayout(1,9));
		JPanel P10=new JPanel(new FlowLayout());
		P10.add(new Label("2"));
		F2.add(P10);
		for(int i=0;i<8;i++) {
			F2.add(Butt0[1][i]=new JButton(""));
		}
		JPanel F3=new JPanel(new GridLayout(1,9));
		JPanel P11=new JPanel(new FlowLayout());
		P11.add(new Label("3"));
		F3.add(P11);
		for(int i=0;i<8;i++) {
			F3.add(Butt0[2][i]=new JButton(""));
		}
		JPanel F4=new JPanel(new GridLayout(1,9));
		JPanel P12=new JPanel(new FlowLayout());
		P12.add(new Label("4"));
		F4.add(P12);
		for(int i=0;i<8;i++) {
			F4.add(Butt0[3][i]=new JButton(""));
		}
		JPanel F5=new JPanel(new GridLayout(1,9));
		JPanel P13=new JPanel(new FlowLayout());
		P13.add(new Label("5"));
		F5.add(P13);
		for(int i=0;i<8;i++) {
			F5.add(Butt0[4][i]=new JButton(""));
		}
		JPanel F6=new JPanel(new GridLayout(1,9));
		JPanel P14=new JPanel(new FlowLayout());
		P14.add(new Label("6"));
		F6.add(P14);
		for(int i=0;i<8;i++) {
			F6.add(Butt0[5][i]=new JButton(""));
		}
		JPanel F7=new JPanel(new GridLayout(1,9));
		JPanel P15=new JPanel(new FlowLayout());
		P15.add(new Label("7"));
		F7.add(P15);
		for(int i=0;i<8;i++) {
			F7.add(Butt0[6][i]=new JButton(""));
		}
		JPanel F8=new JPanel(new GridLayout(1,9));
		JPanel P16=new JPanel(new FlowLayout());
		P16.add(new Label("8"));
		F8.add(P16);
		for(int i=0;i<8;i++) {
			F8.add(Butt0[7][i]=new JButton(""));
		}
		JPanel F9=new JPanel(new GridLayout(1,1));
		JPanel P17=new JPanel(new FlowLayout());
		P17.add(new Label("棋盘大小:"));
		P17.add(text[2]=new JTextField(2));
		P17.add(new Label("起点:("));
		P17.add(text[0]=new JTextField(2));
		P17.add(new Label(","));
		P17.add(text[1]=new JTextField(2));
		P17.add(new Label(")"));
		text[0].setText("1");
		text[1].setText("1");
		text[2].setText("5");
		Butt[0]=new JButton("下一步");
		Butt[0].addActionListener(this);
		P17.add(Butt[0]);
		Butt[1]=new JButton("结束");
		Butt[1].addActionListener(this);
		P17.add(Butt[1]);
		Butt[3]=new JButton("动画效果");
		Butt[3].addActionListener(this);
		P17.add(Butt[3]);
		Butt[4]=new JButton("字符流");
		Butt[4].addActionListener(this);
		P17.add(Butt[4]);
        Butt[5]=new JButton("字节流");
        Butt[5].addActionListener(this);
        P17.add(Butt[5]);
		F9.add(P17);
		JPanel F10=new JPanel(new GridLayout(1,1));
		JPanel P18=new JPanel(new FlowLayout());
		P18.add(new Label("提示:"));
		P18.add(text[3]=new JTextField(12));
		text[3].setText("棋盘范围为[5,8]");
		F10.add(P18);
		jta[0]=new JTextArea(4,75);
		JPanel jp=new JPanel();
		JScrollPane js=new JScrollPane(jta[0]);
		jp.add(js);
		jta[1]=new JTextArea(4,75);
		JPanel jp1=new JPanel();
		JScrollPane js1=new JScrollPane(jta[1]);
		jp1.add(js1);
		JPanel F11=new JPanel(new GridLayout(11,1));
		F11.add(F0);
		F11.add(F1);
		F11.add(F2);
		F11.add(F3);
		F11.add(F4);
		F11.add(F5);
		F11.add(F6);
		F11.add(F7);
		F11.add(F8);
		F11.add(F9);
		F11.add(F10);
		this.add(F11);
		this.add(jp);
		this.add(jp1);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t=new Thread(this);
	}
	private void Show1(){
        int z[]=new int[2];
        z[0]=Integer.parseInt(text[0].getText())-1;
        z[1]=Integer.parseInt(text[1].getText())-1;
        size=Integer.parseInt(text[2].getText());
        start(z);
        show=2;
    }
	public void actionPerformed(ActionEvent massag) {
		if(massag.getSource() == Butt[0]) {
			if(text[0].getText().equals("") || text[1].getText().equals("") || text[2].getText().equals(""))
				text[3].setText("请输入起点和棋盘大小");
			else {
				if(show==1) {
                    Show1();
				}
				if(num!=size*size && show==2) {
					num++;
					for(int i=0;i<8;i++) {
						for(int j=0;j<8;j++) {
							if(chessboard[i][j]==num) {
								Butt0[i][j].setText(Integer.toString(chessboard[i][j]));
							}
						}
					}
				}
			}
		}
		if(massag.getSource() == Butt[1]) {
			if(text[0].getText().equals("") || text[1].getText().equals("") || text[2].getText().equals(""))
				text[3].setText("请输入起点和棋盘大小");
			else {
				if(show==1) {
                    Show1();
                }
				if(show==2) {
					for(int i=0;i<size;i++) {
						for(int j=0;j<size;j++) {
							Butt0[i][j].setText(Integer.toString(chessboard[i][j]));
						}
					}
					show=0;
				}
			}
		}
		if(massag.getSource() == Butt[2]) {
			text[0].setText("1"); 
			text[1].setText("1");
			text[2].setText("5");
			text[3].setText("棋盘范围为[5,8]");
			show=1;
			num=0;
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					Butt0[i][j].setText("");
					chessboard[i][j]=0;
				}
			}
			jta[0].setText("");
			jta[1].setText("");
		}
		if(massag.getSource() == Butt[3]) {
			t=new Thread(this);
			t.start();
		}
		if(massag.getSource() == Butt[4]) {
			if(text[0].getText().equals("") || text[1].getText().equals("") || text[2].getText().equals(""))
				text[3].setText("请输入起点和棋盘大小");
			else {
				String result;
				ioFile io=new ioFile();
				this.jta[0].setText("");
				int[] start=new int[2];
				start[0]=Integer.parseInt(this.text[0].getText());
				start[1]=Integer.parseInt(this.text[1].getText());
				ArrayList<String> a=this.AllPath(start);
				try {
					for(int j=0;j<a.size();j++) {
						String s=a.get(j);
						io.BufWriter(s);
					}
					result=io.BufReader();
					this.jta[0].setText("字符流:"+result);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
        if(massag.getSource() == Butt[5]) {
            if(text[0].getText().equals("") || text[1].getText().equals("") || text[2].getText().equals(""))
                text[3].setText("请输入起点和棋盘大小");
            else {
                String result;
                ioFile io=new ioFile();
                this.jta[1].setText("");
                int[] start=new int[2];
                start[0]=Integer.parseInt(this.text[0].getText());
                start[1]=Integer.parseInt(this.text[1].getText());
                ArrayList<String> a=this.AllPath(start);
                try {
                    for(int j=0;j<a.size();j++) {
                        String s=a.get(j);
                        io.BufOutput(s);
                    }
                    result=io.BufInput();
                    this.jta[1].setText("字节流:"+result);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
	} 
	private void start(int[] b) {
		int count=1,direction=1;
		while(count<=size*size && direction != 0) {
			chessboard[b[0]][b[1]]=count;
			direction=select(b);
			if(direction==0 && count<size*size) {
				text[3].setText("第"+count+"步无路可走");
			}
			else {
				count++;
				b=GoAStep1(b,direction);
			}
			if(count==size*size) {
				text[3].setText("可以走完");
			}
		}
	}
	private int select(int[] p) {
		int direction=0;
		int minroad=8;
		for(int i=1;i<=8;i++)
		{
			int road=0;
			int r[]=GoAStep1(p,i);
			if(isValid1(r))
			{
				for(int j=1;j<=8;j++)
				{
					int s[]=GoAStep1(r,j);
					if(isValid1(s))
					{
						road++;
					}
				}
				if(road<minroad)
				{
					minroad=road;
					direction=i;
				}
			}
		}
		return direction;
	}
	private void dirSwitch(int direction){
		switch(direction)
		{
			case 1:x-=2;y++;break;
			case 2:x--;y+=2;break;
			case 3:x++;y+=2;break;
			case 4:x+=2;y++;break;
			case 5:x+=2;y--;break;
			case 6:x++;y-=2;break;
			case 7:x--;y-=2;break;
			case 8:x-=2;y--;break;
		}
	}
	private int[] GoAStep1(int[] p,int direction)
	{
		int q[] = new int[2];
		x=p[0];
		y=p[1];
		dirSwitch(direction);
		q[0]=x;
		q[1]=y;
		return q;
	}
	private boolean isValid1(int[] p) {
		return (p[0]>=0&&p[0]<size&&p[1]>=0&&p[1]<size&&chessboard[p[0]][p[1]]==0);
	}
	private boolean isValid2(int[] p) {
		return (p[0]>=0&&p[0]<size&&p[1]>=0&&p[1]<size);
	}
	private int[] GoAStep2(int[] start,Stack s) {
		for(int direction=start[2]+1;direction<9;direction++) {
			int[] q = new int[3];
			x=start[0];
			y=start[1];
			dirSwitch(direction);
			q[0]=x;
			q[1]=y;
			if((!this.IsInStack(q, s))&&this.isValid2(q)) {
				start[2]=direction;
				return q;
			}
		}
		return null;
	}
	private boolean IsInStack(int[] i,Stack s) {
		Iterator it=s.iterator();
		int flag=0;
		while(it.hasNext()) {
			int[] temp=(int[]) it.next();
			int j=0;
			for(;j<2;j++) {
				if(temp[j]!=i[j]) {
					break;
				}
			}
			if(j==2) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
			return false;
		}else{
			return true;
		}
	}
	private ArrayList<String> AllPath(int[] s) {
		size=Integer.parseInt(text[2].getText());
		ArrayList<String> a=new ArrayList<>();
		Stack<int[]>p=new Stack<>();
		int[] start=new int[3];
		start[0]=s[0];
		start[1]=s[1];
		p.push(start);
		while(!p.isEmpty()) {
			int[] j;
			j=this.GoAStep2(start,p);
			if(j!=null) {
				p.push(j);
				start=j;			
			}
			else {
				if(p.size()==size*size) {
					String str=this.Pathoutput(p);
					a.add(str);	
					p.pop(); 	
					if(a.size()>2) {
						return a;
					}
				}else{
					p.pop();
					if(!p.isEmpty())
					start=p.peek();
				}				
			}	
		}
		return a;
	}
	private String Pathoutput(Stack s) {
		String str="";
		for(int j=0;j<size*size;j++) {
			int[] i=(int[])s.get(j);
			str+=this.Arrayc(i)+"->";
		}
		return str.substring(0,str.length()-2);
	}
	private String Arrayc(int[] i) {
		return "("+i[0]+","+i[1]+")";
	}
	public void run() {
		if(text[0].getText().equals("") || text[1].getText().equals("") || text[2].getText().equals(""))
			text[3].setText("请输入起点和棋盘大小");
		else {
			if(show==1) {
                Show1();
            }
			while(num!=size*size && show==2) {
				num++;
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(chessboard[i][j]==num) {
							Butt0[i][j].setText(Integer.toString(chessboard[i][j]));
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
	public static void main(String args[]) {
		new Knightjourney();
	}
}