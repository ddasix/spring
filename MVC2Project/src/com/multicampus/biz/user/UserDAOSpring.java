package com.multicampus.biz.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 
@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate spring;
	
	// SQL ��ɾ�
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD ���� �޼ҵ�
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring ������� getUser() ��� ó��");
		System.out.println("vo.getId()="+vo.getId()+", vo.getPassword()"+vo.getPassword());
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}
}

class UserRowMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setName(rs.getString("NAME"));
		user.setRole(rs.getString("ROLE"));
		return user;
	}	
}