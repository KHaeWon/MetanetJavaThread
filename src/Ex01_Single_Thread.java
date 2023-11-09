//단일 스레드 -> 스택 1개만 쓰는 것
public class Ex01_Single_Thread {

	public static void main(String[] args) {
		
		System.out.println("일꾼1");//1번, main
		
		worker();
		worker2();
	}
	
	static void worker() {
		System.out.println("일꾼2");//worker() 올리고 출력
	}
	static void worker2() {
		System.out.println("일꾼3");//worker2() 올리고 출력
	}
}
