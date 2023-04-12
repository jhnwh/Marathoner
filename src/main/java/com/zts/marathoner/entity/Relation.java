package com.zts.marathoner.entity;

import com.baomidou.mybatisplus.annotation.TableName;


@TableName(value = "t_edw_dsjobrelation_test", schema = "edwuser")
public class Relation {
    String petlName;

    String etlName;

    public String getPetlName() {
        return petlName;
    }

    public void setPetlName(String petlName) {
        this.petlName = petlName;
    }

    public String getEtlName() {
        return etlName;
    }

    public void setEtlName(String etlName) {
        this.etlName = etlName;
    }
}