package com.uptc.frmw.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TABLE_NAME")
public class EntityExample {

    @Id
    private Long id;

}
