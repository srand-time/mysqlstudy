package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import client_operation.*;

//客户管理窗口
public class Client_Frame extends JFrame{
	public static void main() {
        JFrame frame=new Client_Frame();
        frame.setTitle("客户管理");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
    public Client_Frame()
        {
            JButton jbt1=new JButton("查询客户信息");
            JButton jbt2=new JButton("增加客户");
            JButton jbt3=new JButton("修改客户信息");
            JButton jbt4=new JButton("删除客户信息");
            JButton jbt5=new JButton("返回上一级");
            JButton jbt6=new JButton("查询联系人信息");
            JButton jbt7=new JButton("添加联系人信息");
            
            //把按钮放到panel里面
            JPanel panel1=new JPanel();
            panel1.add(jbt1);panel1.add(jbt6);
            panel1.add(jbt2);panel1.add(jbt7);panel1.add(jbt3);
            panel1.add(jbt4);panel1.add(jbt5);
            add(panel1);

            //实例化一个监听器，监听器类在下方
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
    	//查询监听器
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
    	//增加客户监听器
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
    	//修改客户信息监听器
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            client_operation.update_frame.main();
        }
    }
    
    class ListenerClass4 implements ActionListener{
    	//删除客户信息监听器
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            client_operation.delete_frame.main();
        }
    }
    
    class ListenerClass5 implements ActionListener{
    	//返回上一级
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            Choose_Frame.main();
        }
    }
    
    class ListenerClass6 implements ActionListener{
    	//查询监听器
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
    	//增加客户监听器
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
