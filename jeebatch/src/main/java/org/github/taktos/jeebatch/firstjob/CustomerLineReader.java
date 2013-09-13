/**
 * 
 */
package org.github.taktos.jeebatch.firstjob;

import java.io.Serializable;

import javax.batch.api.chunk.AbstractItemReader;
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
public class CustomerLineReader extends AbstractItemReader {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerLineReader.class);

    @Inject private JobContext jobContext;

    private transient int count = 0;

    @Override
    public void open(final Serializable checkpoint) throws Exception {
        LOG.info("ItemReader#open({})", checkpoint);
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        LOG.info("ItemReader#checkpointInfo()");
        return this.count;
    }

    @Override
    public Object readItem() throws Exception {
        if (this.count < 100) {
            return this.count++;
        }
        return null;
    }

}
