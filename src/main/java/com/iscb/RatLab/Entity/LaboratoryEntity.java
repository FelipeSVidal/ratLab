package com.iscb.RatLab.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Laboratory", schema = "ratLab")
public class LaboratoryEntity {
    private int idLaboratory;
    private String nameLaboratory;

    @Id
    @Column(name = "idLaboratory")
    public int getIdLaboratory() {
        return idLaboratory;
    }

    public void setIdLaboratory(int idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    @Basic
    @Column(name = "nameLaboratory")
    public String getNameLaboratory() {
        return nameLaboratory;
    }

    public void setNameLaboratory(String nameLaboratory) {
        this.nameLaboratory = nameLaboratory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaboratoryEntity that = (LaboratoryEntity) o;
        return idLaboratory == that.idLaboratory &&
                Objects.equals(nameLaboratory, that.nameLaboratory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLaboratory, nameLaboratory);
    }
}
