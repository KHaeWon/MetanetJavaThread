import javax.swing.JOptionPane;

/*
문제가 나오고 시간이 주어짐
일정 시간이 지나면 종료

문제가 나오는 함수 하나
시간이 지나는 함수 하나
 */
public class Ex03_Single_Word_Game {

	//문제 만들기
	public static void main(String[] args) {
		
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");//웹의 프롬프트창과 동일
		System.out.println("입력값 : "+inputdata);
		timer();//싱글스레드에서는 값을 입력하지 않아도 시간을 돌 수 있도록 할 수 없음
		
	}
	
	//시간 재기
	static void timer() {
		for(int i=10; i>0; i--) {
			try {
				System.out.println("남은 시간 : "+i);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
