package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_has_team", schema = "ratLab")
@IdClass(UserHasTeamEntityPK.class)
public class UserHasTeamEntity {
    private int userIdUser;
    private int userUserTypeIdUserType;
    private int teamIdTeam;

    @Id
    @Column(name = "user_id_user")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Id
    @Column(name = "user_user_type_id_user_type")
    public int getUserUserTypeIdUserType() {
        return userUserTypeIdUserType;
    }

    public void setUserUserTypeIdUserType(int userUserTypeIdUserType) {
        this.userUserTypeIdUserType = userUserTypeIdUserType;
    }

    @Id
    @Column(name = "team_id_team")
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
        UserHasTeamEntity that = (UserHasTeamEntity) o;
        return userIdUser == that.userIdUser &&
                userUserTypeIdUserType == that.userUserTypeIdUserType &&
                teamIdTeam == that.teamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userIdUser, userUserTypeIdUserType, teamIdTeam);
    }
}
