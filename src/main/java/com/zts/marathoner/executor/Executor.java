package com.zts.marathoner.executor;

import com.zts.marathoner.dict.JobType;

import java.util.List;


public interface Executor {

    int exec(String jobName, JobType jobType, List<String> param);

}
