/*
���� �������� ������ ���ӷ���(����)�� ���� 1���� �����ϱ� ������
 while�� ������ ���ӿ� ������
 ��� Object���� tick, render�� ȣ���ؾ��� �ǹ��� �ִ�.
 ������ ���ӿ� ������ ��ü���� �ʹ��� ���� Ŭ���� ���ļ�
 �����ϰ� �����ϱ� ������ ���� ������ while�� ������
 ��� ��ü���� ���۷����� �����ϱ�� ���� �ʴ�..
 �׷� �ذ�å��?!
 ���ӿ� ������ ��� ��ü���� �������ִ� ���簡 �ʿ�!
 
 ObjectManager�� ��ȭ�����̶�� �����Ϥ�.
 
 �����г��� �ƴ� ���ٸ������� ������ �Ǵ��� objectManagement���ٿ��� ����x
 */

package game;

import java.util.ArrayList;

public class ObjectManager {
	//�������� �������� �� �⿬�����ּ��� �Ѵٴ� ����?
	//�����ͺ��̽� ������ �� ���簡 �ʿ�!
	//�ֻ��� Ŭ������ GameObject �־���! bullet�̰� ���� �� GameObject�� is-a ����ϱ� 
	ArrayList<GameObject> list = new ArrayList<GameObject>();
	
	//��ü���! ���ӿ� ������ ��� ��ü�� ������ �� �Ʒ��� �޼��带 ����
	//�����ͺ��̽��� ��ϵȴ�.
	
	public void addObject(GameObject obj) {
		list.add(obj);
	}
}
