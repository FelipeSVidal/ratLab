package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "ratLab")
@IdClass(ProjectEntityPK.class)
public class ProjectEntity {
    private int idProject;
    private String nameProject;
    private String nDocEthicProject;
    private String statusDocProject;
    private int laboratoryIdLaboratory;
    private int userIdUser;
    private String localProject;
    private Date dateCreateProject;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "name_project")
    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    @Basic
    @Column(name = "n_doc_ethic_project")
    public String getnDocEthicProject() {
        return nDocEthicProject;
    }

    public void setnDocEthicProject(String nDocEthicProject) {
        this.nDocEthicProject = nDocEthicProject;
    }

    @Basic
    @Column(name = "status_doc_project")
    public String getStatusDocProject() {
        return statusDocProject;
    }

    public void setStatusDocProject(String statusDocProject) {
        this.statusDocProject = statusDocProject;
    }

    @Id
    @Column(name = "laboratory_id_laboratory")
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
        ProjectEntity that = (ProjectEntity) o;
        return idProject == that.idProject &&
                laboratoryIdLaboratory == that.laboratoryIdLaboratory &&
                Objects.equals(nameProject, that.nameProject) &&
                Objects.equals(nDocEthicProject, that.nDocEthicProject) &&
                Objects.equals(statusDocProject, that.statusDocProject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProject, nameProject, nDocEthicProject, statusDocProject, laboratoryIdLaboratory);
    }

    @Basic
    @Column(name = "user_id_user")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Basic
    @Column(name = "local_project")
    public String getLocalProject() {
        return localProject;
    }

    public void setLocalProject(String localProject) {
        this.localProject = localProject;
    }

    @Basic
    @Column(name = "date_create_project")
    public Date getDateCreateProject() {
        return dateCreateProject;
    }

    public void setDateCreateProject(Date dateCreateProject) {
        this.dateCreateProject = dateCreateProject;
    }
}
