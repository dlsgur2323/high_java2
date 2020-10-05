package kr.or.ddit.basic.nonCommand;

public class NonCommandTest {

	public static void main(String[] args) {
		// 램프 켜기 기능 수행하기
		Lamp lamp = new Lamp();
		NonCommand nc = new NonCommand(lamp);
		
		nc.run();

	}

}
