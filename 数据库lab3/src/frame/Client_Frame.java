package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import client_operation.*;

//�ͻ�������
public class Client_Frame extends JFrame{
	public static void main() {
        JFrame frame=new Client_Frame();
        frame.setTitle("�ͻ�����");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
    public Client_Frame()
        {
            JButton jbt1=new JButton("��ѯ�ͻ���Ϣ");
            JButton jbt2=new JButton("���ӿͻ�");
            JButton jbt3=new JButton("�޸Ŀͻ���Ϣ");
            JButton jbt4=new JButton("ɾ���ͻ���Ϣ");
            JButton jbt5=new JButton("������һ��");
            JButton jbt6=new JButton("��ѯ��ϵ����Ϣ");
            JButton jbt7=new JButton("�����ϵ����Ϣ");
            
            //�Ѱ�ť�ŵ�panel����
            JPanel panel1=new JPanel();
            panel1.add(jbt1);panel1.add(jbt6);
            panel1.add(jbt2);panel1.add(jbt7);panel1.add(jbt3);
            panel1.add(jbt4);panel1.add(jbt5);
            add(panel1);

            //ʵ����һ���������������������·�
            ListenerClass1 listener1=new ListenerClass1();
            ListenerClass2 listener2=new ListenerClass2();
            ListenerClass3 listener3=new ListenerClass3();
            ListenerClass4 listener4=new ListenerClass4();
            ListenerClass5 listener5=new ListenerClass5();
            ListenerClass6 listener6=new ListenerClass6();
            ListenerClass7 listener7=new ListenerClass7();
            jbt1.addActionListener(listener1);
            jbt2.addActionListener(listener2);
            jbt3.addActionListener(listener3);
            jbt4.addActionListener(listener4);
            jbt5.addActionListener(listener5);
            jbt6.addActionListener(listener6);
            jbt7.addActionListener(listener7);
        }

    class ListenerClass1 implements ActionListener{
    	//��ѯ������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            try {
				client_operation.query_frame.main();
			} 
            catch (Exception e1) {
				e1.printStackTrace();
			}
        }
    }

    class ListenerClass2 implements ActionListener{
    	//���ӿͻ�������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            try {
				client_operation.add_frame.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    
    class ListenerClass3 implements ActionListener{
    	//�޸Ŀͻ���Ϣ������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            client_operation.update_frame.main();
        }
    }
    
    class ListenerClass4 implements ActionListener{
    	//ɾ���ͻ���Ϣ������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            client_operation.delete_frame.main();
        }
    }
    
    class ListenerClass5 implements ActionListener{
    	//������һ��
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            Choose_Frame.main();
        }
    }
    
    class ListenerClass6 implements ActionListener{
    	//��ѯ������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            try {
				client_operation.query_frame2.main();
			} 
            catch (Exception e1) {
				e1.printStackTrace();
			}
        }
    }
    
    class ListenerClass7 implements ActionListener{
    	//���ӿͻ�������
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            try {
				client_operation.add_frame2.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
}
