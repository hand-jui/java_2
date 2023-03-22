package noticeBoard.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlertFrame extends JFrame {

	JLabel label;
	String msg;

	JButton okBtn;

	public AlertFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("경고");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		msg = null;
		label = new JLabel();
		label.setSize(150, 50);
		label.setLocation(50, 50);

		okBtn = new JButton("확인");
		okBtn.setSize(60, 30);
		okBtn.setLocation(95, 120);
	}

	private void setInitLayout() {
		setLayout(null);
		add(okBtn);
		add(label);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addEventListener() {

		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
				
			}
		});
	}

	public static void main(String[] args) {
		new AlertFrame();
	}
}
