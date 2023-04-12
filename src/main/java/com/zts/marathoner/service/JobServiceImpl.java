package com.zts.marathoner.service;

import com.zts.marathoner.dict.StatusCode;
import com.zts.marathoner.submitter.ProcedureSubmitter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JobServiceImpl implements JobService {

    ProcedureSubmitter submitter;

    public JobServiceImpl(ProcedureSubmitter submitter) {
        this.submitter = submitter;
    }

    public StatusCode submit(String jobName, String startDate, String endDate) {
        submitter.setJobName(jobName);
        submitter.setParam(new ArrayList<>());
        return submitter.submit();
    }
}
