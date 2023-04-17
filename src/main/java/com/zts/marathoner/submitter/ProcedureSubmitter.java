package com.zts.marathoner.submitter;

import com.zts.marathoner.checker.ProcedureChecker;
import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.dict.StatusCode;
import com.zts.marathoner.executor.Dependency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Component
public class ProcedureSubmitter implements Submitter{

    private final ProcedureChecker checker;
    private final Dependency dependency;
    static HashMap<String, List<String>> executeQueue = new HashMap<>();

    public ProcedureSubmitter(ProcedureChecker checker, Dependency dependency){
        this.checker = checker;
        this.dependency = dependency;
    }

    public Dependency getDependency() {
        return dependency;
    }

    @Override
    public StatusCode submit(String jobName, List<String> param, boolean isSkipCheck){
        //检查任务上游任务完整性
        StatusCode checkResult = StatusCode.SUCCESS;
        if (!isSkipCheck) {
            checkResult = this.checker.check(jobName, JobType.PRO, param);
        }
        if (checkResult == StatusCode.SUCCESS) {
            //判断任务上游任务是否正在执行
            boolean isAncestorsRunning = false;
            Set<String> ancestors = dependency.getAncestors(jobName);
            for (String ancestor : ancestors) {
                isAncestorsRunning = isAncestorsRunning || executeQueue.containsKey(ancestor);
            }
            if (isAncestorsRunning) {
                return StatusCode.ANCESTORS_IS_RUNNING;
            } else {
                executeQueue.put(jobName, param);
                return StatusCode.SUCCESS;
            }
        } else {
            return checkResult;
        }
    }
}
