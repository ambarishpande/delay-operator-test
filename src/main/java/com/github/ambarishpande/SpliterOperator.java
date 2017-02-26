package com.github.ambarishpande;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.DefaultOutputPort;
import com.datatorrent.common.util.BaseOperator;

/**
 * Created by hadoopuser on 26/2/17.
 */
public class SpliterOperator extends BaseOperator
{
  public final transient DefaultInputPort<Double> in = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double aDouble)
    {
      out.emit(aDouble);
    }
  };

  public final transient DefaultOutputPort<Double> out = new DefaultOutputPort<Double>();

  public final transient DefaultInputPort<Double> in2 = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double aDouble)
    {
      out.emit(aDouble);
    }
  };

}
