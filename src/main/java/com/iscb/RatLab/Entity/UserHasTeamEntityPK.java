package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserHasTeamEntityPK implements Serializable {
    private int userIdUser;
    private int userUserTypeIdUserType;
    private int teamIdTeam;

    @Column(name = "user_id_user")
    @Id
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Column(name = "user_user_type_id_user_type")
    @Id
    public int getUserUserTypeIdUserType() {
        return userUserTypeIdUserType;
    }

    public void setUserUserTypeIdUserType(int userUserTypeIdUserType) {
        this.userUserTypeIdUserType = userUserTypeIdUserType;
    }

    @Column(name = "team_id_team")
    @Id
    public int getTeamIdTeam() {
        return teamIdTeam;
    }

    public void setTeamIdTeam(int teamIdTeam) {
        this.teamIdTeam = teamIdTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHasTeamEntityPK that = (UserHasTeamEntityPK) o;
        return userIdUser == that.userIdUser &&
                userUserTypeIdUserType == that.userUserTypeIdUserType &&
                teamIdTeam == that.teamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userIdUser, userUserTypeIdUserType, teamIdTeam);
    }
}
