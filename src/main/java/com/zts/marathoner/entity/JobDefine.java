package com.zts.marathoner.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Objects;

@TableName(value = "t_edw_job_define_test", schema = "edwuser")
public class JobDefine {
    @TableId
    String jobName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDefine jobDefine = (JobDefine) o;
        return jobName.equals(jobDefine.jobName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobName);
    }
}
