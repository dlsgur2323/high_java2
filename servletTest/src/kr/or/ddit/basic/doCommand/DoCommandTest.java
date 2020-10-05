package kr.or.ddit.basic.doCommand;

public class DoCommandTest {

	public static void main(String[] args) {
		// 램프 켜기

		Lamp lamp = new Lamp();
		ICommand lampCommand = new LampCommandImpl(lamp);
		
		DoCommand test = new DoCommand();
		test.setCommand(lampCommand);
		test.run();
		
		// 히터 켜기
		Heater heater = new Heater();
		ICommand heatCommand = new HeaterCommandImpl(heater);
		test.setCommand(heatCommand);
		test.run();
		
	}

}
