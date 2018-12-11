package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "box", schema = "ratLab")
@IdClass(BoxEntityPK.class)
public class BoxEntity {

    private int idBox;
    private Integer qtdMaleBox;
    private Integer qtdFemaleBox;
    private String typeBox;
    private int projectIdProject;

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
    @Column(name = "qtd_male_box")
    public Integer getQtdMaleBox() {
        return qtdMaleBox;
    }

    public void setQtdMaleBox(Integer qtdMaleBox) {
        this.qtdMaleBox = qtdMaleBox;
    }

    @Basic
    @Column(name = "qtd_female_box")
    public Integer getQtdFemaleBox() {
        return qtdFemaleBox;
    }

    public void setQtdFemaleBox(Integer qtdFemaleBox) {
        this.qtdFemaleBox = qtdFemaleBox;
    }

    @Basic
    @Column(name = "type_box")
    public String getTypeBox() {
        return typeBox;
    }

    public void setTypeBox(String typeBox) {
        this.typeBox = typeBox;
    }


    @Id
    @Column(name = "project_id_project")
    public int getProjectIdProject() {
        return projectIdProject;
    }

    public void setProjectIdProject(int projectIdProject) {
        this.projectIdProject = projectIdProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxEntity boxEntity = (BoxEntity) o;
        return idBox == boxEntity.idBox &&
                projectIdProject == boxEntity.projectIdProject &&
                Objects.equals(qtdMaleBox, boxEntity.qtdMaleBox) &&
                Objects.equals(qtdFemaleBox, boxEntity.qtdFemaleBox) &&
                Objects.equals(typeBox, boxEntity.typeBox);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBox, qtdMaleBox, qtdFemaleBox, typeBox, projectIdProject);
    }
}
