package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Project", schema = "ratLab")
@IdClass(ProjectEntityPK.class)
public class ProjectEntity {
    private int idProject;
    private String nameProject;
    private int laboratoryIdLaboratory;
    private int teamIdTeam;

    @Id
    @Column(name = "idProject")
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "nameProject")
    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    @Id
    @Column(name = "Laboratory_idLaboratory")
    public int getLaboratoryIdLaboratory() {
        return laboratoryIdLaboratory;
    }

    public void setLaboratoryIdLaboratory(int laboratoryIdLaboratory) {
        this.laboratoryIdLaboratory = laboratoryIdLaboratory;
    }

    @Id
    @Column(name = "Team_idTeam")
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
