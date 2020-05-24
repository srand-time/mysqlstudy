package client_operation;
import main.sql_va;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import frame.Client_Frame;
public class query_frame extends JFrame{
	public static void main() throws Exception{
	JFrame frame=new query_frame();
	frame.setTitle("�ͻ���Ϣ��ѯ");
    frame.setBounds(100,100,1200,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
	
	public query_frame() throws Exception{
		ResultSet rs = sql_va.stmt.executeQuery("SELECT * FROM customer_table "
				+ "left join customer_contactor_table on customer_table.contactor_id"
				+ "=customer_contactor_table.id");
        rs.last();
		int row_count=rs.getRow();
		rs.first();
		String []column_name= {"���֤��","�ͻ�����","��ϵ�绰"
				,"��ϵ�˱��","��ϵ����ͻ���ϵ","��ͥסַ","��ϵ�˱��"
				,"��ϵ������","��ϵ���ֻ���","��ϵ��email"};
		Object [][]data=new String[row_count][10];
		for(int i=0;i<row_count;i++)
        {
        	for(int j=0;j<10;j++)
        	{
        		if(j==4)
        		{
        			if(rs.getString(j+1).equals("2"))
        				data[i][j]="����";
        			else if(rs.getString(j+1).equals("4"))
        				data[i][j]="����";
        			else if(rs.getString(j+1).equals("3"))
        				data[i][j]="��ż";
        			else
        				data[i][j]="����";
        		}
        		else
        			data[i][j]=rs.getString(j+1);
        	}
        	rs.next();
        }
        JTable table=new JTable(data,column_name);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        add(jScrollPane,BorderLayout.CENTER);
        
        
        JButton jbt1=new JButton("���ؿͻ�����");
        JPanel pane=new JPanel();JPanel pane2=new JPanel();
        JButton jbt2=new JButton("�����֤�Ų�ѯ");
        JLabel L1=new JLabel("���֤�ţ�(20)");
        JTextField t1=new JTextField(20);
        pane2.add(L1);pane2.add(t1);
        pane.add(jbt1);pane2.add(jbt2);
        add(pane,BorderLayout.SOUTH);
        add(pane2,BorderLayout.NORTH);
        ListenerClass1 listener1=new ListenerClass1();
        jbt1.addActionListener(listener1);
        
        jbt2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		JFrame frame=new JFrame();
        		frame.setTitle("�����֤�Ų�ѯ�ͻ���Ϣ");
        	    frame.setBounds(200,200,1200,100);
        	    frame.setVisible(true);
		        String s1=t1.getText();
		        if(s1.length()>20)
		        	{JOptionPane.showMessageDialog(null,"�������,����������");}
		        else if(s1.length()==0)
		        	{JOptionPane.showMessageDialog(null,"�˴����֤�Ų���Ϊ��");}
		        else
		        {	        	   
		        		String sql = "SELECT * FROM customer_table "
		        				+ "left join customer_contactor_table on customer_table.contactor_id"
		        				+ "=customer_contactor_table.id where idcard_number='"
		        				+s1+"';";
		        		try {
		        			ResultSet rs = sql_va.stmt.executeQuery(sql);
		        			rs.last();
		        			int row_count=rs.getRow();
		        			rs.first();
		        			String []column_name= {"���֤��","�ͻ�����","��ϵ�绰"
		        					,"��ϵ�˱��","��ϵ����ͻ���ϵ","��ͥסַ","��ϵ�˱��"
		        					,"��ϵ������","��ϵ���ֻ���","��ϵ��email"};
		        			Object [][]data=new String[row_count][10];
		        			for(int i=0;i<row_count;i++)
		        	        {
		        	        	for(int j=0;j<10;j++)
		        	        	{
		        	        		if(j==4)
		        	        		{
		        	        			if(rs.getString(j+1).equals("2"))
		        	        				data[i][j]="����";
		        	        			else if(rs.getString(j+1).equals("4"))
		        	        				data[i][j]="����";
		        	        			else if(rs.getString(j+1).equals("3"))
		        	        				data[i][j]="��ż";
		        	        			else
		        	        				data[i][j]="����";
		        	        		}
		        	        		else
		        	        			data[i][j]=rs.getString(j+1);
		        	        	}
		        	        	rs.next();
		        	        }
		        	        JTable table=new JTable(data,column_name);
		        	        JScrollPane jScrollPane = new JScrollPane();
		        	        jScrollPane.setViewportView(table);
		        	        frame.add(jScrollPane,BorderLayout.CENTER);
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
