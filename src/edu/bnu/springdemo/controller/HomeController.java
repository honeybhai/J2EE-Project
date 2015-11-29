/**
 * @author Muhammad Haris
 * Nov 2, 2013
 */
package edu.bnu.springdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.bnu.springdemo.service.UserService;

/**
 *
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/welcome")
	public String saySalam(Model model, @RequestParam(required = false) @ModelAttribute String name,HttpServletRequest request) {
		if(name==null){
			name="";
			
		}else{
			
		}
		;
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		name="";
		System.out.println("printing from sessions"+ (String) session.getAttribute("name"));
		model.addAttribute("name", name);
		return "Home";
	}
}
