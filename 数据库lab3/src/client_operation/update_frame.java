package client_operation;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import frame.Client_Frame;
public class update_frame extends JFrame{
	public static void main() {
		JFrame frame=new update_frame();
		frame.setTitle("���¿ͻ�����Ϣ");
	    frame.setBounds(100,100,500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLayout(null);
		}
	
	public update_frame() {
		JLabel L1=new JLabel("��Ҫ���µĿͻ������֤�ţ�(20)");
		JTextField t1=new JTextField(20);
		JTextField t3=new JTextField(15);JTextField t4=new JTextField(15);
        JTextField t5=new JTextField(2);JTextField t6=new JTextField(20);
		JLabel L3=new JLabel("��ϵ�绰��(15)");JLabel L4=new JLabel("��ϵ�˱�ţ�(11)");
		JLabel L5=new JLabel("��ϵ����ͻ���ϵ��(1λ����)");JLabel L6=new JLabel("��ͥסַ��(20)");
		JButton jbt1=new JButton("���ؿͻ�����");
        JButton jbt2=new JButton("����");
        JPanel pane=new JPanel();
        pane.setLayout(null);
        L1.setBounds(20, 10, 200, 20);t1.setBounds(20, 40, 140, 20);
        L3.setBounds(20, 130, 140, 20);t3.setBounds(20, 160, 140, 20);
        L4.setBounds(20, 190, 140, 20);t4.setBounds(20, 220, 140, 20);
        L5.setBounds(20, 250, 200, 20);t5.setBounds(20, 280, 140, 20);
        L6.setBounds(20, 310, 140, 20);t6.setBounds(20, 340, 140, 20);
        jbt1.setBounds(20,370,140,20);jbt2.setBounds(20,400,140,20);
        pane.add(L1);pane.add(t1);
        pane.add(L3);pane.add(t3);pane.add(L4);pane.add(t4);
        pane.add(L5);pane.add(t5);pane.add(L6);pane.add(t6);
        pane.add(jbt1);pane.add(jbt2);
        add(pane);
        ListenerClass1 listener1=new ListenerClass1();
        jbt1.addActionListener(listener1);
        jbt2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		String s1=t1.getText();
		        String s3=t3.getText();String s4=t4.getText();
		        String s5=t5.getText();String s6=t6.getText();
		        if(s1.length()>20||s3.length()>15||
				        s4.length()>11||s5.length()>2||s6.length()>20)
				        	{JOptionPane.showMessageDialog(null,"�������,����������");}
		        else if(s5.length()!=0&&(s5.charAt(0)<'0'||s5.charAt(0)>'9'))
				        	{JOptionPane.showMessageDialog(null,"��ϵ����ͻ���ϵ��ֻ����������");}
		        else if(s1.length()==0||s4.length()==0||s5.length()==0)
	        		{JOptionPane.showMessageDialog(null,"���֤�ź���ϵ����Ϣ������Ϊ��");}
		        else 
		        {
		        if(s3.length()==0)s3="NULL";
		        if(s6.length()==0)s6="NULL";
		        String sql="update customer_table set phone_number='"+ 
		        s3+"',contactor_id="+s4+",relationship="+s5
		        +",live_place='"+s6+"' "+"where idcard_number='"+s1+"'";
		        	try {
					main.sql_va.conn.createStatement().executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"�ѳɹ����¿ͻ���Ϣ�������֤��Ϊ"+s1);
		        	} 
		        	catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		        	}
		        }
        	}
        });
        
        
	}
	
	class ListenerClass1 implements ActionListener{
		//�ͻ����������
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        dispose();
	        Client_Frame.main();
	    }
	}
}
