package belskii.artem.bulletinboard.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public void authorize(@ModelAttribute("email") String email, HttpServletResponse response){
		response.addCookie(new Cookie("email", email));
	}


	@RequestMapping(path="/userHome", method=RequestMethod.GET)
	public ModelAndView userHome(HttpServletRequest request){
		String email="";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	        for (int i = 0; i < cookies.length; i++) {
	        	if (cookies[i].getName().equals("email")){
	        		email=cookies[i].getValue().toString();
	        	}
	        }
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userHome");
		
		
		return modelAndView;
	}
}
