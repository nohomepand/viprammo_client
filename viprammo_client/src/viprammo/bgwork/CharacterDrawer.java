package viprammo.bgwork;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import viprammo.data.ImageCreater;
import viprammo.gui.MainWindow;

/**
 * �L�����N�^�[�̕`����s���N���X�iCharanterDrawer.getInstance().draw()�j�����ƕ`��
 * �����I�ɂ͑S�Ă̕`��n�����i�`���b�g���܂߁j�������ōs���\��
 * �e����new���ꂽ�獢���ŃV���O���g��
 * @author Yukihiro
 *
 */
public class CharacterDrawer {

	//�C���X�^���X
	private static CharacterDrawer instance = new CharacterDrawer();

	//�g���邱�ƂȂ��悤private�Ɂi���m�ɂ�getInstance���ŏ��ɍs�����Ƃ����s����邯�ǁj
	private CharacterDrawer() {
	}

	/**
	 * �C���X�^���X�Q�b�^�[
	 * @return �B��̂����̃C���X�^���X��Ԃ��i�܂�ǂ��ŌĂ΂�Ă����������ɃA�N�Z�X�j
	 */
	public static CharacterDrawer getInstance() {
		return instance;
	}

	/**
	 * ���̃N���X�̖{�̏���
	 * �T�[�o���痈���w�߂����s����
	 * @param val �����ɂ͍��̂Ƃ���T�[�o���痈���R�}���h�������^����j
	 */
	public void draw(String val) {

		
		String[] valsp1 = val.replaceAll("\r\n", "").split("-");

		String[] valsplit = valsp1[1].split(",");

		int count = Integer.parseInt(valsp1[0]);
		
		//�o�b�t�@�쐬
		final Image buff_img = MainWindow.getInstance().panel.createImage(
				MainWindow.getInstance().panel.getWidth(), MainWindow.getInstance().panel.getHeight());
		
		Graphics2D g2d = (Graphics2D) buff_img.getGraphics();
		
		for (int i = 0; i < count; i++) {
			
			String method = valsplit[0+(i*4)+i];
			String name = valsplit[1+(i*4)+i];
			String muki = valsplit[4+(i*4)+i];
			
			int x = Integer.parseInt(valsplit[2+(i*4)+i]);
			int y = Integer.parseInt(valsplit[3+(i*4)+i]);
			String pmuki = muki;
			
			if (method.equals("M")) {

				//�o�b�t�@�Ɍ����ɉ������摜��`�悷��i�摜�͓ǂݍ��ݍς݂̃f�[�^����������ImageObserver�͕s�v�j
				g2d.drawImage(ImageCreater.getInstance().getImg(pmuki), x, y, null);
				//���O��\������
				g2d.drawString(name, x+35, y+35);
				
			}
		}
		
		//�`��ς݂̃o�b�t�@���E�B���h�E�ɕ`�悷��
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow.getInstance().panel.getGraphics().drawImage(buff_img, 0, 0, MainWindow.getInstance().panel);
			}
		});
		
	}
}
