package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Choose_Frame extends JFrame{
    
    public static void main() {
        JFrame frame=new Choose_Frame();
        frame.setTitle("ѡ����");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Choose_Frame()
    {
        JButton jbt1=new JButton("�ͻ�����");
        JButton jbt2=new JButton("�˻�����");

        //��������ť�ŵ�panel����
        JPanel panel1=new JPanel();
        panel1.add(jbt1);
        panel1.add(jbt2);
        add(panel1);

        //ʵ����һ���������������������·�
        ListenerClass1 listener1=new ListenerClass1();
        ListenerClass2 listener2=new ListenerClass2();
        jbt1.addActionListener(listener1);
        jbt2.addActionListener(listener2);
    }

class ListenerClass1 implements ActionListener{
	//�ͻ����������
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        Client_Frame.main();
    }
}

class ListenerClass2 implements ActionListener{
	//�˻����������
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
}