/**
 * @author Muhammad Haris
 * Nov 5, 2013
 */
package edu.bnu.springdemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.springdemo.entity.User;
import edu.bnu.springdemo.entity.UserType;

/**
 *
 */
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getLong("user_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName("last_name");
		user.setCity(rs.getString("city"));
		user.setGender(rs.getString("gender"));

		/* if user table was joined with user_type table */
		if (rs.getString("type_name") != null) {
			UserType userType = new UserType();
			userType.setTypeId(rs.getInt("type_id"));
			userType.setTypeName(rs.getString("type_name"));
			user.setUserType(userType);
		}

		return user;
	}

}
