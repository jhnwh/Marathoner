package com.zts.marathoner.checker;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;

import java.util.List;


public interface Checker {

    StatusCode check(String jobName, JobType jobType, List<String> param);
}
