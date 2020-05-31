package com.server.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "kurier_id")
public class Kurier extends User{

    private String imieinazwisko;

}
