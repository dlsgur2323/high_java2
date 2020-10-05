package kr.or.ddit.basic.doCommand;

public class LampCommandImpl implements ICommand {
	private Lamp lamp;
	
	
	public LampCommandImpl(Lamp lamp) {
		this.lamp = lamp;
	}


	@Override
	public void execute() {
		lamp.turnOn();

	}

}
