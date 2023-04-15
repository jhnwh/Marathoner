package com.zts.marathoner.checker;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcedureChecker implements Checker{
    @Override
    public StatusCode check(String jobName, JobType jobType, List<String> param) {
        return StatusCode.SUCCESS;
    }
}
