/*
 1. ������� ����� ������ ����. setSize x!
 2. �����쿡 GamePanel�� ������.
 3. Thread ��������.

 */
package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	GamePanel gamePanel;

	public GameWindow() {
		
		///setLayout(new FlowLayout());
		gamePanel = new GamePanel();
		add(gamePanel);
		
		//add(gamePanel)�� ��,�гο� ���α׷��� ������ ��Ŀ�� �ø���!
		gamePanel.setFocusable(true);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
