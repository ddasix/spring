package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

// 2. DAO(Data Access Object) �대옒��
@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD 관련 메소드
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUser() 기능 처리");
		Object[] args = {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
}

class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setName(rs.getString("NAME"));
		user.setRole(rs.getString("ROLE"));
		return user;
	}
	
}