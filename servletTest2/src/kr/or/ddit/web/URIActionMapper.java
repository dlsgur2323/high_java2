package kr.or.ddit.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

// uri_mapping.properties 파일에 설정될 uri에 맞는 Action객체를 구해와서 인스턴스를 생성해서 반환하는 역할을 수행하는 클래스
public class URIActionMapper {
	// properties의 내용을 읽어와 uri는 키값, action 객체명은 value 값으로 해서
	// 저장될 Map 객체 생성
	private static Map<String, String> actionMap = new HashMap<>();
	
	static{
		// properties파일을 읽어와 Bundle객체를 생성한다.
		ResourceBundle rb = ResourceBundle.getBundle("kr.or.ddit.web.uri_mapping");
		
		// Bundle객체의 key값 가져오기
		Enumeration<String> en = rb.getKeys();
		while(en.hasMoreElements()){
			String key = en.nextElement(); // 키값(uri)
			String value = rb.getString(key).trim(); // value값
			actionMap.put(key, value);
		}
	}
	
	// 인수값으로 주어진 uri에 맞는 Action객체를 인스턴스화 해서 반환하는 메서드
	public static IAction getAction(String uri){
		IAction action = null;
		
		if(actionMap.containsKey(uri)){
			try {
				// 문자열로된 Action객체의 이름을 이용해서 해당 클래스를 메모리에 로딩한다.
				Class cls = Class.forName(actionMap.get(uri));
				
				// 메모리에 로딩된 Action클래스를 인스턴스화 한다. ==> 즉 객체생성
				action = (IAction)cls.newInstance();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		return action;
	}
}
