package test;

public class IPhone implements Phone{
	
	public IPhone() {
		System.out.println("아이폰 기본생성자 호출됨!");
	}
	public void power() {
		System.out.println("아이폰 전원!");
	}

	@Override
	public void soundUp() {
		System.out.println("아이폰 소리업!");
	}

	@Override
	public void soundDown() {
		System.out.println("아이폰 소리다운!");
	}

}
