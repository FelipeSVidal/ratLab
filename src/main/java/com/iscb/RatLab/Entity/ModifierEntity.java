package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "modifier", schema = "ratLab")
@IdClass(ModifierEntityPK.class)
public class ModifierEntity {
    private int idModifier;
    private String msgModifier;
    private Date dateModifier;
    private int projectIdProject;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modifier")
    public int getIdModifier() {
        return idModifier;
    }

    public void setIdModifier(int idModifier) {
        this.idModifier = idModifier;
    }

    @Basic
    @Column(name = "msg_modifier")
    public String getMsgModifier() {
        return msgModifier;
    }

    public void setMsgModifier(String msgModifier) {
        this.msgModifier = msgModifier;
    }

    @Basic
    @Column(name = "date_modifier")
    public Date getDateModifier() {
        return dateModifier;
    }

    public void setDateModifier(Date dateModifier) {
        this.dateModifier = dateModifier;
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
        ModifierEntity that = (ModifierEntity) o;
        return idModifier == that.idModifier &&
                projectIdProject == that.projectIdProject &&
                Objects.equals(msgModifier, that.msgModifier) &&
                Objects.equals(dateModifier, that.dateModifier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idModifier, msgModifier, dateModifier, projectIdProject);
    }
}
