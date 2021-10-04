package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction{
	// 추상메서드 abstract 
	// 1. 자식으로 강제성 넘김
	// 2. Champ로 만들수없음
	private String name;
	private	List<String> inven;
	//@Autowired // 컨테이너는 자신이 만들어두었던 객체들의 "타입"을 확인!
	@Autowired
	private Weapon weapon;
	
	@Override
	public void attack() {
		weapon.attack();
		// 널포인트익센셥(예외) 발생우려가 있으니, new했어야했다!
		// -> 멤버변수로 처리, 생성자 주입
		// -> setter 주입으로 변경(기본 생성자가 필요!)
	}
	
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) {
			System.out.println(v);
		}
	}
	
	
}
