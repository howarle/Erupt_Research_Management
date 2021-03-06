package com.ezdml.erupt.ezdemo.researchmanagement.place;


/*
 * Copyright © 2022 xxx.xx All rights reserved.
 * Author: xxx (xx@xx.com)
 * Generated by EZDML 5/23/2022 16:32:45
 */

import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.*;
import java.util.Date;
import javax.persistence.*;

import com.ezdml.erupt.ezdemo.researchmanagement.lab.Lab;

import org.hibernate.annotations.GenericGenerator;



@Erupt(
    name = "场地",
    power = @Power(importable = true, export = true)
)
@Table(name = "Place")   //数据库表名
@Entity
public class Place{


    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator", strategy="native")
    @EruptField()
    private Long id;
    
    @EruptField(
        views = @View(
            title = "场地地址",
            width = "120"
        ),
        edit = @Edit(
            title = "场地地址",
            notNull = true
        )
    )
    private String addr;
    
    @EruptField(
        views = @View(
            title = "面积",
            width = "120"
        ),
        edit = @Edit(
            title = "面积"
        )
    )
    private Float size;
    
    // @ManyToMany
    // @JoinTable(
    //         name = "link_lab_place",
    //         joinColumns = @JoinColumn(name = "place_id", referencedColumnName = "id"),
    //         inverseJoinColumns = @JoinColumn(name = "lab_id", referencedColumnName = "id")
    // )
    // @EruptField(
    //         edit = @Edit(title = "场地占用情况", type = EditType.TAB_TABLE_REFER,
    //                 referenceTableType = @ReferenceTableType(label = "title"))
    // )
    // private Set<Lab> lab;
}
