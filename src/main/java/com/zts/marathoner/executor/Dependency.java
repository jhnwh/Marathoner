package com.zts.marathoner.executor;

import com.zts.marathoner.entity.JobDefine;
import com.zts.marathoner.entity.Relation;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;

import java.util.List;

public class Dependency {

    DirectedAcyclicGraph<String, DefaultEdge> dag;


    Dependency(List<JobDefine> jobDefines, List<Relation> relations){
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
}
