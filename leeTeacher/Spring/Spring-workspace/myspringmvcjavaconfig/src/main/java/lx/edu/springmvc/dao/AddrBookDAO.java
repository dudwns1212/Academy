package lx.edu.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.vo.AddrBookVO;

@Component
public class AddrBookDAO {

	@Autowired
	SqlSession session;
	
	public int insertDB(AddrBookVO ab) throws Exception {
		return session.insert("insertDB", ab);
	}

	public List<AddrBookVO> getDBList() throws Exception {	
		return session.selectList("getDBList");
	}

	public AddrBookVO getDB(int abId) throws Exception {
		return session.selectOne("getDB", abId);
	}
	public int updateDB(AddrBookVO ab) throws Exception {
		return session.update("updateDB", ab);
	}
	public int deleteDB(int abId) throws Exception {
		return session.delete("deleteDB", abId);	
	}
}
