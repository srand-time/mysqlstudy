package client_operation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import frame.Client_Frame;
public class add_frame2 extends JFrame{

	public static void main() throws Exception{
		JFrame frame=new add_frame2();
		frame.setTitle("新增联系人的信息");
	    frame.setBounds(100,100,500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLayout(null);
		}
		
		public add_frame2() {
			JLabel L1=new JLabel("联系人姓名：(15)");JLabel L2=new JLabel("联系人电话：(15)");
			JLabel L3=new JLabel("联系人email：(20)");
	        setResizable(false);
	        JTextField t1=new JTextField(15);JTextField t2=new JTextField(15);
	        JTextField t3=new JTextField(20);
	        JButton jbt1=new JButton("返回客户管理");
	        JButton jbt2=new JButton("添加信息");
	        JPanel pane=new JPanel();
	        pane.setLayout(null);
	        L1.setBounds(20, 10, 140, 20);t1.setBounds(20, 40, 140, 20);
	        L2.setBounds(20, 70, 140, 20);t2.setBounds(20, 100, 140, 20);
	        L3.setBounds(20, 130, 140, 20);t3.setBounds(20, 160, 140, 20);
	        jbt1.setBounds(20,370,140,20);jbt2.setBounds(20,400,140,20);
	        pane.add(L1);pane.add(t1);pane.add(L2);pane.add(t2);
	        pane.add(L3);pane.add(t3);
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
			        String s3=t3.getText();
			        if(s1.length()>15||s2.length()>15||s3.length()>20)
			        	{JOptionPane.showMessageDialog(null,"输入过长,请重新输入");}
			        else if(s1.length()==0)
			        	{JOptionPane.showMessageDialog(null,"联系人姓名不能为空");}
			        else
			        {
				        if(s3.length()==0)s3="NULL";
			        	if(s2.length()==0)s2="NULL";
				        
			        		String sql = "insert into customer_contactor_table values(null,'"+s1+"','"
				        	+s2+"','"+s3+"');";
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
