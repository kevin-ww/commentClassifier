import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args)
      throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

//    final String jobConfigXml = "test/product_review_classifier_job.xml";
//
//    JobParametersBuilder jpBuilder = new JobParametersBuilder();
//
//    jpBuilder.addString("input_file_name", "product_review_short.csv");
//
//    // jpBuilder.addString("output_file_name",
//    // "file:target/test-outputs/output_1.txt");
//
//    ApplicationContext ctx = new ClassPathXmlApplicationContext(jobConfigXml);
//
//    SimpleJobLauncher jobLuncher = (SimpleJobLauncher) ctx
//        .getBean("jobLauncher");
//
//    Job job = (Job) ctx.getBean("simpleJob");
//
//    jobLuncher.run(job, jpBuilder.toJobParameters());

  }

}
