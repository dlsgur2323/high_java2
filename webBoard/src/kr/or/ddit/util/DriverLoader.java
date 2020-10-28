package kr.or.ddit.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 클래스는 JDBC드라이버를 로딩하고 DB시스템에 접속하여 Connection객체를 반환하는 역할을 수행하는 클래스이다.

public class DriverLoader extends HttpServlet{
	private ResourceBundle bundle;
	
	@Override
	public void init() throws ServletException {
		bundle = ResourceBundle.getBundle("dbinfo"); // ResourceBundle객체 생성
		try {
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩 성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
