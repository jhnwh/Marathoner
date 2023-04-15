package com.zts.marathoner.executor;

import com.zts.marathoner.entity.JobDefine;
import com.zts.marathoner.entity.Relation;
import com.zts.marathoner.mapper.JobDefineMapper;
import com.zts.marathoner.mapper.JobRelationMapper;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Dependency {

    DirectedAcyclicGraph<String, DefaultEdge> dag;


    Dependency(JobDefineMapper jobDefineMapper, JobRelationMapper jobRelationMapper){
        List<JobDefine> jobDefines = jobDefineMapper.selectList(null);
        List<Relation> relations = jobRelationMapper.selectList(null);
        this.dag = new DirectedAcyclicGraph<>(DefaultEdge.class);
        for (JobDefine jobDefine : jobDefines) {
            this.dag.addVertex(jobDefine.getJobName().trim().toLowerCase());
        }
        for (Relation relation : relations) {
            this.dag.addEdge(relation.getPetlName().trim().toLowerCase(),
                    relation.getEtlName().trim().toLowerCase());
        }
    }

    public DirectedAcyclicGraph<String, DefaultEdge> getDag() {
        return dag;
    }

    public Set<String> getAncestors(String jobName){
        return isDagContainVertex(jobName) ? this.dag.getAncestors(jobName.trim().toLowerCase()) : null;
    }

    public Set<DefaultEdge> getFathers(String jobName){
        return isDagContainVertex(jobName) ? this.dag.incomingEdgesOf(jobName.trim().toLowerCase()) : null;
    }

    public Set<DefaultEdge> getChildren(String jobName){
        return isDagContainVertex(jobName) ? this.dag.outgoingEdgesOf(jobName.trim().toLowerCase()) : null;
    }

    private boolean isDagContainVertex(String jobName) {
        return !"".equals(jobName) && this.dag.containsVertex(jobName.trim().toLowerCase());
    }
}
