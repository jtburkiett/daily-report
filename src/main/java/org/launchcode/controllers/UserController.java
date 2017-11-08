package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by JosephT on 7/27/2017.
 */

@Controller
@RequestMapping("report")
public class UserController extends EntityController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String index(Model model){

        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(HttpServletRequest request, Model model, @ModelAttribute @Valid User user,
                      Errors errors){
        model.addAttribute(user);
        HttpSession session = request.getSession();

        if (!errors.hasErrors()){
            userDao.save(user);
            setUserInSession(session, user);
            return "redirect:report/add";
        }

        return "user/register";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(){
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.findByUsername(username);

        if (user == null){
            model.addAttribute("error", "User name does not exist");
            return "user/login";
        }

        if (!user.equals(password)){
            model.addAttribute("error", "Invalid password");
            return "user/login";
        }

        setUserInSession(request.getSession(), user);

        return "redirect:";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        return "redirect:";
    }
}
