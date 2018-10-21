package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Team", schema = "ratLab")
public class TeamEntity {
    private int idTeam;

    @Id
    @Column(name = "idTeam")
    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return idTeam == that.idTeam;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTeam);
    }
}
