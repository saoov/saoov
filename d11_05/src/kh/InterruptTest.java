package kh;

import javax.swing.JOptionPane;

public class InterruptTest {
	public static void main(String[] args) throws Exception {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();
		//
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // false		

		String input = JOptionPane.showInputDialog("이어서 게임을 하려면 동전을 넣거나 'Continue'라고 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");

		th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 된다.
		//
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true(상태값 반환)

	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;

		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x = 0; x < 5_500_000_000L; x++)
				; // 시간 지연
		}

		System.out.println("카운트가 종료되었습니다.");
	}
}
