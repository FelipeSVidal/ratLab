package com.iscb.RatLab.Api;

import com.iscb.RatLab.Entity.*;
import com.iscb.RatLab.Repository.*;
import com.iscb.RatLab.Security.MyUserDetailsService;
import com.iscb.RatLab.Security.MyUserPrincipal;
import com.iscb.RatLab.Security.PasswordEncoder;
import com.iscb.RatLab.Security.PasswordEncoderConfig;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
public class ratLabAPI {
    @Autowired
    BoxRepository boxRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModifierRepository modifierRepository;

    // --------------- SYSTEM --------------------
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("/register");
        return modelAndView;
    }
    @RequestMapping("/")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("title", "Página inicial");
        modelAndView.addObject("description", "Página inicial do sistema");
        return modelAndView;
    }


// ----------------- USER API -------------------


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserName(Authentication authentication) {
        MyUserPrincipal myUserDetailsService = (MyUserPrincipal) authentication.getPrincipal();
        return authentication.getPrincipal();
    }




    @RequestMapping(value = "/user/getbyid")
    public ModelAndView user_getbyId(@RequestParam(value = "id", defaultValue = "null") int id){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/user/getbyid");
        if(id == 0){

        }else {
            Optional<UserEntity> userEntity = userRepository.findById(id);
            UserEntity user = userEntity.get();
            modelAndView.addObject("user", user);

            String type = "";
            if(user.getTypeUser() == 3){
                type = "Reponsavel";
                modelAndView.addObject("projects", projectRepository.findAllByUserIdUser(user.getIdUser()));
            }else if(user.getTypeUser() == 2){
                type = "Supervisor";
                modelAndView.addObject("laboratories", laboratoryRepository.findAllByUserIdUser(user.getIdUser()));
            }else{
                type = "Administrador";
            }
            modelAndView.addObject("type", type);



        }
        return modelAndView;
    }


    @RequestMapping("/user/getall")
    public ModelAndView user_getall(){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/user/listall");
        modelAndView.addObject("title", "Lista de Usuários");
        modelAndView.addObject("description", "mostra todos os usuários");
        modelAndView.addObject("users", userRepository.findAll());

        return modelAndView;
    }

    @RequestMapping("/user/getbytype")
    public ModelAndView user_getbytype(@RequestParam(value = "type", defaultValue = "0") int type){
        ModelAndView modelAndView = new ModelAndView("/hello");
     //   modelAndView.addObject("List", userRepository.findAllByUserTypeIdUserType(type));

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
    public void user_add(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "login", defaultValue = "") String login,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "typeid", defaultValue = "") int typeid,
            HttpServletResponse response
    ){
        UserEntity user = new UserEntity();
        user.setNameUser(name);
        user.setLoginUser(login);
        PasswordEncoder PEC = new PasswordEncoderConfig().customPasswordEncoder();
        user.setPasswordUser(PEC.encode(password));
        user.setTypeUser(typeid);

        userRepository.save(user);

        UserEntity userEntity = userRepository.findByLoginUser(login);

        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//----------------------- Laboratory API -------------------

    @RequestMapping(value = "/lab/add", method = RequestMethod.POST)
    public ModelAndView lab_add(
        @RequestParam(value = "name") String name,
        @RequestParam(value = "initials") String initials,
        @RequestParam(value = "user") int id_user
    ){
        LaboratoryEntity laboratoryEntity = new LaboratoryEntity();
        laboratoryEntity.setNameLaboratory(name);
        laboratoryEntity.setInitialsLaboratory(initials);
        laboratoryEntity.setUserIdUser(id_user);

        laboratoryRepository.save(laboratoryEntity);



        return lab_getbyid(laboratoryRepository.findByNameLaboratory(name).getIdLaboratory());
    }

    @RequestMapping(value = "/lab/add", method = RequestMethod.GET)
    public ModelAndView lab_adding(){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/laboratory/add");
        modelAndView.addObject("title", "Adicionar Laboratório");
        modelAndView.addObject("description", "Adicione um novo laboratório");

        List<UserEntity> userEntityList = userRepository.findAllByTypeUser(2);
        modelAndView.addObject("users", userEntityList);

        return modelAndView;
    }

    @RequestMapping(value = "/lab/getbyid")
    public ModelAndView lab_getbyid(
            @RequestParam(value = "id") int id
    ){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/laboratory/getbyid");
        modelAndView.addObject("title", "Detalhes do Laboratório");
        modelAndView.addObject("description", "mostra os detalhes do laboratório");

        Optional<LaboratoryEntity> laboratoryEntity = laboratoryRepository.findById(id);
        modelAndView.addObject("laboratory", laboratoryEntity.get());
        modelAndView.addObject("user", userRepository.findById(laboratoryEntity.get().getUserIdUser()).get());
        modelAndView.addObject("projects", projectRepository.findAllByLaboratoryIdLaboratory(laboratoryEntity.get().getIdLaboratory()));

        List<UserEntity> userEntityList = userRepository.findAllByTypeUser(2);
        modelAndView.addObject("users", userEntityList);
        return modelAndView;
    }

    @RequestMapping(value = "/lab/listall")
    public ModelAndView lab_getall(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/laboratory/listall");
        modelAndView.addObject("title", "Detalhes do Laboratório");
        modelAndView.addObject("description", "mostra os detalhes do laboratório");

        UserEntity userEntity = getUserLogger(authentication);
        List<LaboratoryEntity> laboratoryEntities = new ArrayList<>();
        if(userEntity.getTypeUser() == 1) {
            laboratoryEntities = (List) laboratoryRepository.findAll();
            modelAndView.addObject("list", laboratoryEntities);
        }else{
            laboratoryEntities = (List) laboratoryRepository.findAllByUserIdUser(userEntity.getIdUser());
            modelAndView.addObject("list", laboratoryEntities);
        }
        List<UserEntity> userEntityList = new ArrayList<>();
        for(LaboratoryEntity laboratoryEntity : laboratoryEntities){
            userEntityList.add(userRepository.findById(laboratoryEntity.getUserIdUser()).get());
        }
        modelAndView.addObject("users", userEntityList);

        return modelAndView;

    }
    @RequestMapping(value = "/lab/update")
    public void lab_update(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "initials") String initials,
            @RequestParam(value = "user") int user
    ){
        LaboratoryEntity laboratoryEntity = new LaboratoryEntity();
        laboratoryEntity.setIdLaboratory(id);
        laboratoryEntity.setNameLaboratory(name);
        laboratoryEntity.setInitialsLaboratory(initials);
        laboratoryEntity.setUserIdUser(user);
        laboratoryRepository.save(laboratoryEntity);
    }

    //----------------------- Box API -------------------
    @RequestMapping(value = "/box/add", method = RequestMethod.POST)
    public BoxEntity box_add(
        @RequestParam(value = "projectId")int id_project,
        @RequestParam(value = "typeBox") String type,
        @RequestParam(value = "qtdMaleBox")Integer qtdMale,
        @RequestParam(value = "qtdFemaleBox")Integer qtdFemale
    ){
        BoxEntity box = new BoxEntity();
        box.setProjectIdProject(id_project);
        box.setTypeBox(type);
        box.setQtdMaleBox(qtdMale);
        box.setQtdFemaleBox(qtdFemale);
        boxRepository.save(box);




        return box;
    }

    @RequestMapping(value = "/box/add22", method = RequestMethod.GET)
    public ModelAndView box_adding(
            @RequestParam(value = "project", required = false) ProjectEntity projectEntity,
            Authentication authentication
    ){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/box/add");
        modelAndView.addObject("title", "Adicionar Caixa");
        modelAndView.addObject("description", "adiciona uma nova caixa");

        if(projectEntity != null){
            modelAndView.addObject("project_name", projectEntity.getNameProject());
            modelAndView.addObject("project_id", projectEntity.getIdProject());
        }else{
            UserEntity userEntity = getUserLogger(authentication);
            if(userEntity.getTypeUser() == 1){
                modelAndView.addObject("projects", projectRepository.findAll());
            }else {
                modelAndView.addObject("projects", projectRepository.findAllByUserIdUser(userEntity.getIdUser()));
            }
        }


        return modelAndView;
    }

    @RequestMapping(value = "/box/getbyid")
    public ModelAndView box_getbyid(
            @RequestParam(value = "id")int id,
            @RequestParam(value = "project_id")int id_project
    ){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/box/getbyid");
        modelAndView.addObject("title", "Detalhes da caixa");
        modelAndView.addObject("description", "mostra os detalhes da caixa");

        BoxEntityPK boxEntityPK = new BoxEntityPK();
        boxEntityPK.setIdBox(id);
        boxEntityPK.setProjectIdProject(id_project);

        Optional<BoxEntity> boxEntity = boxRepository.findById(boxEntityPK);
        modelAndView.addObject("box", boxEntity.get());
        modelAndView.addObject("sum", (boxEntity.get().getQtdMaleBox() + boxEntity.get().getQtdFemaleBox()));
        modelAndView.addObject("project", projectRepository.findByIdProject(boxEntity.get().getProjectIdProject()));


        return modelAndView;
    }

    @RequestMapping(value = "/box/delete")
    public boolean box_delete(
            @RequestParam(value = "box_id")int id_box,
            @RequestParam(value = "project_id")int id_project
    ){
        BoxEntityPK boxEntityPK = new BoxEntityPK();
        boxEntityPK.setProjectIdProject(id_project);
        boxEntityPK.setIdBox(id_box);
        try{
            BoxEntity boxEntity = boxRepository.findById(boxEntityPK).get();
            boxRepository.delete(boxEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/box/update")
    public void box_update(
            @RequestParam(value = "box_id")int id_box,
            @RequestParam(value = "project_id")int id_project,
            @RequestParam(value = "males")int qtd_male,
            @RequestParam(value = "females")int qtd_female
    ){
        BoxEntityPK boxEntityPK = new BoxEntityPK();
        boxEntityPK.setProjectIdProject(id_project);
        boxEntityPK.setIdBox(id_box);
        BoxEntity boxEntity = boxRepository.findById(boxEntityPK).get();
        boxEntity.setQtdMaleBox(qtd_male);
        boxEntity.setQtdFemaleBox(qtd_female);
        boxRepository.save(boxEntity);
    }


    //----------------------- Project API -------------------

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public ModelAndView project_add(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "n_doc") String n_doc,
            @RequestParam(value = "stats_doc") String stats_doc,
            @RequestParam(value = "laboratory_id") int laboratory_id,
            @RequestParam(value = "user_id") int user_id,
            @RequestParam(value = "local") String local,
            Authentication authentication

    ){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setNameProject(name);
        projectEntity.setnDocEthicProject(n_doc);
        projectEntity.setStatusDocProject(stats_doc);
        projectEntity.setLaboratoryIdLaboratory(laboratory_id);
        projectEntity.setUserIdUser(user_id); // Responsible
        projectEntity.setDateCreateProject(new Date(System.currentTimeMillis()));
        projectEntity.setLocalProject(local);
        projectRepository.save(projectEntity);

        return project_listall(authentication);

    }

    @RequestMapping(value = "/project/add", method = RequestMethod.GET)
    public ModelAndView project_adding(Authentication authentication){

        ModelAndView modelAndView = new ModelAndView("/layout/fragments/project/add");
        modelAndView.addObject("title", "Adicionar Projeto");
        modelAndView.addObject("description", "adiciona um novo projeto");

        UserEntity userEntity = getUserLogger(authentication);
        if(userEntity.getTypeUser() == 1){
            modelAndView.addObject("laboratories", laboratoryRepository.findAll());
        }else {
            modelAndView.addObject("laboratories", laboratoryRepository.findAllByUserIdUser(userEntity.getIdUser()));
        }
        modelAndView.addObject("users", userRepository.findAllByTypeUser(3));


        return modelAndView;

    }

    @RequestMapping(value = "/project/getbyid")
    public ModelAndView project_getbyid(
            @RequestParam(value = "project_id") int project_id,
            @RequestParam(value = "laboratory_id") int laboratory_id
    ){

        ModelAndView modelAndView = new ModelAndView("/layout/fragments/project/getbyid");
        modelAndView.addObject("title", "Detalhes do projeto");
        modelAndView.addObject("description", "mostra informações do projeto");
            ProjectEntityPK projectEntityPK = new ProjectEntityPK();
            projectEntityPK.setIdProject(project_id);
            projectEntityPK.setLaboratoryIdLaboratory(laboratory_id);
            ProjectEntity projectEntity = projectRepository.findById(projectEntityPK).get();

        modelAndView.addObject("project", projectEntity);
        modelAndView.addObject("responsible", userRepository.findById(projectEntity.getUserIdUser()).get());
        modelAndView.addObject("laboratory", laboratoryRepository.findById(projectEntity.getLaboratoryIdLaboratory()).get());
        modelAndView.addObject("rats", boxRepository.findAllByTypeBoxAndProjectIdProject("Ratos", projectEntity.getIdProject()));
        modelAndView.addObject("mice", boxRepository.findAllByTypeBoxAndProjectIdProject("Camundongos", projectEntity.getIdProject()));
        modelAndView.addObject("rabbit", boxRepository.findAllByTypeBoxAndProjectIdProject("Coelhos", projectEntity.getIdProject()));
        modelAndView.addObject("cobaio", boxRepository.findAllByTypeBoxAndProjectIdProject("Cobaio", projectEntity.getIdProject()));

        ModifierEntity modifierEntity = modifierRepository.findFirstByProjectIdProjectOrderByDateModifierDesc(project_id);
        if(modifierEntity != null) {
            long days = ( new Date(System.currentTimeMillis()).getTime() - modifierEntity.getDateModifier().getTime() ) / (1000 * 60 * 60 * 24) ;
            System.out.println("DAYS: "+days);
            modelAndView.addObject("days_last_att", days);
            modelAndView.addObject("last_att", modifierEntity.getMsgModifier());
        }
        return modelAndView;


    }

    @RequestMapping(value = "/project/delete")
    public boolean project_delete(
            @RequestParam(value = "project_id") int project_id,
            @RequestParam(value = "laboratory_id") int laboratory_id
    ){

        ProjectEntityPK projectEntityPK = new ProjectEntityPK();
        projectEntityPK.setIdProject(project_id);
        projectEntityPK.setLaboratoryIdLaboratory(laboratory_id);
        ProjectEntity projectEntity = projectRepository.findById(projectEntityPK).get();

        try{
            List<BoxEntity> boxEntities = boxRepository.findAllByProjectIdProject(projectEntity.getIdProject());
            for(BoxEntity boxEntity : boxEntities){
                boxRepository.delete(boxEntity);
            }
            List<ModifierEntity> modifierEntities = modifierRepository.findAllByProjectIdProject(projectEntity.getIdProject());
            modifierRepository.deleteAll(modifierEntities);
            projectRepository.delete(projectEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value="/project/listall")
    public ModelAndView project_listall(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("/layout/fragments/project/listall");
        modelAndView.addObject("title", "Lista de projetos");
        modelAndView.addObject("description", "");

        UserEntity userEntity = getUserLogger(authentication);
        List<ProjectEntity> projectEntities = new ArrayList<>();

        if(userEntity.getTypeUser() == 3) {
           projectEntities = projectRepository.findAllByUserIdUser(userEntity.getIdUser());
        }else if(userEntity.getTypeUser() == 2) {
            List<LaboratoryEntity> laboratoryEntities = laboratoryRepository.findAllByUserIdUser(userEntity.getIdUser());
            for(LaboratoryEntity laboratoryEntity : laboratoryEntities) {
                projectEntities = (projectRepository.findAllByLaboratoryIdLaboratory(laboratoryEntity.getIdLaboratory()));
            }
        }else{
            projectEntities = (List)projectRepository.findAll();
        }
        List<LaboratoryEntity> laboratoryEntities = new ArrayList<>();
        List<UserEntity> userEntities = new ArrayList<>();
        for(ProjectEntity projectEntity : projectEntities){
           userEntities.add(userRepository.findById(projectEntity.getUserIdUser()).get());
           laboratoryEntities.add(laboratoryRepository.findById(projectEntity.getLaboratoryIdLaboratory()).get());
        }


        modelAndView.addObject("projects", projectEntities);
        modelAndView.addObject("laboratories", laboratoryEntities);
        modelAndView.addObject("users", userEntities);

        return modelAndView;
    }

    //---------------- Atualizações ---------------------

    @RequestMapping(value = "/modifier/add")
    public void modifier_add(
            @RequestParam(value = "projectId") int projectID,
            @RequestParam(value = "msg") String msg,
            @RequestParam(value = "status") boolean status
    ){
        ModifierEntity modifierEntity = new ModifierEntity();
        modifierEntity.setProjectIdProject(projectID);
        modifierEntity.setMsgModifier(msg);
        modifierEntity.setDateModifier(new Date(System.currentTimeMillis()));
        modifierRepository.save(modifierEntity);
        if(status){
           ProjectEntity projectEntity = projectRepository.findByIdProject(projectID);
           projectEntity.setStatusDocProject("Aceito");
           projectRepository.save(projectEntity);
        }
    }

    //----------------- Relatórios -----------------------
    @RequestMapping(value = "/reports")
    public ModelAndView reports(){
        ModelAndView modelAndView = new ModelAndView("/reports");

        List<BoxEntity> allbox = (List)boxRepository.findAll();

        int[] total_ratos = new int[3];
        int[] total_camundongos = new int[3];
        int[] total_coelhos = new int[3];
        int[] total_cobaio = new int[3];

        int[] sala1 = new int[3];
        int[] sala2 = new int[3];
        int[] salaprof = new int[3];
        int[] salaprofa = new int[3];

        HashMap<String, int[]> labs = new HashMap<>();
        for(BoxEntity boxEntity : allbox){
            int macho = boxEntity.getQtdMaleBox();
            int femea = boxEntity.getQtdFemaleBox();
            switch (boxEntity.getTypeBox()){
                case "Ratos":
                    total_ratos[0] += macho;
                    total_ratos[1] += femea;
                    System.out.println("[1]");
                    break;
                case "Camundongos":
                    total_camundongos[0] += macho;
                    total_camundongos[1] += femea;
                    System.out.println("[2] - "+macho+"\t"+femea);
                    break;
                case "Coelhos":
                    total_coelhos[0] += macho;
                    total_coelhos[1] += femea;
                    System.out.println("[3]");
                    break;
                case "Cobaio":
                    total_cobaio[0] += macho;
                    total_cobaio[1] += femea;
                    System.out.println("[4]");
                    break;
            }



            ProjectEntity projectEntity = projectRepository.findByIdProject(boxEntity.getProjectIdProject());
            switch (projectEntity.getLocalProject()){
                case "Sala 1":
                    sala1[0] += macho;
                    sala1[1] += femea;

                    break;
                case "Sala 2":
                    sala2[0] += macho;
                    sala2[1] += femea;

                    break;
                case "Sala Professor Nilberto":
                    salaprof[0] += macho;
                    salaprof[1] += femea;

                    break;
                case "Sala Professora Ana Maria":
                    salaprofa[0] += macho;
                    salaprofa[1] += femea;

                    break;
            }
            LaboratoryEntity laboratoryEntity = laboratoryRepository.findById(projectEntity.getLaboratoryIdLaboratory()).get();
            try{
                int[] valores = labs.get(laboratoryEntity.getInitialsLaboratory());
                valores[0] += macho;
                valores[1] += femea;
                valores[2] += (macho + femea);
                labs.put(laboratoryEntity.getInitialsLaboratory(), valores);
            }catch(Exception e) {
                labs.put(laboratoryEntity.getInitialsLaboratory(), new int[]{macho, femea, (macho + femea)});
            }
        }


        total_ratos[2] = total_ratos[0] + total_ratos[1];
        total_coelhos[2] = total_coelhos[0] + total_coelhos[1];
        total_camundongos[2] = total_camundongos[0] + total_camundongos[1];
        total_cobaio[2] = total_cobaio[0] + total_cobaio[1];

        sala1[2] = sala1[0] + sala1[1];
        sala2[2] = sala2[0] + sala2[1];
        salaprof[2] = salaprof[0] + salaprof[1];
        salaprofa[2] = salaprofa[0] + salaprofa[1];

        int[] total = new int[3];
        total[0] = total_camundongos[0] + total_cobaio[0] + total_coelhos[0] + total_ratos[0];
        total[1] = total_camundongos[1] + total_cobaio[1] + total_coelhos[1] + total_ratos[1];
        total[2] = total_camundongos[2] + total_cobaio[2] + total_coelhos[2] + total_ratos[2];


        modelAndView.addObject("labs",labs);
        System.out.println("RATOS: "+total_ratos[0]);
        System.out.println("COELHOS: "+total_coelhos[0]);
        System.out.println("CAMUNDONGOS: "+total_camundongos[0]);
        System.out.println("COBAIO: "+total_cobaio[0]);
        modelAndView.addObject("ratos", total_ratos);
        modelAndView.addObject("coelhos",total_coelhos);
        modelAndView.addObject("camundongos", total_camundongos);
        modelAndView.addObject("cobaio", total_cobaio);

        modelAndView.addObject("sala1", sala1);
        modelAndView.addObject("sala2", sala2);
        modelAndView.addObject("prof", salaprof);
        modelAndView.addObject("profa", salaprofa);

        modelAndView.addObject("total", total);








        return modelAndView;
    }













    private UserEntity getUserLogger(Authentication authentication){
        UserEntity userEntity = ((MyUserPrincipal) authentication.getPrincipal()).getUserEntity();
        return userEntity;
    }

}
