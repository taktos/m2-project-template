/**
 * 
 */
package org.github.taktos.jeebatch.firstjob;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author taktos
 * 
 */
@Dependent
@Named
public class CustomerLineWriter extends AbstractItemWriter {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerLineWriter.class);

    @Override
    public void writeItems(final List<Object> items) throws Exception {
        LOG.info("ItemWriter#writeItems({})", items);
    }

}
