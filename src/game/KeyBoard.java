/*
 �÷��̾��� �������� ��������!!
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	
	Player player;
	Bullet bullet;
	
	public KeyBoard(Player player) {
		this.player =player;
	}
	
	//Ű���� ������ �����̴� ����
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//�Ұ�ȣ ���� ���� ���� ������ �������ڴ�.
		switch(key) {
		
			case KeyEvent.VK_LEFT:
				player.velX=-2;break;
			case KeyEvent.VK_RIGHT:
				player.velX=+2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=+2;break;
			case KeyEvent.VK_SPACE:
				player.fire();break;
		}
	}
	
	//Ű���� ���� �ȿ����̴� ����
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//�Ұ�ȣ ���� ���� ���� ������ �������ڴ�.
		switch(key) {
		
			case KeyEvent.VK_LEFT:
				player.velX=0;break;
			case KeyEvent.VK_RIGHT:
				player.velX=0;break;
			case KeyEvent.VK_UP:
				player.velY=0;break;
			case KeyEvent.VK_DOWN:
				player.velY=0;break;
		}
	}

}