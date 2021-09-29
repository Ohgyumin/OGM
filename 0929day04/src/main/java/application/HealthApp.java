package application;

public class HealthApp implements Application{
	
	/*public HealthApp() {
		System.out.println("헬스 어플 생성자 호출!");
	}*/
	@Override
	public void run() {
		System.out.println("오늘의 운동 시작!");
	}

	@Override
	public void func() {
		System.out.println("푸쉬업 100개");
		System.out.println("스쿼트 100개");
		System.out.println("싯업 100개");
		System.out.println("런닝 10km");
	}

	@Override
	public void close() {
		System.out.println("내일도 만나요!");
	}

}
