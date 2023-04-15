package com.zts.marathoner.service;

import com.zts.marathoner.dict.StatusCode;
import com.zts.marathoner.entity.BusinessDate;
import com.zts.marathoner.mapper.BusinessDateMapper;
import com.zts.marathoner.submitter.ProcedureSubmitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    ProcedureSubmitter submitter;

    BusinessDateMapper businessDateMapper;

    public JobServiceImpl(ProcedureSubmitter submitter, BusinessDateMapper businessDateMapper) {
        this.submitter = submitter;
        this.businessDateMapper = businessDateMapper;
    }

    public StatusCode submit(String jobName, List<String> param) {

        return submitter.submit(jobName, param, false);
    }

    @Override
    public List<String> getSingleWorkDateParam(String startDate, String endDate) {
        List<BusinessDate> businessDates = businessDateMapper.queryBusinessDateByStartAndEnd(startDate, endDate);
        return businessDates.stream().map(BusinessDate::getFdate).toList();
    }
}
