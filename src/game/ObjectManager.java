/*
지금 제작중인 게임은 게임루프(심장)가 오직 1개만 존재하기 때문에
 while문 내에서 게임에 등장할
 모든 Object들의 tick, render를 호출해야할 의무가 있다.
 하지만 게임에 등장할 객체들이 너무나 여러 클래승 걸쳐서
 복잡하게 등장하기 때문에 게임 루프인 while문 내에서
 모든 객체들의 레퍼런스를 접근하기란 쉽지 않다..
 그럼 해결책은?!
 게임에 등장할 모든 객체들을 관리해주는 존재가 필요!
 
 ObjectManager를 영화감독이라고 생각하ㅏ.
 
 게임패널이 아니 ㄴ다른곳에서 생성이 되더라도 objectManagement접근여부 걱정x
 */

package game;

import java.util.ArrayList;

public class ObjectManager {
	//연예이이 감독한테 나 출연시켜주세요 한다는 것은?
	//데이터베이스 역할을 할 존재가 필요!
	//최상위 클래스인 GameObject 넣어줌! bullet이건 뭐건 다 GameObject랑 is-a 관계니까 
	ArrayList<GameObject> list = new ArrayList<GameObject>();
	
	//객체등록! 게임에 등장할 모든 객체는 생성될 때 아래에 메서드를 통해
	//데이터베이스에 등록된다.
	
	public void addObject(GameObject obj) {
		list.add(obj);
	}
}
