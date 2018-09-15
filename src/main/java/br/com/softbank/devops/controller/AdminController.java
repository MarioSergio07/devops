package br.com.softbank.devops.controller;

import br.com.softbank.devops.model.Usuario;
import br.com.softbank.devops.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("usuario", user);
        modelAndView.addObject("adminMessage");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
