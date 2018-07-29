package br.com.softbank.academy.controller;

import javax.validation.Valid;

import br.com.softbank.academy.model.User;
import br.com.softbank.academy.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.softbank.academy.service.IUserService;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IEmailService emailService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		User userExists = userService.findUserByEmail(user.getEmail());

		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		if (userExists != null) {
			modelAndView.addObject("messageCreated", "error");
			return modelAndView;
		}
		 else {
			userService.saveUser(user);
			modelAndView.addObject("messageCreated", "success");
			modelAndView.addObject("user", new User());
				try{
					emailService.sendEmailWelcome(user);
				} catch (Exception ex){
					ex.printStackTrace();
				}
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("user", user);
		modelAndView.addObject("adminMessage");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
