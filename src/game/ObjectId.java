/*
 자바에서 지원되는 객체 중 상수만을 모아놓은 집합을 가리켜
 enum 객체라 한다.
 enum 객체는 상수를 모아놓기 때문에 이 상수값들 사이에
 index가 존재하며 배열처럼 사용할 수도 있다.
 */

package game;

public enum ObjectId {
	//안에 자체가 상수이다. 객체이름적고 ObjectId. 으로 접근!
	Player, Enemy, Block, Bullet, Item
}
