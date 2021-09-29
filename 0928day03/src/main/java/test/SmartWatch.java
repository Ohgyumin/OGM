package test;

public class SmartWatch implements Watch{
	
	public SmartWatch() {
		System.out.println("스마트워치 기본 생성자 호출!");
	}
	
	@Override
	public void soundUp() {
		System.out.println("스마트워치 사운드업!");
	}

	@Override
	public void soundDown() {
		System.out.println("스마트워치 사운드다운!");
	}

}
