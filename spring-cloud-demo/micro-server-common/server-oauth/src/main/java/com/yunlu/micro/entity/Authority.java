package com.yunlu.micro.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by SuperS on 2017/9/25.
 *
 * @author SuperS
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Authority {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String value;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

}
