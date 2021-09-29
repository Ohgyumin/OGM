package application;

public class MessengerApp implements Application{
	
	/*public MessengerApp() {
		System.out.println("메신저 어플 생성자 호출!");
	}*/
	@Override
	public void run() {
		System.out.println("카X오톡 실행");
	}

	@Override
	public void func() {
		System.out.println("연락이..없습니다");
	}

	@Override
	public void close() {
		System.out.println("카x오톡 종료");
	}

}
