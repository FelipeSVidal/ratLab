package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "box", schema = "ratLab")
@IdClass(BoxEntityPK.class)
public class BoxEntity {
    private int idBox;
    private int nRatsBox;
    private Date createdBox;
    private Date lastModifiBox;
    private int projectIdProject;
    private int projectLaboratoryIdLaboratory;
    private int projectTeamIdTeam;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_box")
    public int getIdBox() {
        return idBox;
    }

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    @Basic
    @Column(name = "n_rats_box")
    public int getnRatsBox() {
        return nRatsBox;
    }

    public void setnRatsBox(int nRatsBox) {
        this.nRatsBox = nRatsBox;
    }

    @Basic
    @Column(name = "created_box")
    public Date getCreatedBox() {
        return createdBox;
    }

    public void setCreatedBox(Date createdBox) {
        this.createdBox = createdBox;
    }

    @Basic
    @Column(name = "last_modifi_box")
    public Date getLastModifiBox() {
        return lastModifiBox;
    }

    public void setLastModifiBox(Date lastModifiBox) {
        this.lastModifiBox = lastModifiBox;
    }

    @Id
    @Column(name = "project_id_project")
    public int getProjectIdProject() {
        return projectIdProject;
    }

    public void setProjectIdProject(int projectIdProject) {
        this.projectIdProject = projectIdProject;
    }

    @Id
    @Column(name = "project_laboratory_id_laboratory")
    public int getProjectLaboratoryIdLaboratory() {
        return projectLaboratoryIdLaboratory;
    }

    public void setProjectLaboratoryIdLaboratory(int projectLaboratoryIdLaboratory) {
        this.projectLaboratoryIdLaboratory = projectLaboratoryIdLaboratory;
    }

    @Id
    @Column(name = "project_team_id_team")
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
        BoxEntity boxEntity = (BoxEntity) o;
        return idBox == boxEntity.idBox &&
                nRatsBox == boxEntity.nRatsBox &&
                projectIdProject == boxEntity.projectIdProject &&
                projectLaboratoryIdLaboratory == boxEntity.projectLaboratoryIdLaboratory &&
                projectTeamIdTeam == boxEntity.projectTeamIdTeam &&
                Objects.equals(createdBox, boxEntity.createdBox) &&
                Objects.equals(lastModifiBox, boxEntity.lastModifiBox);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBox, nRatsBox, createdBox, lastModifiBox, projectIdProject, projectLaboratoryIdLaboratory, projectTeamIdTeam);
    }
}
