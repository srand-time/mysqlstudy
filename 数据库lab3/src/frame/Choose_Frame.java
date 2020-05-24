package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Choose_Frame extends JFrame{
    
    public static void main() {
        JFrame frame=new Choose_Frame();
        frame.setTitle("选择功能");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Choose_Frame()
    {
        JButton jbt1=new JButton("客户管理");
        JButton jbt2=new JButton("账户管理");

        //把两个按钮放到panel里面
        JPanel panel1=new JPanel();
        panel1.add(jbt1);
        panel1.add(jbt2);
        add(panel1);

        //实例化一个监听器，监听器类在下方
        ListenerClass1 listener1=new ListenerClass1();
        ListenerClass2 listener2=new ListenerClass2();
        jbt1.addActionListener(listener1);
        jbt2.addActionListener(listener2);
    }

class ListenerClass1 implements ActionListener{
	//客户管理监听器
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        Client_Frame.main();
    }
}

class ListenerClass2 implements ActionListener{
	//账户管理监听器
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
}