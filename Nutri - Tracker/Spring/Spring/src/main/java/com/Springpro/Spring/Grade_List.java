package com.Springpro.Spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "GRADE_LIST")
public class Grade_List {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "POINT")
    private int point;

    @Column(name = "PDT_ING")
    private String pdt_ingredients;
}
