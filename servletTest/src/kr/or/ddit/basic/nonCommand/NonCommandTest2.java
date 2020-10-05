package kr.or.ddit.basic.nonCommand;

public class NonCommandTest2 {

	public static void main(String[] args) {
		Heater heater = new Heater();
		Lamp lamp = new Lamp();
		
		NonCommand2 nc2 = new NonCommand2(lamp, heater);
		// 램프 켜기
		nc2.setMode("LAMP");
		nc2.run();
		nc2.setMode("HEATER");
		nc2.run();

	}

}
