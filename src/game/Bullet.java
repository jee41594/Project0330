/*
그럼이제 적군 충돌검사는ㅇ ㅓ떻게?
전산에서 모두 네모로 표현 Class Rectangle 있다.
반환형은 boolean! intersects(Rectangle r) !

총ㅇ알이 적군 접근하게 만들어보자
Rectangle(int x, int y, int width, int height)
1. 우선 Bullet에서 사각형을 존재시키자 -> GameObject에!

 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
							/* is - a 관계 */

	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		velX=4;
	}
	
	public void tick() {
		x+=velX;
		rect.setBounds(x, y, width, height);
		
		//적군과 내가 교차하면 둘다 죽기!!
		//내가 적군을 검사하는것이므로
		//but 적군 에너미 bullet인지 어떻게 구분..?????
		//for문을 돌려도 이게 bullet인지 어케알까요?
		for(int i=0; i<objectManager.list.size(); i++) {
			GameObject obj = objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy) {
				if(obj.rect.intersects(this.rect)) { //너의 사각형이랑 나의사각형이 충돌하면?
					//너 죽고, 나 죽자
					objectManager.list.remove(obj); //여기서 너는 obj!
					objectManager.list.remove(this); //나죽자
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		Graphics2D g2 = (Graphics2D)g;
		g2.fillOval(x,y,width,height);
	}
}
