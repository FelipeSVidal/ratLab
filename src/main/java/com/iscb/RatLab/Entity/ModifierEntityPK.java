package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ModifierEntityPK implements Serializable {
    private int idModifier;
    private int projectIdProject;

    @Column(name = "id_modifier")
    @Id
    public int getIdModifier() {
        return idModifier;
    }

    public void setIdModifier(int idModifier) {
        this.idModifier = idModifier;
    }

    @Column(name = "project_id_project")
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
        ModifierEntityPK that = (ModifierEntityPK) o;
        return idModifier == that.idModifier &&
                projectIdProject == that.projectIdProject;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idModifier, projectIdProject);
    }
}
