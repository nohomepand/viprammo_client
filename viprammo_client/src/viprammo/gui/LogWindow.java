package viprammo.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class LogWindow implements ActionListener, WindowListener {

	public JFrame frame;
	public JList<String> list;
	public DefaultListModel<String> listmodel;
	public JButton button;
	
	//�܂�����V���O���g���iGUI��new�����Ɩ��B�Ƃ��ɂ����̓��Owindow�Ȃ�Łj
	public static LogWindow instance = new LogWindow();
	
	private LogWindow() {
		
		frame = new JFrame();
		frame.setSize(900, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		list = new JList<String>();
		listmodel = new DefaultListModel<String>();
		list.setModel(listmodel);
		
		JScrollPane scroll_pane = new JScrollPane();
		scroll_pane.getViewport().setView(list);
		
		button = new JButton("�E�B���h�E����");
		button.addActionListener(this);
		
		frame.add(scroll_pane, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		frame.addWindowListener(this);
	}

	/**
	 * �C���X�^���X�Q�b�^�[
	 * @return
	 */
	public static LogWindow getInstance() {
		return instance;
	}
	
	/**
	 * ���O�E�B���h�E�Ƀ��O�o�͂���
	 * @param logstr ���O������
	 */
	public void writeLog(String logstr) {
	
		//�ł��������gui������Ԃ��������̂�500�s���x�Ɏ��߂�
		if (this.listmodel.size() >= 100) {
			this.listmodel.clear();
		}

		//�������牺��GUI�ɕύX�������鏈��
		final String logstr_f = logstr;
		final DefaultListModel<String> dlm = this.listmodel;
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				dlm.add(dlm.getSize(), logstr_f);
				list.setSelectedIndex(dlm.getSize());
				list.ensureIndexIsVisible(dlm.getSize());
			}
		});
		
		
	}

	/**
	 * ���O�E�B���h�E��\������
	 */
	public void show() {
		this.frame.setVisible(true);
	}
	
	/**
	 * ���O�E�B���h�E���B��
	 */
	public void hide() {
		MainWindow.getInstance().menubar.getMenu(1).getItem(0).setEnabled(true);
		this.frame.setVisible(false);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("����")) {
			this.hide();
		}
		
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {

	}

	public void windowClosing(WindowEvent arg0) {
		this.frame.setVisible(false);
		//���̃E�B���h�E���������烁�j���[�̃��O��L����
		MainWindow.getInstance().menubar.getMenu(1).getItem(0).setEnabled(true);
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
