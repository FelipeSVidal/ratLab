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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        modelAndView.addObject("title", "Página inicial");
        modelAndView.addObject("description", "Página inicial do sistema");
        return modelAndView;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserName(Authentication authentication) {
        MyUserPrincipal myUserDetailsService = (MyUserPrincipal) authentication.getPrincipal();
        System.out.println(userTypeRepository.findById(myUserDetailsService.getUserTypeID()).get().getUserType()); // Get User Type
        return authentication.getPrincipal();
    }


    @RequestMapping(value = "/user/getbyid")
    public ModelAndView user_getbyid(@RequestParam(value = "id", defaultValue = "null") int id,
                                     @RequestParam(value = "type", defaultValue = "null") int type){
        UserEntityPK userEntityPK = new UserEntityPK();
        userEntityPK.setIdUser(id);
        userEntityPK.setUserTypeIdUserType(type);

        return user_getbyPK(userEntityPK);
    }

    @RequestMapping(value = "/user/getbyPK")
    public ModelAndView user_getbyPK(@RequestParam(value = "id", defaultValue = "null") UserEntityPK id){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/user/getbyid");
        if(id == null){

        }else {
            Optional<UserEntity> userEntity = userRepository.findById(id);
            modelAndView.addObject("user", userEntity.get());
            Optional<UserTypeEntity> userTypeEntity = userTypeRepository.findById(userEntity.get().getUserTypeIdUserType());
            modelAndView.addObject("userType", userTypeEntity.get().getUserType());

            /*
            * Get Team List if userType is Aluno
            * Get Laboratory List if userType is Administrador or Supervisor
             */
            if(id.getUserTypeIdUserType() == 3) {
                List<UserHasTeamEntity> userHasTeamEntities = userhTeamRepository.findAllByUserIdUser(id.getIdUser());
                List<TeamEntity> teamEntities = new ArrayList<>();
                for(UserHasTeamEntity  userHasTeamEntity: userHasTeamEntities){
                    teamEntities.add(teamRepository.findById( userHasTeamEntity.getTeamIdTeam() ).get());
                }
                modelAndView.addObject("teams", teamEntities);
            }else{
                List<LaboratoryEntity> laboratoryEntities = laboratoryRepository.findAllByUserIdUser(id.getIdUser());
                modelAndView.addObject("laboratories", laboratoryEntities);
            }
        }
        return modelAndView;
    }


    @RequestMapping("/user/getall")
    public ModelAndView user_getall(){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/user/listall");
        modelAndView.addObject("title", "Lista de Usuários");
        modelAndView.addObject("description", "mostra todos os usuários");
        modelAndView.addObject("users", userRepository.findAll());
        modelAndView.addObject("types", (List) userTypeRepository.findAll());

        return modelAndView;
    }

    @RequestMapping("/user/getbytype")
    public ModelAndView user_getbytype(@RequestParam(value = "type", defaultValue = "0") int type){
        ModelAndView modelAndView = new ModelAndView("/hello");
        modelAndView.addObject("List", userRepository.findAllByUserTypeIdUserType(type));

        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView user_adding(){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/user/add");
        modelAndView.addObject("title", "Adicionar Usuário");
        modelAndView.addObject("description", "Adicione um novo usuário");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
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

        System.out.println(name+"\t"+email+"\t"+password+"\t"+typeid+"\t");

                userRepository.save(user);

        UserEntity userEntity = userRepository.findByEmailUser(email);

        System.out.println("ID: "+ userEntity.getIdUser());


        UserEntityPK userEntityPK = new UserEntityPK();
        userEntityPK.setUserTypeIdUserType(typeid);
        userEntityPK.setIdUser(userEntity.getIdUser());

        return user_getbyPK(userEntityPK);
    }



}
