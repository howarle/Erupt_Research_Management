package com.ezdml.erupt.ezdemo.researchmanagement.lab;


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

import com.ezdml.erupt.ezdemo.researchmanagement.place.Place;
import com.ezdml.erupt.ezdemo.researchmanagement.staff.Staff;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.WhereJoinTable;



@Erupt(
    name = "研究室",
    power = @Power(importable = true, export = true)
)
@Table(name = "Lab")   //数据库表名
@Entity
public class Lab{


    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator", strategy="native")
    @EruptField()
    private Long id;
    
    @EruptField(
        views = @View(
            title = "研究室名称",
            width = "120"
        ),
        edit = @Edit(
            title = "研究室名称"
        )
    )
    private String name;
    
    @EruptField(
        views = @View(
            title = "研究室简介",
            width = "120"
        ),
        edit = @Edit(
            title = "研究室简介"
        )
    )
    private String intro;
    
    @ManyToMany
    @JoinTable(
            name = "link_researchers_lab",
            joinColumns = @JoinColumn(name = "lab_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "researcher_id", referencedColumnName = "id")
    )
    @EruptField(
            edit = @Edit(title = "参与人员", type = EditType.TAB_TABLE_REFER,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Set<Staff> participators;
    
    @ManyToMany
    @JoinTable(
            name = "link_lab_place",
            joinColumns = @JoinColumn(name = "lab_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "place_id", referencedColumnName = "id")
    )
    @EruptField(
            edit = @Edit(title = "场地", type = EditType.TAB_TABLE_REFER,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Set<Place> place;
}
