/**
 * 
 */
package org.github.taktos.jeebatch.firstjob;

import javax.batch.api.chunk.ItemProcessor;
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
public class CustomerLineProcessor implements ItemProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerLineProcessor.class);

    @Inject private JobContext jobContext;

    @Override
    public Object processItem(final Object item) throws Exception {
        final Integer count = (Integer) item;
        LOG.info("IN:{}", count);
        return count * 10;
    }

}
