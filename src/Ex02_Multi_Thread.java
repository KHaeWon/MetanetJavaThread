/*
Thread -> 프로세스 하나의 최소 실행 단위(흐름) >> method >> 실행되는 공간 stack

Thread 생성 방법
1. Thread 클래스 상속 >> Task_1 extends Thread >> run함수 구현
2. Runnable 인터페이스 구현
	 Runnable 인터페이스 -> 스레드 아님. 사용 시 Thread thread = new Thread(new Task())
	 
다중상속이 안 되므로 이렇게 만듦
 */

class Task_1 extends Thread{
	@Override
	public void run() { 
		//run() -> Thread가 가지고 있는 함수
		// 		-> Thread main 함수 역할 >> 새로운 stack이 만들어지면 처음 올라가서 실행되는 함수
		for(int i=0; i<1000; i++) {
			System.out.println("Task_1" + i + this.getName()); //Thread에 내부적으로 생성되어 있음
		}
		System.out.println("Task_1 run() END");
		
	}
}

class Task_2 implements Runnable{//Thread가 아니라 run()만 가지고 있는 클래스

	@Override
	public void run() {

		for(int i=0; i<1000; i++) {
			System.out.println("Task_2" + i);//Thread가 아니므로 this.getName() 사용 불가
		}
		System.out.println("Task_2 run() END");
	}
	
}

public class Ex02_Multi_Thread {

	public static void main(String[] args) {
		//main Thread
		
		Task_1 th = new Task_1(); //Thread 객체 생성
		th.start(); //POINT 새로운 stack을 생성하고 run() 올리고 역할 끝
		
		//★start()함수는 메모리를 만드는 역할
		//start()는 메인 함수 메모리에 만들어짐
		//스택 하나 더 만들고 스택에 run()까지 올려주는 것이 역할
		
		Thread th2 = new Thread(new Task_2());
		th2.start();
		
		//지금까지 스택 총 3개
		
		for(int i=0; i<1000; i++) {
			System.out.println("main" + i );
		}
		System.out.println("main END");
		
		//익명 객체
		Thread th3 = new Thread(new Runnable() {//이름이 없음. 일회성
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<1000; i++) {
					System.out.println("Task_3" + i); 
				}
				System.out.println("Task_3 run() END");
			}
		});
		th3.start();
		
	}

}
