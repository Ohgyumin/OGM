package test;

public class Gaphone implements Phone{
	
	private Watch watch;
	private String user;
	
	public Gaphone() {
		System.out.println("갤럭시 기본생성자 호출됨!");
	}
	public Gaphone(Watch watch,String user) {
		this.watch=watch;
		this.user=user;
		System.out.println("갤럭시 생성자 호출됨!");
	}
	@Override
	public void power() {
		System.out.println("갤럭시 전원!");
	}

	@Override
	public void soundUp() {
		SmartWatch sw=new SmartWatch(); // 매번 생성시 무거워짐
		sw.soundUp();
		//System.out.println("갤럭시 소리업!");
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		//System.out.println("갤럭시 소리다운!");
	}

}
