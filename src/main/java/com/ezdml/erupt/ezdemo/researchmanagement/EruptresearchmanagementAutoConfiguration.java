package com.ezdml.erupt.ezdemo.researchmanagement;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import xyz.erupt.core.annotation.EruptScan;
import xyz.erupt.core.module.EruptModule;
import xyz.erupt.core.module.EruptModuleInvoke;
import xyz.erupt.core.module.MetaMenu;
import xyz.erupt.core.module.ModuleInfo;
import java.util.ArrayList;
import java.util.List;



import com.ezdml.erupt.ezdemo.researchmanagement.staff.Staff;

import com.ezdml.erupt.ezdemo.researchmanagement.project.Project;

import com.ezdml.erupt.ezdemo.researchmanagement.thirdpartyinstitutions.ThirdPartyInstitutions;

import com.ezdml.erupt.ezdemo.researchmanagement.thirdpartystaff.ThirdPartyStaff;
import com.ezdml.erupt.ezdemo.researchmanagement.lab.Lab;
import com.ezdml.erupt.ezdemo.researchmanagement.link_project_institutions.link_project_institutions;
import com.ezdml.erupt.ezdemo.researchmanagement.link_project_staff.link_project_staff;
import com.ezdml.erupt.ezdemo.researchmanagement.place.Place;


/**
 * @author huz
 * date 44704
 */
@Configuration
@ComponentScan
@EntityScan
@EruptScan
@Component
public class EruptresearchmanagementAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptresearchmanagementAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt_study_management").build();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$ezresearchmanagement", "study_management", "fa fa-code", 40));
        

        menus.add(MetaMenu.createEruptClassMenu(Staff.class, menus.get(0), 1));
        
        menus.add(MetaMenu.createEruptClassMenu(Lab.class, menus.get(0), 2));

        menus.add(MetaMenu.createEruptClassMenu(Project.class, menus.get(0), 3));

        menus.add(MetaMenu.createEruptClassMenu(ThirdPartyInstitutions.class, menus.get(0), 4));

        menus.add(MetaMenu.createEruptClassMenu(ThirdPartyStaff.class, menus.get(0), 5));

        menus.add(MetaMenu.createEruptClassMenu(Place.class, menus.get(0), 6));

        menus.add(MetaMenu.createEruptClassMenu(link_project_staff.class, menus.get(0), 11));

        menus.add(MetaMenu.createEruptClassMenu(link_project_institutions.class, menus.get(0), 12));

        return menus;
    }
}
