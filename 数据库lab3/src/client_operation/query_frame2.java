package client_operation;
import main.sql_va;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import frame.Client_Frame;
public class query_frame2 extends JFrame{
	public static void main() throws Exception{
	JFrame frame=new query_frame2();
	frame.setTitle("��ϵ����Ϣ��ѯ");
    frame.setBounds(100,100,1200,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
	
	public query_frame2() throws Exception{
		ResultSet rs = sql_va.stmt.executeQuery("SELECT * FROM customer_contactor_table ");
        rs.last();
		int row_count=rs.getRow();
		rs.first();
		String []column_name= {"��ϵ�˱��","��ϵ������","��ϵ���ֻ���","��ϵ��email"};
		Object [][]data=new String[row_count][4];
		for(int i=0;i<row_count;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		data[i][j]=rs.getString(j+1);
        	}
        	rs.next();
        }
        JTable table=new JTable(data,column_name);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        add(jScrollPane,BorderLayout.CENTER);
        
        
        JButton jbt1=new JButton("���ؿͻ�����");
        JPanel pane=new JPanel();
        pane.add(jbt1);
        add(pane,BorderLayout.SOUTH);
        ListenerClass1 listener1=new ListenerClass1();
        jbt1.addActionListener(listener1);
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