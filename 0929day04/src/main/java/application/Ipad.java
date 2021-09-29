package application;

public class Ipad implements Pad{
	
	private Application app;
	
	public Ipad() {
		System.out.println("아이패드 기본생성자 호출!");
	}
	public Ipad(Application app) {
		this.app=app;
		//System.out.println("아이패드 생성자 호출!");
	}
	@Override
	public void on() {
		System.out.println("아이패드 잠금해제!");
	}

	@Override
	public void use() {
		app.run(); // 어플 실행
		app.func(); // 어플 기능
		app.close(); // 어플 종료
	}

	@Override
	public void off() {
		System.out.println("아이패드 종료!");
	}

}
