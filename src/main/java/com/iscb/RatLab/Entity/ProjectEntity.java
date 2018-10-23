package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "ratLab")
@IdClass(ProjectEntityPK.class)
public class ProjectEntity {
    private int idProject;
    private String nameProject;
    private int laboratoryIdLaboratory;
    private int teamIdTeam;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "name_project")
    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    @Id
    @Column(name = "laboratory_id_laboratory")
    public int getLaboratoryIdLaboratory() {
        return laboratoryIdLaboratory;
    }

    public void setLaboratoryIdLaboratory(int laboratoryIdLaboratory) {
        this.laboratoryIdLaboratory = laboratoryIdLaboratory;
    }

    @Id
    @Column(name = "team_id_team")
    public int getTeamIdTeam() {
        return teamIdTeam;
    }

    public void setTeamIdTeam(int teamIdTeam) {
        this.teamIdTeam = teamIdTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return idProject == that.idProject &&
                laboratoryIdLaboratory == that.laboratoryIdLaboratory &&
                teamIdTeam == that.teamIdTeam &&
                Objects.equals(nameProject, that.nameProject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProject, nameProject, laboratoryIdLaboratory, teamIdTeam);
    }
}
