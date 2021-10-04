package test;

import org.springframework.stereotype.Component;

@Component("bow")
public class Bow implements Weapon{

	@Override
	public void attack() {
		System.out.println("활로 공격!");
	}

}
