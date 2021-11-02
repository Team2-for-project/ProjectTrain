package com.torryharris.trainultimate.controller;

import com.torryharris.trainultimate.model.User;
import com.torryharris.trainultimate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserRepo repo;
    @RequestMapping("index")
    public String user(){
        return "index.jsp";
    }
    @RequestMapping("addUser")
    public String addUser(User user){
        repo.save(user);
        return "index.jsp";
    }
    @RequestMapping("showUserId")
    public ModelAndView showuser(@RequestParam int id){
        ModelAndView mv=new ModelAndView("show_user.jsp");
        User user=repo.findById(id).orElse(new User());
        mv.addObject(user);
        return mv;

    }
}
