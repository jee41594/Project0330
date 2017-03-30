/*
 ��� ������ �� �г� �ȿ��� �׷��� �����̴�.
 �ƹ��� ������ ����� �پ��ϴ��� �г��� ���� 1���� ���ȴ�.
 
 ��� Object�� �ᱹ �� �гο� �׷����� �ϹǷ� �� �г��� paint�޼����� �μ���
 ���޵Ǵ� Graphics ��ü�� ���ӿ� ������ ��� Object�� �����ؾ� �Ѵ�.
 
 Panel �� keyboard �����ؾ� �Ѵ�.
 */

package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	// ũ�⸦ ������ �����غ���. -> ����� �Ẹ��/ ��� = ������ ���, �ν��Ͻ����� �� ����, ������x
	// ����� �־���? �������� ����!
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;
	boolean flag=true; //���� �������θ� �����ϴ� ����!
	Thread thread; //���� � ������1!
	Player player;
	ObjectManager objectManager; //��ü ��ܰ�����

	public GamePanel() {
		
		thread = new Thread(this);
		thread.start();
		
		init();
		// ũ������
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}

	public void init(){
		//��ܰ����� ����, player���� ���� �¾�� ����ؾ���
		objectManager = new ObjectManager();
		
		//���ΰ� �����Ű��
		player = new Player(objectManager, ObjectId.Player, 100, 200, 50, 50);
		
		//player�¾�°� �־�����!
		objectManager.addObject(player); //�Ѹ��߰�
		
		//��������
		Random r= new Random();
		
		for(int i=0; i<10; i++){
			int Y = r.nextInt((HEIGHT*SCALE-100)-(50)+1)+50;
			int X = r.nextInt((WIDTH*SCALE+500)-(50)+1)+50;
			Enemy enemy = new Enemy(objectManager, ObjectId.Enemy, X, Y, 30, 30);
				objectManager.addObject(enemy);
		}
		
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new KeyBoard(player));
		//�̷��� �ϸ� �ȵȴ� ���� focus�� Window�� ���ֱ� ������!! focus�� �гη� �Űܾ� �Ѵ�.
	}

	// paint�� paintComponent������ ������ ���׷��̵� �Ȱ� ���Ƽ� �ẽ
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//render ȣ��!
		for(int i =0; i<objectManager.list.size(); i++) {
			GameObject obj = objectManager.list.get(i);
			obj.render(g);
		}
	}

	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//������ �츮�� �������� ObjectManager���� ��Ű��.
			//������Ʈ �Ŵ����� ��ϵ� ���~~��ü�� ������� tick()�� ȣ��
			//�츰 �� �մ��� �𸣴ϱ� for�������� Ȯ��
			for(int i =0; i<objectManager.list.size(); i++) {
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick(); ���̻� ���ʿ�x
			//player.render(g)�� �Ұ��� ��?g�� �����Ƿ�!
			repaint(); //paintComponent�� ���� ȣ��! ���� ���� ȣ���ϴ°Ŵϱ�! 
			//���ΰ��Ӹ� �ƴ϶� �Ѿ���, ������, ������ ���� tick, render �� ȣ��..!
			//�Ѿ��� ��̰� ������ ����� �̷��͵��� �� ������ �� �ִ� db�� �ʿ�!
		}
	}
}
