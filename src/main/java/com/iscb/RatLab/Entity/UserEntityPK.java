package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserEntityPK implements Serializable {

    private int idUser;
    private int userTypeIdUserType;


    @Column(name = "id_user")
    @Id
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Column(name = "user_type_id_user_type")
    @Id
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
        UserEntityPK that = (UserEntityPK) o;
        return idUser == that.idUser &&
                userTypeIdUserType == that.userTypeIdUserType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, userTypeIdUserType);
    }
}
