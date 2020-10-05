package kr.or.ddit.basic.doCommand;

public class HeaterCommandImpl implements ICommand{
	private Heater heater;
	
	public HeaterCommandImpl(Heater heater) {
		this.heater = heater;
	}
	@Override
	public void execute() {
		heater.powerOn();
	}
}
