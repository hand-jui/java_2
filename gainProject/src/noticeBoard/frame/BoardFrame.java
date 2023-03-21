package noticeBoard.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import noticeBoard.controller.Controller;
import noticeBoard.dao.DAO;
import noticeBoard.dto.DTO;

public class BoardFrame extends JFrame {

	DTO dto = new DTO();

	JPanel jpanel;

	JLabel notice;
	JLabel title;
	JLabel nickname;

	NoticeTable noticeTable;

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

		jpanel = new JPanel();
		jpanel.setSize(600, 600);
		jpanel.setLocation(0, 0);

		notice = new JLabel("notice");
		notice.setSize(400, 50);
		notice.setLocation(230, 30);
		notice.setFont(new Font("태나다체", Font.BOLD, 50));

		noticeTable = new NoticeTable();
		noticeTable.setLocation(50, 100);
		noticeTable.setSize(500, 300);

//		noticeTable = new JTable();
//		noticeTable.setSize(500, 300);
//		noticeTable.setLocation(50, 150);
//		noticeTable.setFont(new Font("맑은고딕", Font.BOLD, 13));
//		for (int i = 0; i < noticeList.size(); i++) {
//			noticeTable.append(noticeList.get(i) + "\n");
//		}
//		boardTable = new BoardTable();
//		boardTable.setLocation(50, 150);
//		boardTable.setFont(new Font("맑은고딕", Font.BOLD,13));

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
//		jpanel.add(title);
//		jpanel.add(nickname);
		jpanel.add(noticeTable);
		jpanel.add(writeB);
		jpanel.add(updateB);
		jpanel.add(deleteB);
		add(jpanel);
		setResizable(false);
		setContentPane(jpanel);
		setLocationRelativeTo(null);
		noticeTable.setVisible(true);
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
				DAO dao = new DAO();
				DTO dto = dao.selectByNo(noticeTable.noticeTable.getSelectedRow());

//				System.out.println();
//				int c1 = (int) noticeTable.dtm.getValueAt(noticeTable.noticeTable.getSelectedRow(), 0);
//				String c2 = (String) noticeTable.dtm.getValueAt(noticeTable.noticeTable.getSelectedRow(), 1);
//				String c3 = (String) noticeTable.dtm.getValueAt(noticeTable.noticeTable.getSelectedRow(), 2);

				new updateFrame(dto);
				dispose();
			}
		});

		deleteB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DAO dao = new DAO();
				DTO dto = dao.selectByNo(noticeTable.noticeTable.getSelectedRow());
				controller.delete(dto);
				repaint();
			}
		});
	}

}

class NoticeTable extends JPanel {

	Object record[] = new Object[3];
	String[] field = { "NO", "TITLE", "NICKNAME" };
	DefaultTableModel dtm = new DefaultTableModel(field, 0);
	JTable noticeTable = new JTable(dtm);
	JScrollPane scrollPane = new JScrollPane(noticeTable);

	public NoticeTable() {
		add(scrollPane, "Center");
		Controller controller = new Controller();
		ArrayList<DTO> noticeList = controller.select();
		for (int i = 0; i < noticeList.size(); i++) {
			DTO dto = noticeList.get(i);
			record[0] = noticeList.get(i).getNo();
			record[1] = noticeList.get(i).getTitle();
			record[2] = noticeList.get(i).getNickname();
			dtm.addRow(record);
		}
	}

}
