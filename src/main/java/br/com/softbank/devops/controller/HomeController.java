package br.com.softbank.devops.controller;

import javax.validation.Valid;

import br.com.softbank.devops.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.softbank.devops.service.IUserService;

@Controller
public class HomeController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Usuario user = new Usuario();
		modelAndView.addObject("usuario", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		Usuario userByEmail = userService.findUserByEmail(user.getEmail());
		Usuario userByCpf = userService.findUserByCpf(user.getCpf());

		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		if (userByEmail != null) {
			modelAndView.addObject("messageCreated", "errorEmail");
			return modelAndView;
		} else if (userByCpf != null) {
			modelAndView.addObject("messageCreated", "errorCpf");
			return modelAndView;
		}
		 else {
			userService.saveUser(user);
			modelAndView.addObject("messageCreated", "success");
			modelAndView.addObject("usuario", new Usuario());
		}
		return modelAndView;
	}

	@RequestMapping(value="/aboutUs", method = RequestMethod.GET)
	public ModelAndView aboutUs(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("aboutUs");
		return modelAndView;
	}

}
