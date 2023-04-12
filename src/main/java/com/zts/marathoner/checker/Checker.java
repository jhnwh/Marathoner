package com.zts.marathoner.checker;

import com.zts.marathoner.dict.JobType;

import java.util.List;


public interface Checker {

    int check(String jobName, JobType jobType, List<String> param);
}
