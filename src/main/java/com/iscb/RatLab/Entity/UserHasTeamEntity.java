package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "User_has_Team", schema = "ratLab")
public class UserHasTeamEntity {
    private int teamIdTeam;

    @Id
    @Column(name = "Team_idTeam")
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
        return teamIdTeam == that.teamIdTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamIdTeam);
    }
}
