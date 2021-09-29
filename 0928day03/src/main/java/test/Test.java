package test;

public class Test {
	int a;
	public Test() {
		System.out.println("기본 생성자 호출됨!");
	}
	public void print() {
		System.out.println("출력");
	}
	public void initFunc() {
		System.out.println("멤버변수를 초기화하는 코드 작성!");
		a=100;
	}
}