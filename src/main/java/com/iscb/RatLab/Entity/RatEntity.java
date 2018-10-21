package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Rat", schema = "ratLab")
@IdClass(RatEntityPK.class)
public class RatEntity {
    private int idRat;
    private String especieRato;
    private int boxIdBox;

    @Id
    @Column(name = "idRat")
    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    @Basic
    @Column(name = "especieRato")
    public String getEspecieRato() {
        return especieRato;
    }

    public void setEspecieRato(String especieRato) {
        this.especieRato = especieRato;
    }

    @Id
    @Column(name = "Box_idBox")
    public int getBoxIdBox() {
        return boxIdBox;
    }

    public void setBoxIdBox(int boxIdBox) {
        this.boxIdBox = boxIdBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatEntity ratEntity = (RatEntity) o;
        return idRat == ratEntity.idRat &&
                boxIdBox == ratEntity.boxIdBox &&
                Objects.equals(especieRato, ratEntity.especieRato);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRat, especieRato, boxIdBox);
    }
}
