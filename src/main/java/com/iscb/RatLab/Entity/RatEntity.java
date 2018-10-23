package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rat", schema = "ratLab")
@IdClass(RatEntityPK.class)
public class RatEntity {
    private int idRat;
    private String especieRato;
    private int boxIdBox;
    private int boxProjectIdProject;
    private int boxProjectLaboratoryIdLaboratory;
    private int boxProjectTeamIdTeam;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rat")
    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    @Basic
    @Column(name = "especie_rato")
    public String getEspecieRato() {
        return especieRato;
    }

    public void setEspecieRato(String especieRato) {
        this.especieRato = especieRato;
    }

    @Id
    @Column(name = "box_id_box")
    public int getBoxIdBox() {
        return boxIdBox;
    }

    public void setBoxIdBox(int boxIdBox) {
        this.boxIdBox = boxIdBox;
    }

    @Id
    @Column(name = "box_project_id_project")
    public int getBoxProjectIdProject() {
        return boxProjectIdProject;
    }

    public void setBoxProjectIdProject(int boxProjectIdProject) {
        this.boxProjectIdProject = boxProjectIdProject;
    }

    @Id
    @Column(name = "box_project_laboratory_id_laboratory")
    public int getBoxProjectLaboratoryIdLaboratory() {
        return boxProjectLaboratoryIdLaboratory;
    }

    public void setBoxProjectLaboratoryIdLaboratory(int boxProjectLaboratoryIdLaboratory) {
        this.boxProjectLaboratoryIdLaboratory = boxProjectLaboratoryIdLaboratory;
    }

    @Id
    @Column(name = "box_project_team_id_team")
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
        RatEntity ratEntity = (RatEntity) o;
        return idRat == ratEntity.idRat &&
                boxIdBox == ratEntity.boxIdBox &&
                boxProjectIdProject == ratEntity.boxProjectIdProject &&
                boxProjectLaboratoryIdLaboratory == ratEntity.boxProjectLaboratoryIdLaboratory &&
                boxProjectTeamIdTeam == ratEntity.boxProjectTeamIdTeam &&
                Objects.equals(especieRato, ratEntity.especieRato);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRat, especieRato, boxIdBox, boxProjectIdProject, boxProjectLaboratoryIdLaboratory, boxProjectTeamIdTeam);
    }
}
