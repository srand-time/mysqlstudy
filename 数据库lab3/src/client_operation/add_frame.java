package client_operation;
import main.sql_va;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import frame.Client_Frame;
public class add_frame extends JFrame{

	public static void main() throws Exception{
		JFrame frame=new add_frame();
		frame.setTitle("新增客户的信息");
	    frame.setBounds(100,100,500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLayout(null);
		}
		
		public add_frame() {
			JLabel L1=new JLabel("身份证号：(20)");JLabel L2=new JLabel("客户姓名：(15)");
			JLabel L3=new JLabel("联系电话：(15)");JLabel L4=new JLabel("联系人编号：(15)");
			JLabel L5=new JLabel("联系人与客户关系：(1位整数)");JLabel L6=new JLabel("家庭住址：(20)");
	        setResizable(false);
	        JTextField t1=new JTextField(20);JTextField t2=new JTextField(15);
	        JTextField t3=new JTextField(15);JTextField t4=new JTextField(15);
	        JTextField t5=new JTextField(2);JTextField t6=new JTextField(20);
	        JButton jbt1=new JButton("返回客户管理");
	        JButton jbt2=new JButton("添加信息");
	        JPanel pane=new JPanel();
	        pane.setLayout(null);
	        L1.setBounds(20, 10, 140, 20);t1.setBounds(20, 40, 140, 20);
	        L2.setBounds(20, 70, 140, 20);t2.setBounds(20, 100, 140, 20);
	        L3.setBounds(20, 130, 140, 20);t3.setBounds(20, 160, 140, 20);
	        L4.setBounds(20, 190, 140, 20);t4.setBounds(20, 220, 140, 20);
	        L5.setBounds(20, 250, 200, 20);t5.setBounds(20, 280, 140, 20);
	        L6.setBounds(20, 310, 140, 20);t6.setBounds(20, 340, 140, 20);
	        jbt1.setBounds(20,370,140,20);jbt2.setBounds(20,400,140,20);
	        pane.add(L1);pane.add(t1);pane.add(L2);pane.add(t2);
	        pane.add(L3);pane.add(t3);pane.add(L4);pane.add(t4);
	        pane.add(L5);pane.add(t5);pane.add(L6);pane.add(t6);
	        pane.add(jbt1);pane.add(jbt2);
	        add(pane);
	        ListenerClass1 listener1=new ListenerClass1();
	        jbt1.addActionListener(listener1);
	        //ListenerClass2 listener2=new ListenerClass2();
	        
	        jbt2.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) 
	        	{
			        String s1=t1.getText();String s2=t2.getText();
			        String s3=t3.getText();String s4=t4.getText();
			        String s5=t5.getText();String s6=t6.getText();
			        if(s1.length()>20||s2.length()>15||s3.length()>15||
			        s4.length()>15||s5.length()>2||s6.length()>20)
			        	{JOptionPane.showMessageDialog(null,"输入过长,请重新输入");}
			        else if(s5.length()!=0&&(s5.charAt(0)<'0'||s5.charAt(0)>'9'))
			        	{JOptionPane.showMessageDialog(null,"联系人与客户关系栏只能输入整数");}
			        else if(s1.length()==0||s2.length()==0||s4.length()==0||s5.length()==0)
			        	{JOptionPane.showMessageDialog(null,"身份证号,姓名和联系人信息都不能为空");}
			        else
			        {
				        if(s3.length()==0)s3="NULL";
				        if(s6.length()==0)s6="NULL";
			        	
				        
			        		String sql = "insert into customer_table values('"+s1+"','"
				        	+s2+"','"+s3+"','"+s4+"',"+s5+",'"+s6+"');";
			        		try {
								main.sql_va.conn.createStatement().executeUpdate(sql);
								JOptionPane.showMessageDialog(null,"成功添加信息");
			        		} 
			        		catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			        	dispose();
			        	Client_Frame.main();
			        }
			    }
	        });
	        
	        
		}
		
		class ListenerClass1 implements ActionListener{
			//客户管理监听器
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		        Client_Frame.main();
		    }
		}
}
