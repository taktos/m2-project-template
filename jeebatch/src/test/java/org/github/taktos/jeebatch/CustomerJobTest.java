package org.github.taktos.jeebatch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;

import org.github.taktos.jeebatch.firstjob.CompleteListener;
import org.github.taktos.jeebatch.firstjob.CustomerLineProcessor;
import org.github.taktos.jeebatch.firstjob.CustomerLineReader;
import org.github.taktos.jeebatch.firstjob.CustomerLineWriter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class CustomerJobTest {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerJobTest.class);

    @Deployment
    public static JavaArchive createDeployment() {
        final JavaArchive jar = ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(CustomerLineReader.class, CustomerLineProcessor.class, CustomerLineWriter.class,
                        CompleteListener.class)
                .addAsResource("META-INF/batch-jobs/firstjob.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        LOG.info(jar.toString(true));
        return jar;
    }

    @Test
    public void test() {
        LOG.info("test(); START");
        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        LOG.info("{}", jobOperator.getJobNames());
        final long executionId = jobOperator.start("firstjob", null);
        LOG.info("JOB STARTED:{}", executionId);
        final JobExecution exec = jobOperator.getJobExecution(executionId);
        while (exec.getEndTime() == null) {
            try {
                LOG.info("JOB IS {}. WAIT...", exec.getBatchStatus());
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                LOG.info("INTERUPTED");
            }
        }
        LOG.info("{} {}", exec.getBatchStatus(), exec.getExitStatus());
    }

}
