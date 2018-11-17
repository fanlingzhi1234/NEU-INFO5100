package assignment8;
/**
* @author Rexus 
* @version Build Time：Nov 9, 2018 3:07:49 AM
* @Explain
*/
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class computer extends JFrame{
	public computer(){
		super("Calculator");
		Font f=new Font("黑体",30,30);
		JTextField jt1=new JTextField(null);
		JTextField jt2=new JTextField(null);
		jt1.setFont(f);
		jt2.setFont(f);
		jt1.setHorizontalAlignment(JTextField.RIGHT);
		jt2.setHorizontalAlignment(JTextField.RIGHT);
		Container c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		c.add(jt1);
		c.add(jt2);
		jt1.setPreferredSize(new Dimension(370,70));	
		jt2.setPreferredSize(new Dimension(370,75));
		jt1.setEditable(false);jt2.setEditable(false);
		JButton jb[]=new JButton[16];
		for(int j=0;j<16;j++)
		{
			jb[j]=new JButton();
			jb[j].setBackground(Color.WHITE);
			jb[j].setFocusable(false);
			jb[j].setPreferredSize(new Dimension(90,90));
			jb[j].setFont(f);
			c.add(jb[j]);
		}
		this.setResizable(false);
		
		//Make buttons;
		jb[0].setText("+");jb[1].setText("-");jb[2].setText("*");jb[3].setText("/");
		jb[4].setText("1");jb[5].setText("2");jb[6].setText("3");jb[7].setText("C");jb[7].setBackground(Color.ORANGE);
		jb[8].setText("4");jb[9].setText("5");jb[10].setText("6");jb[11].setText("0");
		jb[12].setText("7");jb[13].setText("8");jb[14].setText("9");jb[15].setText("=");

		//Add listener;
		JButton Button_num[]={jb[4],jb[5],jb[6],jb[8],jb[9],jb[10],jb[11],jb[12],jb[13],jb[14]};
		for(int i=0;i<Button_num.length;i++){
			Button_num[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JButton action_Button=(JButton)e.getSource();
					jt2.setText(jt2.getText()+action_Button.getText());
				}
			}
					);
		}	

		for(int j=0;j<4;j++){
			jb[j].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s=jt2.getText();
					char ch=s.charAt(s.length()-1);

					if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
						((JButton)e.getSource()).setEnabled(false);
					else{
						jt1.setText(jt2.getText());
						jt2.setText(((JButton)e.getSource()).getText());
					}
				}
			});
		}
	
		
		jb[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jt1.setText(null);jt2.setText(null);
			}
		}
				);
		
		jb[15].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String Calculate_String=jt1.getText()+jt2.getText();
					int result=calculation.result(Calculate_String);
					jt1.setText(null);
					jt2.setText(Integer.toString(result));
				}catch(ArithmeticException ex){
					jt1.setText(null);jt2.setText("ERROR");
				}
			}
		});
	}
	
	public static void main(String args[]){
		computer app=new computer();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400,580);
		app.setVisible(true);
	}
}

//再定义一个计算类calculation.java:

class calculation{
	public calculation(){};
	
	public boolean is_operator(char ch){
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
			return true;
		else 
			return false;
	}
	public static int result(String s){
		String ch[]={"+","-","*","/"};
		int i=0;
		int index;
		
		while(s.indexOf(ch[i])==-1 && i<4){
			i++;
			}
		if(i==4)
			return -1;
		else 
			index=s.indexOf(ch[i]);

		String s1=s.substring(0, index);
		String s2=s.substring(index+1, s.length());
		if(i==0)
			return Integer.parseInt(s1)+Integer.parseInt(s2);
		if(i==1)
			return Integer.parseInt(s1)-Integer.parseInt(s2);
		if(i==2)
			return Integer.parseInt(s1)*Integer.parseInt(s2);
		if(i==3&&Integer.parseInt(s2)!=0)
			return Integer.parseInt(s1)/Integer.parseInt(s2);
		else if(i==3&&Integer.parseInt(s2)==0){
			throw new ArithmeticException();
			}
		
		return -1;
	}
}
