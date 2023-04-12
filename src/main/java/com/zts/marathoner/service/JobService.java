package com.zts.marathoner.service;


import com.zts.marathoner.dict.StatusCode;

public interface JobService {

    StatusCode submit(String jobName, String startDate, String endDate);
}
