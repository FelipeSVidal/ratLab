package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BoxEntityPK implements Serializable {
    private int idBox;
    private int projectIdProject;
    private int projectLaboratoryIdLaboratory;
    private int projectTeamIdTeam;

    @Column(name = "id_box")
    @Id
    public int getIdBox() {
        return idBox;
    }

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    @Column(name = "project_id_project")
    @Id
    public int getProjectIdProject() {
        return projectIdProject;
    }

    public void setProjectIdProject(int projectIdProject) {
        this.projectIdProject = projectIdProject;
    }

    @Column(name = "project_laboratory_id_laboratory")
    @Id
    public int getProjectLaboratoryIdLaboratory() {
        return projectLaboratoryIdLaboratory;
    }

    public void setProjectLaboratoryIdLaboratory(int projectLaboratoryIdLaboratory) {
        this.projectLaboratoryIdLaboratory = projectLaboratoryIdLaboratory;
    }

    @Column(name = "project_team_id_team")
    @Id
    public int getProjectTeamIdTeam() {
        return projectTeamIdTeam;
    }

    public void setProjectTeamIdTeam(int projectTeamIdTeam) {
        this.projectTeamIdTeam = projectTeamIdTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxEntityPK that = (BoxEntityPK) o;
        return idBox == that.idBox &&
                projectIdProject == that.projectIdProject &&
                projectLaboratoryIdLaboratory == that.projectLaboratoryIdLaboratory &&
                projectTeamIdTeam == that.projectTeamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBox, projectIdProject, projectLaboratoryIdLaboratory, projectTeamIdTeam);
    }
}
