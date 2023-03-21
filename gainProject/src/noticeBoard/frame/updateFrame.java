package noticeBoard.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import noticeBoard.controller.Controller;
import noticeBoard.dto.DTO;

public class updateFrame extends postFrame {
	public updateFrame(DTO dto) {
		super();
		super.getTitleText().setText(dto.getTitle());
		super.gettArea().setText(dto.getContent());
		super.getNickText().setText(dto.getNickname());
		super.getPwText().setText(dto.getPassword());
	}

	@Override
	public void addEventListener() {

		postB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DTO dto = new DTO();
				dto.setTitle(titleText.getText());
				dto.setContent(tArea.getText());
				dto.setNickname(nickText.getText());
				dto.setPassword(pwText.getText());

				Controller controller = new Controller();
				int result = controller.edit(dto);
				System.out.println(result);

				new BoardFrame();
				dispose();
			}
		});
	}
}
