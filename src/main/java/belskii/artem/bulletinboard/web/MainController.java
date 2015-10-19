package belskii.artem.bulletinboard.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import belskii.artem.bulletinboard.dao.advert.AdvertisementDao;
import belskii.artem.bulletinboard.dao.advert.AdvertisementDaoHiberImpl;
import belskii.artem.bulletinboard.dao.category.CategoryDao;
import belskii.artem.bulletinboard.dao.category.CategoryDaoHiberImpl;
import belskii.artem.bulletinboard.dao.user.UserDao;
import belskii.artem.bulletinboard.dao.user.UserDaoImplHiber;

@Controller
public class MainController {
	private UserDao user = new UserDaoImplHiber();
	private AdvertisementDao advertisement = new AdvertisementDaoHiberImpl();
	private CategoryDao category = new CategoryDaoHiberImpl();
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(path="/userHome", method=RequestMethod.POST)
	public ModelAndView authorize(@ModelAttribute("email") String email, HttpServletResponse response){
		response.addCookie(new Cookie("email", email));
		String userZone="userHome";
		if(!user.checkUser(email)){
			userZone="newUser";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userHome");
		modelAndView.addObject("firstName", user.getFirstName(email));
		modelAndView.addObject("lastName", user.getLastName(email));
		modelAndView.addObject("myAdvertisement", advertisement.getFiltered(email));
		return modelAndView;
	}

	
	@RequestMapping(path="/userHome", method=RequestMethod.GET)
	public ModelAndView userHome(HttpServletRequest request){
		String email=this.getEmail(request);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userHome");
		modelAndView.addObject("firstName", user.getFirstName(email));
		modelAndView.addObject("lastName", user.getLastName(email));
		modelAndView.addObject("myAdvertisement", advertisement.getFiltered(email));
		return modelAndView;
	}

	@RequestMapping(path="/createNew", method=RequestMethod.GET)
	public ModelAndView prepareNew(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createNew");
		modelAndView.addObject("categoryList", category.getAllCategories());
		return modelAndView;		
	}

	@RequestMapping(path="/createNew", method=RequestMethod.POST)
	public String createNew(HttpServletRequest request, @ModelAttribute("categoryId") String categoryId, 
			@ModelAttribute("title") String title, @ModelAttribute("body") String body){
		advertisement.addAdvertisement(user.findUser(this.getEmail(request)).getId(), title, body, Long.valueOf(categoryId));
		return "index";		
	
	}
	private String getEmail(HttpServletRequest request){
		String email="";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	        for (int i = 0; i < cookies.length; i++) {
	        	if (cookies[i].getName().equals("email")){
	        		email=cookies[i].getValue().toString();
	        	}
	        }
	    }
		return email;
	}
}
