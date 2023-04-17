package com.zts.marathoner.executor;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;
import com.zts.marathoner.submitter.ProcedureSubmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProcedureExecutor implements Executor{

    private final ProcedureSubmitter procedureSubmitter;

    @Autowired
    public ProcedureExecutor(ProcedureSubmitter procedureSubmitter) {
        this.procedureSubmitter = procedureSubmitter;
    }

    @Override
    public StatusCode exec(String jobName, JobType jobType, List<String> param) {
        return StatusCode.SUCCESS;
    }

    @Override
    public void run() {
        Dependency dependency = procedureSubmitter.getDependency();
        synchronized (dependency){

        }
    }
}
