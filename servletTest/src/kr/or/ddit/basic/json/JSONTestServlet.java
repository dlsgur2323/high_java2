package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JSONTestServlet.do")
public class JSONTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		//문자열
		String str = "안녕하세요. 문자열만 있는 JSON입니다.";
		
		//배열
		int[] intArr = {100, 200, 300, 400, 500};
		
		//객체
		Sample sample = new Sample(100, "홍길동");
		
		// Gson 객체 생성
		Gson gson = new Gson();
		
		List<Sample> samList = new ArrayList<>();
		samList.add(new Sample(101,"이순신"));
		samList.add(new Sample(102,"강감찬"));
		samList.add(new Sample(103,"성춘향"));
		samList.add(new Sample(104,"변학도"));
		
		// JSON 형태의 문자열로 변환하기
		String jsonStr = gson.toJson(str);
		String jsonArr = gson.toJson(intArr);
		String jsonObj = gson.toJson(sample);
		String jsonList = gson.toJson(samList);
		
		PrintWriter out = response.getWriter();
//		out.write(jsonStr);
//		out.write(jsonArr);
//		out.write(jsonObj);
		out.write(jsonList);
		out.flush();
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
