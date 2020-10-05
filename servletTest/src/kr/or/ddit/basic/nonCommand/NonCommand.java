package kr.or.ddit.basic.nonCommand;

// 호출자 역할의 클래스
public class NonCommand {
	
	// 램프 켜기
	private Lamp lamp;
	
	public NonCommand(Lamp lamp) {
		this.lamp = lamp;
	}
	
	public void run(){
		lamp.turnOn();
	}
	
	// 처음에는 램프를 켜는 기능을 수행하다가 이번에는 히터를 키는 기능을 수행하려고 한다.
}
