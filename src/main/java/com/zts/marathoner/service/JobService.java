package com.zts.marathoner.service;


import com.zts.marathoner.dict.StatusCode;

import java.util.List;

public interface JobService {

    StatusCode submit(String jobName, List<String> param);

    List<String> getSingleWorkDateParam(String startDate, String endDate);
}
