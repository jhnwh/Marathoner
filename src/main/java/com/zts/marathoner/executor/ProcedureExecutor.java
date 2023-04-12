package com.zts.marathoner.executor;

import com.zts.marathoner.dict.JobType;
import com.zts.marathoner.entity.JobDefine;
import com.zts.marathoner.entity.Relation;
import com.zts.marathoner.mapper.JobDefineMapper;
import com.zts.marathoner.mapper.JobRelationMapper;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class ProcedureExecutor implements Executor{

    final JobDefineMapper jobMapper;
    final JobRelationMapper jobRelationMapper;

    @Autowired
    public ProcedureExecutor(JobDefineMapper jobMapper, JobRelationMapper jobRelationMapper) {
        this.jobMapper = jobMapper;
        this.jobRelationMapper = jobRelationMapper;
    }

    @Override
    public int exec(String jobName, JobType jobType, List<String> param) {
        List<JobDefine> jobs = jobMapper.selectList(null);
        List<Relation> relations = jobRelationMapper.selectList(null);
        Dependency dependency = new Dependency(jobs, relations);
        DirectedAcyclicGraph<String, DefaultEdge> dag = dependency.getDag();
        Set<String> ancestors = dag.getAncestors(jobName);
        return 0;
    }
}
