package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProjectEntityPK implements Serializable {
    private int idProject;
    private int laboratoryIdLaboratory;
    private int teamIdTeam;

    @Column(name = "idProject")
    @Id
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Column(name = "Laboratory_idLaboratory")
    @Id
    public int getLaboratoryIdLaboratory() {
        return laboratoryIdLaboratory;
    }

    public void setLaboratoryIdLaboratory(int laboratoryIdLaboratory) {
        this.laboratoryIdLaboratory = laboratoryIdLaboratory;
    }

    @Column(name = "Team_idTeam")
    @Id
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
        ProjectEntityPK that = (ProjectEntityPK) o;
        return idProject == that.idProject &&
                laboratoryIdLaboratory == that.laboratoryIdLaboratory &&
                teamIdTeam == that.teamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProject, laboratoryIdLaboratory, teamIdTeam);
    }
}
