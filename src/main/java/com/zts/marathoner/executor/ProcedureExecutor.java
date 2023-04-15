package com.zts.marathoner.executor;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProcedureExecutor implements Executor{


    @Override
    public StatusCode exec(String jobName, JobType jobType, List<String> param) {
        return StatusCode.SUCCESS;
    }

    @Override
    public void run() {

    }
}
