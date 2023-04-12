package com.zts.marathoner.checker;

import com.zts.marathoner.dict.JobType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcedureChecker implements Checker{
    @Override
    public int check(String jobName, JobType jobType, List<String> param) {
        return 0;
    }
}
