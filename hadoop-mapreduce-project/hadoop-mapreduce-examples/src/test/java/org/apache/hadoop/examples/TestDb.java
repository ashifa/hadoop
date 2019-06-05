package org.apache.hadoop.examples;

import org.apache.hadoop.util.ToolRunner;
import org.junit.Test;


public class TestDb {

    @Test
    public void testDb() throws Exception {
        int ret = ToolRunner.run(new DBCountPageView(), new String[0]);
        System.exit(ret);

    }

}
