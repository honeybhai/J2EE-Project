/**
 * @author Muhammad Haris
 * Nov 14, 2013
 */
package edu.bnu.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.springdemo.dao.GenericDAO;
import edu.bnu.springdemo.entity.User;
import edu.bnu.springdemo.mapper.UserRowMapper;

/**
 *
 */
@Service
public class UserService {

	@Autowired
	private GenericDAO genericDAO;

	/* To insert a single user */
	public boolean addUser(User user) throws Exception {
		String sql = "INSERT INTO User (first_name, last_name, gender, city) VALUES (:firstName,:lastName,:gender,:city)";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}

	/* To update a single user */
	public boolean updateUser(User user) throws Exception {
		String sql = "UPDATE User SET first_name = :firstName, last_name = :lastName, gender = :gender, city = :city WHERE user_id = :userId";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}

	/* To insert or update list of records */
	public void addUsers(List<User> users) throws Exception {
		String sql = "INSERT INTO User (first_name, last_name, gender, city) VALUES (:firstName,:lastName,:gender,:city)";
		genericDAO.insertOrUpdateAll(sql, users);
	}

	/* To find a single record against given value */
	public User findUserById(Long userId) throws Exception {
		String sql = "SELECT * FROM User WHERE user_id = ?";
		return (User) genericDAO.findById(sql, User.class, userId);
	}

	public List<User> getAllUsers() throws Exception {
		String sql = "SELECT * FROM User ORDER BY first_name";
		return (List<User>) genericDAO.findAll(sql, User.class);
	}	

	public List<User> getUsersAlongWithTypes() throws Exception {
		String sql = "SELECT * FROM User u JOIN User_Type t ON u.type_id = t.type_id";
		return (List<User>) genericDAO.findByQuery(sql, new UserRowMapper());
	}
}
