import java.util.logging.Logger;

import viparammo.log.MyHandler;
import viprammo.data.ImageCreater;
import viprammo.gui.FirstWindow;


public class VIPMMO {

	/**
	 * ��������J�n�@���C��
	 * @param args
	 */
	public static void main(String[] args) {

		Logger logger = Logger.getLogger(VIPMMO.class.getName());
		logger.addHandler(new MyHandler());
		
		logger.info("�N�����܂���");
		logger.info("�摜�̓ǂݍ��݊J�n");
		
		//�摜�̓ǂݍ��݁igetInstance����Ύ����I�ɗ���new����ĉ摜���������ɓ���j
		ImageCreater.getInstance();
		
		//���O���͉�ʁi���O�C����ʁj�\��
		logger.info("���O�C����ʕ\��");
		
		new FirstWindow();

	}

}
