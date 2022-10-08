package com.gjara.inventory.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @NotBlank
    private String name;

    @OneToOne(mappedBy="registers")
    private Register register;

    public Action(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
}
