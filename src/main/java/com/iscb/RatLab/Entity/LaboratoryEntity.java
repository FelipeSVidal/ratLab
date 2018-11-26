package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "laboratory", schema = "ratLab")
public class LaboratoryEntity {
    private int idLaboratory;
    private String nameLaboratory;
    private String initialsLaboratory;
    private int userIdUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory")
    public int getIdLaboratory() {
        return idLaboratory;
    }

    public void setIdLaboratory(int idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    @Basic
    @Column(name = "name_laboratory")
    public String getNameLaboratory() {
        return nameLaboratory;
    }

    public void setNameLaboratory(String nameLaboratory) {
        this.nameLaboratory = nameLaboratory;
    }

    @Basic
    @Column(name = "initials_laboratory")
    public String getInitialsLaboratory() {
        return initialsLaboratory;
    }

    public void setInitialsLaboratory(String initialsLaboratory) {
        this.initialsLaboratory = initialsLaboratory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaboratoryEntity that = (LaboratoryEntity) o;
        return idLaboratory == that.idLaboratory &&
                Objects.equals(nameLaboratory, that.nameLaboratory) &&
                Objects.equals(initialsLaboratory, that.initialsLaboratory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLaboratory, nameLaboratory, initialsLaboratory);
    }

    @Basic
    @Column(name = "user_id_user")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }
}
