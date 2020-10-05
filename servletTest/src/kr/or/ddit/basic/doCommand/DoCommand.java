package kr.or.ddit.basic.doCommand;
// 호출자 역할의 클래스
public class DoCommand {
	private ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	public void run(){
		command.execute();
	}
}
