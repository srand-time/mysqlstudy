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
public class delete_frame extends JFrame{
	public static void main() {
		JFrame frame=new delete_frame();
		frame.setTitle("ɾ���ͻ�����Ϣ");
	    frame.setBounds(100,100,500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLayout(null);
		}
	
	public delete_frame() {
		JLabel L1=new JLabel("��Ҫɾ���Ŀͻ������֤�ţ�(20)");
		JTextField t1=new JTextField(20);
		JButton jbt1=new JButton("���ؿͻ�����");
        JButton jbt2=new JButton("ɾ��");
        JPanel pane=new JPanel();
        pane.setLayout(null);
        L1.setBounds(20, 10, 200, 20);t1.setBounds(20, 40, 140, 20);
        jbt1.setBounds(20,370,140,20);jbt2.setBounds(20,400,140,20);
        pane.add(L1);pane.add(t1);
        pane.add(jbt1);pane.add(jbt2);
        add(pane);
        ListenerClass1 listener1=new ListenerClass1();
        jbt1.addActionListener(listener1);
        jbt2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
		        String s1=t1.getText();
		        String sql="delete from customer_table where idcard_number='"+s1+"'";
		        try {
					main.sql_va.conn.createStatement().executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"�ѳɹ�ɾ���ͻ��������֤��Ϊ"+s1);
        		} 
        		catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
