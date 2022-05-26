package com.ezdml.erupt.ezdemo.researchmanagement.thirdpartyinstitutions;


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
import org.hibernate.annotations.GenericGenerator;

// import com.ezdml.erupt.ezdemo.researchmanagement.link_project_institutions.ProjectInstitution;
import com.ezdml.erupt.ezdemo.researchmanagement.thirdpartystaff.ThirdPartyStaff;

@Erupt(
    name = "第三方机构",
    power = @Power(importable = true, export = true)
)
@Table(name = "ThirdPartyInstitutions")   //数据库表名
@Entity
public class ThirdPartyInstitutions{


    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator", strategy="native")
    @EruptField()
    private Long id;
    
    @EruptField(
        views = @View(
            title = "机构名称",
            width = "120"
        ),
        edit = @Edit(
            title = "机构名称",
            notNull = true
        )
    )
    private String name;
    
    @EruptField(
        views = @View(
            title = "地址",
            width = "120"
        ),
        edit = @Edit(
            title = "地址"
        )
    )
    private String addr;
    
    @ManyToOne
    @EruptField(
        views = {
            @View(
                title = "负责人姓名",
                column = "name"
            )
        },
        edit = @Edit(
            title = "第三方机构负责人",
            notNull = true,
            type = EditType.REFERENCE_TABLE,
            referenceTableType = @ReferenceTableType(id = "id", label = "name")
        )
    )
    private ThirdPartyStaff leader;
    
    @ManyToOne
    @EruptField(
        views = {
            @View(
                title = "联系人姓名",
                column = "name"
            )
        },
        edit = @Edit(
            title = "第三方机构联系人",
            notNull = true,
            type = EditType.REFERENCE_TABLE,
            referenceTableType = @ReferenceTableType(id = "id", label = "name")
        )
    )
    private ThirdPartyStaff contact;
    
    /*
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "InstitutionId")
    @EruptField(
        edit = @Edit(title = "ProjectInstitution列表", type = EditType.TAB_TABLE_ADD)
    )
    private Set<ProjectInstitution> projectInstitutionList;
    */
    

}