package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "ratLab")
public class UserEntity {
    private int idUser;
    private String loginUser;
    private String passwordUser;
    private int typeUser;
    private String nameUser;

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
    @Column(name = "login_user")
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @Basic
    @Column(name = "password_user")
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Basic
    @Column(name = "type_user")
    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    @Basic
    @Column(name = "name_user")
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                typeUser == that.typeUser &&
                Objects.equals(loginUser, that.loginUser) &&
                Objects.equals(passwordUser, that.passwordUser) &&
                Objects.equals(nameUser, that.nameUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, loginUser, passwordUser, typeUser, nameUser);
    }
}
