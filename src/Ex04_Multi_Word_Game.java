import javax.swing.JOptionPane;

/*
2개의 함수가 동시에 실행이 안 됐던 Ex03 게임 예제를 동시에 할 수 있도록 바꿔보자
동시에 실행을 하려면 stack이 여러 개 필요 >> multi thread

	문제 함수와 시간 함수가 별도로, 동시에 동작해야 한다.(경합)
	>> cpu
 */

//시간 재기
class WordTime extends Thread{
	@Override //일반 클래스라서 강제 오버라이딩 불가 직접 쓰셈 ㅋㅋ
	public void run() {
		
		for(int i=10; i>0; i--) {
			
			//Ex04_Multi_Word_Game.inputcheck가 true면 타이머 종료
			if(Ex04_Multi_Word_Game.inputcheck) return; //thread 종료
			try {
				System.out.println("남은 시간 : "+i);
				Thread.sleep(1000); //휴게실에서 1초 쉬었다가 다시 와, 경합(점유) >> runnable
				//thread가 가지고 있는 함수 sleep()
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

//단어 입력받기
class WordInputThread extends Thread{
	@Override
	public void run() {
		String dan = "2";
		String inputdata = JOptionPane.showInputDialog(dan+"단 값을 입력하세요");
		
		//1개의 단어라도 입력하면 타이머 멈춤
		if(inputdata != null && !inputdata.equals("")) {
			Ex04_Multi_Word_Game.inputcheck = true;
		}
		
		System.out.println("입력값 : "+inputdata);
	}
}

public class Ex04_Multi_Word_Game {

	static boolean inputcheck = false;
	
	public static void main(String[] args) {
		
		

		WordTime wordtime = new WordTime();
		wordtime.start();
		
		WordInputThread wordinput = new WordInputThread();
		wordinput.start();
		
		System.out.println("main END");
		
	}

}
