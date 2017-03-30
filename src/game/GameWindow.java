/*
 1. 윈도우는 사이즈를 정하지 말자. setSize x!
 2. 윈도우에 GamePanel을 얹히자.
 3. Thread 구현하자.

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
		
		//add(gamePanel)한 후,패널에 프로그래밍 적으로 포커스 올리기!
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
