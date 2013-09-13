/**
 * 
 */
package org.github.taktos.jeebatch.firstjob;

import javax.batch.api.listener.AbstractJobListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author taktos
 * 
 */
@Dependent
@Named
public class CompleteListener extends AbstractJobListener {
    private static final Logger LOG = LoggerFactory.getLogger(CompleteListener.class);
    @Inject private JobContext jobContext;

    @Override
    public void afterJob() throws Exception {
        final long executionId = this.jobContext.getExecutionId();
        LOG.info("afterJob:{}", executionId);
    }

}
