package com.zts.marathoner.submitter;

import com.zts.marathoner.checker.ProcedureChecker;
import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;
import com.zts.marathoner.executor.ProcedureExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcedureSubmitter implements Submitter{

    private String jobName;

    private JobType jobType;

    private List<String> param;
    private ProcedureChecker checker;
    private ProcedureExecutor executor;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public ProcedureSubmitter(ProcedureChecker checker, ProcedureExecutor executor){
        this.checker = checker;
        this.executor = executor;
    }

    public StatusCode submit(){
        int checkResult = this.checker.check(this.jobName, this.jobType, this.param);
        if (checkResult == 0) {
            int exec = this.executor.exec(this.jobName, this.jobType, this.param);
            if (exec == 0) {
                return StatusCode.SUCCESS;
            } else {
                return StatusCode.getObjectByCode(checkResult);
            }
        } else {
            return StatusCode.getObjectByCode(checkResult);
        }
    }
}
