package kr.or.ddit.board.dao;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.util.BuildSqlMapClient;

public class BoardDaoImpl implements IBoardDao{
	
	private static BoardDaoImpl boardDao;
	private SqlMapClient smc;
	
	private BoardDaoImpl(){
		try {
			smc = BuildSqlMapClient.getSqlMapClient();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static BoardDaoImpl getInstance(){
		if(boardDao==null) boardDao = new BoardDaoImpl();
		return boardDao;
	}
	
	
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("jdbc_board.insertBoard", boardVo);
			if(obj==null) cnt=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			cnt = smc.delete("jdbc_board.deleteBoard", boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		int cnt = 0;
		try {
			cnt = smc.update("jdbc_board.updateBoard", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		List<BoardVo> boardList = null;
		try {
			boardList = smc.queryForList("jdbc_board.getAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}
	
	@Override
	public List<BoardVo> getAllTitle(String title) {
		List<BoardVo> boardList = null;
		title = "%"+title+"%";
		try {
			boardList = smc.queryForList("jdbc_board.getAllTitle", title);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public BoardVo getOneBoard(int boardNo) {
		BoardVo boardVo = null;
		try {
			boardVo = (BoardVo)smc.queryForObject("jdbc_board.getOneBoard",boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return boardVo;
	}

	@Override
	public int getBoardCount(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCnt(int boardNo) {
		try {
			int cnt = smc.update("jdbc_board.updateCnt", boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static String clobToString(Clob clob) throws Exception {
		StringBuffer s = new StringBuffer();
		BufferedReader br = new BufferedReader(clob.getCharacterStream());
		String ts = "";
		while((ts = br.readLine()) != null) {
			s.append(ts + "\n");
		}
		br.close();
		return s.toString();
	}


}
