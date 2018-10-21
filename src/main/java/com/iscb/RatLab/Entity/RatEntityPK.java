package com.iscb.RatLab.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RatEntityPK implements Serializable {
    private int idRat;
    private int boxIdBox;

    @Column(name = "idRat")
    @Id
    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    @Column(name = "Box_idBox")
    @Id
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
        RatEntityPK that = (RatEntityPK) o;
        return idRat == that.idRat &&
                boxIdBox == that.boxIdBox;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRat, boxIdBox);
    }
}
