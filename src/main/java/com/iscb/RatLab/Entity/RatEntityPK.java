package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RatEntityPK implements Serializable {
    private int idRat;
    private int boxIdBox;
    private int boxProjectIdProject;
    private int boxProjectLaboratoryIdLaboratory;
    private int boxProjectTeamIdTeam;

    @Column(name = "id_rat")
    @Id
    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    @Column(name = "box_id_box")
    @Id
    public int getBoxIdBox() {
        return boxIdBox;
    }

    public void setBoxIdBox(int boxIdBox) {
        this.boxIdBox = boxIdBox;
    }

    @Column(name = "box_project_id_project")
    @Id
    public int getBoxProjectIdProject() {
        return boxProjectIdProject;
    }

    public void setBoxProjectIdProject(int boxProjectIdProject) {
        this.boxProjectIdProject = boxProjectIdProject;
    }

    @Column(name = "box_project_laboratory_id_laboratory")
    @Id
    public int getBoxProjectLaboratoryIdLaboratory() {
        return boxProjectLaboratoryIdLaboratory;
    }

    public void setBoxProjectLaboratoryIdLaboratory(int boxProjectLaboratoryIdLaboratory) {
        this.boxProjectLaboratoryIdLaboratory = boxProjectLaboratoryIdLaboratory;
    }

    @Column(name = "box_project_team_id_team")
    @Id
    public int getBoxProjectTeamIdTeam() {
        return boxProjectTeamIdTeam;
    }

    public void setBoxProjectTeamIdTeam(int boxProjectTeamIdTeam) {
        this.boxProjectTeamIdTeam = boxProjectTeamIdTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatEntityPK that = (RatEntityPK) o;
        return idRat == that.idRat &&
                boxIdBox == that.boxIdBox &&
                boxProjectIdProject == that.boxProjectIdProject &&
                boxProjectLaboratoryIdLaboratory == that.boxProjectLaboratoryIdLaboratory &&
                boxProjectTeamIdTeam == that.boxProjectTeamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRat, boxIdBox, boxProjectIdProject, boxProjectLaboratoryIdLaboratory, boxProjectTeamIdTeam);
    }
}
