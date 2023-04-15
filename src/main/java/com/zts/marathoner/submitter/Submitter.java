package com.zts.marathoner.submitter;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;

import java.util.List;

public interface Submitter {

    StatusCode submit(String jobName, List<String> param, boolean isSkipCheck);
}
