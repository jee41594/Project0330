/*
 이 클래스는 sun에서 자체 제작한 UI 컴포넌트가 아니기 때문에
 화면에 그려질 수 없다.
 따라서 JPanel에 그려지려면 JPanel의 Graphics의 레퍼런스를 
 이 객체가 보유해야 한다.
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{

	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
	}
	
	//총알 발사 행위를 정의한다. ㅁㅔ서드로!!
	public void fire() {
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet); //등록만하면 tick render호출!
	}

	//x, y, width, height 물리량 등의 별화를
	//제어하기 위한 메서드 (사람과 비유하자면 운동량 변화..?)
	public void tick() {
		//System.out.println("tick");
		x+=velX;
		y+=velY;
		rect.setBounds(x, y, width, height); //사각형이 나를 따라다니게 값을 동기화하자!
	}
	
	//변화된 값을 화면에 그려지게 할 메서드!!
	//그려져야 하므로 Graphics g 받아와야 합니다.
	public void render(Graphics g) {
		g.setColor(Color.WHITE); //페이트 색 바꺼야함 배경색이랑 같으면 안되니까!
		//g.drawRect(x, y, width, height);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(rect);
		//이렇게하면 처음 생성되었을때 x,y값에서 멈춰있으므로 x,y값이 나를 따라다녀야 한다!
		//rect.setBounds 필요함!
		
		//System.out.println("render");
		
	}
}
