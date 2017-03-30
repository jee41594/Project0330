/*
 모든 게임은 이 패널 안에서 그려질 예정이다.
 아무리 게임의 장면이 다양하더라도 패널은 오직 1개만 사용된다.
 
 모든 Object는 결국 이 패널에 그려져야 하므로 이 패널의 paint메서드의 인수로
 전달되는 Graphics 객체를 게임에 등장할 모든 Object가 공유해야 한다.
 
 Panel 에 keyboard 연결해야 한다.
 */

package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	// 크기를 변수로 제어해보자. -> 상수로 써보자/ 상수 = 접근이 허용, 인스턴스들이 값 접근, 변하지x
	// 상수를 왜쓰나? 직관성을 위해!
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;
	boolean flag=true; //게임 가동여부를 결정하는 변수!
	Thread thread; //게임 운영 쓰레드1!
	Player player;
	ObjectManager objectManager; //객체 명단관리자

	public GamePanel() {
		
		thread = new Thread(this);
		thread.start();
		
		init();
		// 크기지정
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}

	public void init(){
		//명단관리자 생성, player보다 먼저 태어나서 등록해야함
		objectManager = new ObjectManager();
		
		//주인공 등장시키기
		player = new Player(objectManager, ObjectId.Player, 100, 200, 50, 50);
		
		//player태어나는거 넣어주자!
		objectManager.addObject(player); //한명추가
		
		//적군등장
		Random r= new Random();
		
		for(int i=0; i<10; i++){
			int Y = r.nextInt((HEIGHT*SCALE-100)-(50)+1)+50;
			int X = r.nextInt((WIDTH*SCALE+500)-(50)+1)+50;
			Enemy enemy = new Enemy(objectManager, ObjectId.Enemy, X, Y, 30, 30);
				objectManager.addObject(enemy);
		}
		
		//패널과 키보드 리스터 연결
		this.addKeyListener(new KeyBoard(player));
		//이렇게 하면 안된다 현재 focus가 Window에 가있기 때문에!! focus를 패널로 옮겨야 한다.
	}

	// paint랑 paintComponent목적은 갖지만 업그레이드 된거 같아서 써봄
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//render 호출!
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
			//일일이 우리가 하지말고 ObjectManager한테 시키자.
			//오브젝트 매니저에 등록된 모든~~객체를 대상으로 tick()을 호출
			//우린 얼마 잇는지 모르니까 for문돌려서 확인
			for(int i =0; i<objectManager.list.size(); i++) {
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick(); 더이상 할필요x
			//player.render(g)는 불가능 왜?g가 없으므로!
			repaint(); //paintComponent를 간접 호출! 내가 내꺼 호출하는거니까! 
			//주인공뿐만 아니라 총알의, 적군의, 아이템 등의 tick, render 다 호출..!
			//총알이 몇개이고 적군이 몇개인지 이런것들을 총 망라할 수 있는 db가 필요!
		}
	}
}
