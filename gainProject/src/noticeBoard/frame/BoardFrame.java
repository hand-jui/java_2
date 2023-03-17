package noticeBoard.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import noticeBoard.controller.Controller;
import noticeBoard.dto.DTO;

public class BoardFrame extends JFrame {

	DTO dto = new DTO();

	JPanel jpanel;
	JLabel notice;
	JTextArea tArea;
	JButton writeB;
	JButton updateB;
	JButton deleteB;
	Controller controller;
	
	public BoardFrame() {
		initData();
		setInitLayout();
		addEventListener();
       
	}

	private void initData() {
		setTitle("게시판");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controller = new Controller();
		ArrayList<DTO> noticeList =  controller.select();
	
//		System.out.println(noticeList.get(0).getNo());
		
		jpanel = new JPanel();
		jpanel.setSize(600, 600);
		jpanel.setLocation(0, 0);

		notice = new JLabel("게시판");
		notice.setSize(400, 50);
		notice.setLocation(50, 30);

		tArea = new JTextArea();
		tArea.setSize(500, 400);
		tArea.setLocation(50, 100);
		for (int i = 0; i < noticeList.size(); i++) {
			tArea.append(noticeList.get(i)+"\n");
		}

		writeB = new JButton("글 쓰기");
		writeB.setSize(100, 30);
		writeB.setLocation(50, 500);

		updateB = new JButton("수정");
		updateB.setSize(100, 30);
		updateB.setLocation(250, 500);

		deleteB = new JButton("삭제");
		deleteB.setSize(100, 30);
		deleteB.setLocation(450, 500);

		
	}

	private void setInitLayout() {
		setLayout(null);
		jpanel.setLayout(null);
		jpanel.add(notice);
		jpanel.add(tArea);
		jpanel.add(writeB);
		jpanel.add(updateB);
		jpanel.add(deleteB);
//		jpanel.add(not/);/
		add(jpanel);
		setResizable(false);
		setContentPane(jpanel);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addEventListener() {
		
		

		writeB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new postFrame();
				dispose();
			}
		});

		updateB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new postFrame();
				dispose();
			}
		});

	}
}
