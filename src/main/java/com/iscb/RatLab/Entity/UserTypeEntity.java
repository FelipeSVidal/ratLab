package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserType", schema = "ratLab")
public class UserTypeEntity {
    private int idUserType;
    private int userType;

    @Id
    @Column(name = "idUserType")
    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }

    @Basic
    @Column(name = "UserType")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTypeEntity that = (UserTypeEntity) o;
        return idUserType == that.idUserType &&
                userType == that.userType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserType, userType);
    }
}
