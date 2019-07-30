package com.sidhlogin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sidhlogin.model.Login;
import com.sidhlogin.model.User;

public class UserDaoImpl implements UserDao {
	
	  DataSource datasource;
	  
  
    public User validateUser(Login login) {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");  
    	JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");  
    	String sql = "select * from users where username='" + login.getUsername() + "' and password='"+ login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));
    return user;
  }
  
  
}
  public int insertUser(User usr)
  {
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");  
	  JdbcTemplate jdbcTemplate1=(JdbcTemplate)ctx.getBean("jdbcTemplate"); 
	  System.out.println(usr + "xxx");
	  String uname=usr.getUsername();
	  String pass=usr.getPassword();
	  String fname=usr.getFirstname();
	  String lname=usr.getLastname();
	  String email=usr.getEmail();
	  String addrs=usr.getAddress();
	  int ph=usr.getPhone();
	  String sql = "insert into users (username,password,firstname,lastname,email,address,phone) values (?,?,?,?,?,?,?)"; 
	  return jdbcTemplate1.update(sql,uname,pass,fname,lname,email,addrs,ph);
  }

}
