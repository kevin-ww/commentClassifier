package batch;

import java.util.Random;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/simple-job-launcher-context.xml",
//    "/jobs/partitionFileJob.xml", "/job-runner-context.xml" })
public class PartitionFunctionalTests implements ApplicationContextAware {

  @Autowired
  // private JobLauncherTestUtils jobLauncherTestUtils;
  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Test
  public void testPartitionExecution() throws Exception {

    final String jobConfigXml = "/jobs/partitionFileJob.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(jobConfigXml);

    SimpleJobLauncher jobLuncher = (SimpleJobLauncher) ctx
        .getBean("jobLauncher");

    Job job = (Job) ctx.getBean("partitionJob");

    JobParametersBuilder jpb = new JobParametersBuilder();

    // jpb.addString("input_file_pattern",
    // "classpath:data/iosample/input/delimited*.csv");

    Random random = new Random();

    jpb.addString("random", random.toString());

    JobExecution jobExecution = jobLuncher.run(job, jpb.toJobParameters());
    // JobExecution jobExecution = jobLauncherTestUtils.launchJob();
    // assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    System.out.println(jobExecution.getStatus());
  }

}
