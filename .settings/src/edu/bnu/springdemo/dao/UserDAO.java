/**
 * @author Muhammad Haris
 * Nov 2, 2013
 */
package edu.bnu.springdemo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 */
public class UserDAO {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public UserDAO() {
	}

	

}
