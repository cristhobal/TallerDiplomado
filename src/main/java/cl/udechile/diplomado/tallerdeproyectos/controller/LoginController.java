package cl.udechile.diplomado.tallerdeproyectos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.Texto;
import cl.udechile.diplomado.tallerdeproyectos.model.User;
import cl.udechile.diplomado.tallerdeproyectos.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
									@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		
		if (null != user) {
				mav = new ModelAndView("RegisterText");
				mav.addObject("username", user.getUsername());
				mav.addObject("texto", new Texto());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public ModelAndView showUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		
		User user = new User();
		List<User> users = userService.mostrarUser(user);
		
		mav = new ModelAndView("users");
		mav.addObject("profesors", users);
		mav.addObject("login", new Login());

		return mav;
	}
	
	@RequestMapping(value = "/ShowText", method = RequestMethod.POST)
	public ModelAndView showText(HttpServletRequest request, HttpServletResponse response,
									@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		Texto txt = userService.mostrarTexto(login);
		
		if (null != txt) {
				mav = new ModelAndView("showQuestions");
				mav.addObject("texto", txt);
		} else {
			mav = new ModelAndView("index");
			mav.addObject("message", "Teacher has no questions!!");
		}
		return mav;
	}

}