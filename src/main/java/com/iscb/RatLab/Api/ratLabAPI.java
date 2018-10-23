package com.iscb.RatLab.Api;

import com.iscb.RatLab.Entity.UserTypeEntity;
import com.iscb.RatLab.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String hell(){
        return "hello";
    }
    @RequestMapping("/list")
    public String hello(@RequestParam(value = "name", defaultValue = "hell") String s){
        return s;
    }


    @RequestMapping("/listall")
    public List<UserTypeEntity> all(){

        UserTypeEntity userTypeEntity = new UserTypeEntity();
        userTypeEntity.setUserType("Supervisor");


        userTypeRepository.save(userTypeEntity);
        List<UserTypeEntity> userTypeEntities =  userTypeRepository.findAllByUserType("Supervisor");

        return userTypeEntities;
    }




}
