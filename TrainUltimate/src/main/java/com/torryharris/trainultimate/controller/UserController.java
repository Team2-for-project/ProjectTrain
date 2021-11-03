package com.torryharris.trainultimate.controller;

import com.torryharris.trainultimate.model.Train;
import com.torryharris.trainultimate.model.User;
import com.torryharris.trainultimate.repository.TrainRepo;
import com.torryharris.trainultimate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    TrainRepo trainRepo;
    @RequestMapping("Login")
    public String user(User user){

        return "LoginPage.html";
    }
    @RequestMapping("Register")
    public String addUser(User user){
        userRepo.save(user);
        return "LoginPage.html";
    }
    @RequestMapping("FindTrain")
    public Train findTrain(@RequestParam int trainNo){
        //ModelAndView mv=new ModelAndView("show_user.jsp");
        Train train=trainRepo.findById(trainNo).orElse(new Train());
        //mv.addObject(user);
        return train;

    }
}
