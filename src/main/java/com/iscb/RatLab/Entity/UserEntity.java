package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "ratLab")
@IdClass(UserEntityPK.class)
public class UserEntity {
    private int idUser;
    private String nameUser;
    private String emailUser;
    private String passwordUser;
    private int userTypeIdUserType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "name_user")
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Basic
    @Column(name = "email_user")
    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Basic
    @Column(name = "password_user")
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Id
    @Column(name = "user_type_id_user_type")
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
                Objects.equals(emailUser, that.emailUser) &&
                Objects.equals(passwordUser, that.passwordUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, nameUser, emailUser, passwordUser, userTypeIdUserType);
    }
}
