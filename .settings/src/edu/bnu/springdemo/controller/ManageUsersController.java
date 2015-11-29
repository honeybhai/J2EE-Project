/**
 * @author Muhammad Haris
 * Nov 15, 2013
 */
package edu.bnu.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.bnu.springdemo.entity.User;
import edu.bnu.springdemo.service.UserService;

/**
 *
 */
@Controller
public class ManageUsersController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/manageUsers")
	public String manageUsers(Model model, @RequestParam(required = false) Long userId) {
		List<User> usersList = new ArrayList<>();
		User user = new User();
		try {
			usersList = userService.getAllUsers();

			if (userId != null)
				user = userService.findUserById(userId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* set data in model to make it available on page */
		model.addAttribute("usersList", usersList);
		model.addAttribute("user", user);
		return "ManageUsers";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		try {
			if (user.getUserId() == null) {
				userService.addUser(user);
			} else {
				userService.updateUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/manageUsers.bnu";
	}
	@RequestMapping(value = "/viewAllUsers")
	public String viewAllUsers(Model model) {
		List<User> usersList = new ArrayList<>();
		
		try {
			usersList = userService.getAllUsers();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* set data in model to make it available on page */
		model.addAttribute("usersList", usersList);
		
		return "ViewAllUsers";
	}
}
