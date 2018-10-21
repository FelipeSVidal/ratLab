package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "ratLab")
@IdClass(UserEntityPK.class)
public class UserEntity {
    private int idUser;
    private String nameUser;
    private String emailUser;
    private int userTypeIdUserType;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nameUser")
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Basic
    @Column(name = "emailUser")
    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Id
    @Column(name = "UserType_idUserType")
    public int getUserTypeIdUserType() {
        return userTypeIdUserType;
    }

    public void setUserTypeIdUserType(int userTypeIdUserType) {
        this.userTypeIdUserType = userTypeIdUserType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                userTypeIdUserType == that.userTypeIdUserType &&
                Objects.equals(nameUser, that.nameUser) &&
                Objects.equals(emailUser, that.emailUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, nameUser, emailUser, userTypeIdUserType);
    }
}
