import viprammo.data.ImageCreater;
import viprammo.gui.FirstWindow;


public class VIPMMO {

	/**
	 * ��������J�n�@���C��
	 * @param args
	 */
	public static void main(String[] args) {

		//�摜�̓ǂݍ��݁igetInstance����Ύ����I�ɗ���new����ĉ摜���������ɓ���j
		ImageCreater.getInstance();
		
		//���O���͉�ʁi���O�C����ʁj�\��
		new FirstWindow();

	}

}
