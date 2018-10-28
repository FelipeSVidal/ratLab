package com.iscb.RatLab.Api;

import com.iscb.RatLab.Entity.*;
import com.iscb.RatLab.Repository.*;
import com.iscb.RatLab.Security.MyUserDetailsService;
import com.iscb.RatLab.Security.MyUserPrincipal;
import com.iscb.RatLab.Security.PasswordEncoder;
import com.iscb.RatLab.Security.PasswordEncoderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class ratLabAPI {

    @Autowired
    UserTypeRepository userTypeRepository;
    @Autowired
    BoxRepository boxRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    RatRepository ratRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    UserhTeamRepository userhTeamRepository;
    @Autowired
    UserRepository userRepository;


    @RequestMapping("/")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("/hello");
        return modelAndView;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserName(Authentication authentication) {
        MyUserPrincipal myUserDetailsService = (MyUserPrincipal) authentication.getPrincipal();
        System.out.println(userTypeRepository.findById(myUserDetailsService.getUserTypeID()).get().getUserType()); // Get User Type
        return authentication.getPrincipal();
    }

    @RequestMapping("/user/getbyid")
    public ModelAndView user_getbyid(@RequestParam(value = "id", defaultValue = "0") int id){
        ModelAndView modelAndView = new ModelAndView("/hello");
        modelAndView.addObject("list", userRepository.findById(id));

        return modelAndView;
    }


    @RequestMapping("/user/getall")
    public ModelAndView user_getall(){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("list", userRepository.findAll());

        return modelAndView;
    }

    @RequestMapping("/user/getbytype")
    public ModelAndView user_getbytype(@RequestParam(value = "type", defaultValue = "0") int type){
        ModelAndView modelAndView = new ModelAndView("/hello");
        modelAndView.addObject("List", userRepository.findAllByUserTypeIdUserType(type));

        return modelAndView;
    }

    @RequestMapping("/user/add")
    public ModelAndView user_add(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "typeid", defaultValue = "") int typeid
    ){
        UserEntity user = new UserEntity();
        user.setNameUser(name);
        user.setEmailUser(email);
        PasswordEncoder PEC = new PasswordEncoderConfig().customPasswordEncoder();
        user.setPasswordUser(PEC.encode(password));
        user.setUserTypeIdUserType(typeid);

        userRepository.save(user);

        ModelAndView modelAndView = new ModelAndView("/hello");

        return modelAndView;
    }



}
