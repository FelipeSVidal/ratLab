package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BoxEntityPK implements Serializable {
    private int idBox;
    private int projectIdProject;

    @Column(name = "idBox")
    @Id
    public int getIdBox() {
        return idBox;
    }

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    @Column(name = "Project_idProject")
    @Id
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
        BoxEntityPK that = (BoxEntityPK) o;
        return idBox == that.idBox &&
                projectIdProject == that.projectIdProject;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBox, projectIdProject);
    }
}
