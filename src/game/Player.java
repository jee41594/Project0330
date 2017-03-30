/*
 �� Ŭ������ sun���� ��ü ������ UI ������Ʈ�� �ƴϱ� ������
 ȭ�鿡 �׷��� �� ����.
 ���� JPanel�� �׷������� JPanel�� Graphics�� ���۷����� 
 �� ��ü�� �����ؾ� �Ѵ�.
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{

	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
	}
	
	//�Ѿ� �߻� ������ �����Ѵ�. ���ļ����!!
	public void fire() {
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet); //��ϸ��ϸ� tick renderȣ��!
	}

	//x, y, width, height ������ ���� ��ȭ��
	//�����ϱ� ���� �޼��� (����� �������ڸ� ��� ��ȭ..?)
	public void tick() {
		//System.out.println("tick");
		x+=velX;
		y+=velY;
		rect.setBounds(x, y, width, height); //�簢���� ���� ����ٴϰ� ���� ����ȭ����!
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼���!!
	//�׷����� �ϹǷ� Graphics g �޾ƿ;� �մϴ�.
	public void render(Graphics g) {
		g.setColor(Color.WHITE); //����Ʈ �� �ٲ����� �����̶� ������ �ȵǴϱ�!
		//g.drawRect(x, y, width, height);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(rect);
		//�̷����ϸ� ó�� �����Ǿ����� x,y������ ���������Ƿ� x,y���� ���� ����ٳ�� �Ѵ�!
		//rect.setBounds �ʿ���!
		
		//System.out.println("render");
		
	}
}
