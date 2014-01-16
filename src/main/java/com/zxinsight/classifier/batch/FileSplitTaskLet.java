package com.zxinsight.classifier.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

/**
 * split this file into multi-smaller ones by size or line , ref to split
 * ,linux;
 * 
 */
public class FileSplitTaskLet implements Tasklet, InitializingBean {

  private Resource originalFile;

  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public RepeatStatus execute(StepContribution contribution,
      ChunkContext chunkContext) throws Exception {
    // TODO Auto-generated method stub

    return null;
  }

}
