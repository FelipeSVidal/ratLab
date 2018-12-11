package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProjectEntityPK implements Serializable {
    private int idProject;
    private int laboratoryIdLaboratory;

    @Column(name = "id_project")
    @Id
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Column(name = "laboratory_id_laboratory")
    @Id
    public int getLaboratoryIdLaboratory() {
        return laboratoryIdLaboratory;
    }

    public void setLaboratoryIdLaboratory(int laboratoryIdLaboratory) {
        this.laboratoryIdLaboratory = laboratoryIdLaboratory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntityPK that = (ProjectEntityPK) o;
        return idProject == that.idProject &&
                laboratoryIdLaboratory == that.laboratoryIdLaboratory;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProject, laboratoryIdLaboratory);
    }
}
