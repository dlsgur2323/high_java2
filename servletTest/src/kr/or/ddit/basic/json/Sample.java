package kr.or.ddit.basic.json;

public class Sample {
	private int id;
	private String name;
	
	//생성자
	public Sample(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	// 기본 생성자
	public Sample() {	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
