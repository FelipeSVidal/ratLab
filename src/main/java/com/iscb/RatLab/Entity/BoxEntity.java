package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Box", schema = "ratLab")
@IdClass(BoxEntityPK.class)
public class BoxEntity {
    private int idBox;
    private int nRatsBox;
    private Date createdBox;
    private Date lastModifiBox;
    private int projectIdProject;

    @Id
    @Column(name = "idBox")
    public int getIdBox() {
        return idBox;
    }

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    @Basic
    @Column(name = "nRatsBox")
    public int getnRatsBox() {
        return nRatsBox;
    }

    public void setnRatsBox(int nRatsBox) {
        this.nRatsBox = nRatsBox;
    }

    @Basic
    @Column(name = "createdBox")
    public Date getCreatedBox() {
        return createdBox;
    }

    public void setCreatedBox(Date createdBox) {
        this.createdBox = createdBox;
    }

    @Basic
    @Column(name = "lastModifiBox")
    public Date getLastModifiBox() {
        return lastModifiBox;
    }

    public void setLastModifiBox(Date lastModifiBox) {
        this.lastModifiBox = lastModifiBox;
    }

    @Id
    @Column(name = "Project_idProject")
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
                nRatsBox == boxEntity.nRatsBox &&
                projectIdProject == boxEntity.projectIdProject &&
                Objects.equals(createdBox, boxEntity.createdBox) &&
                Objects.equals(lastModifiBox, boxEntity.lastModifiBox);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBox, nRatsBox, createdBox, lastModifiBox, projectIdProject);
    }
}
