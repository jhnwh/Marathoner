package com.zts.marathoner.controller;

import com.zts.marathoner.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping("/submitProcedure")
    public String submit(@RequestParam(value = "jobName") String jobName,
                         @RequestParam(value = "startDate") String startDate,
                         @RequestParam(value = "endDate") String endDate){
        return jobService.submit(jobName, startDate, endDate).getMsg();
    }
}
