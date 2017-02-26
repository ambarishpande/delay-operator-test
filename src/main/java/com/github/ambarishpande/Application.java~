/**
 * Put your copyright and license info here.
 */
package com.github.ambarishpande;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.Context;
import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.DAG;
import com.datatorrent.api.DAG.Locality;
import com.datatorrent.common.partitioner.StatelessPartitioner;
import com.datatorrent.common.util.DefaultDelayOperator;

@ApplicationAnnotation(name="DelayTest")
public class Application implements StreamingApplication
{

  @Override
  public void populateDAG(DAG dag, Configuration conf)
  {
    // Sample DAG with 2 operators
    // Replace this code with the DAG you want to build


    int numOfPartitions = 2;
    RandomNumberGenerator randomGenerator = dag.addOperator("randomGenerator", RandomNumberGenerator.class);
    SpliterOperator split = dag.addOperator("Spliter",SpliterOperator.class);
    PassThroughOperator pass = dag.addOperator("Pass Through",PassThroughOperator.class);
    LoopBackOperator loop = dag.addOperator("Loop Back",LoopBackOperator.class);
    DefaultDelayOperator delay = dag.addOperator("Delay",DefaultDelayOperator.class);

    randomGenerator.setNumTuples(500);


    dag.setOperatorAttribute(pass, Context.OperatorContext.PARTITIONER, new StatelessPartitioner<PassThroughOperator>(numOfPartitions));

    dag.addStream("Random Data",randomGenerator.out,split.in);
    dag.addStream("Forward",split.out,pass.in);
    dag.addStream("To Pass2",pass.out,loop.in);
    dag.addStream("To Delay",loop.out,delay.input);
    dag.addStream("From Delay",delay.output,split.in2);



  }
}
