package com.zts.marathoner.executor;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;

import java.util.List;


public interface Executor extends Runnable {

    StatusCode exec(String jobName, JobType jobType, List<String> param);

}
