package org.apache.hadoop.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.util.ToolRunner;
import org.junit.Test;

import java.io.IOException;

public class TestRandomText {

    @Test
    public void testRandom() throws Exception {

        FileSystem fs = FileSystem.get(new Configuration());
        fs.delete(new Path("/input"),true);


        String[] args = {"/input"};

        int res = ToolRunner.run(new Configuration(), new RandomTextWriter(), args);



        System.exit(res);
    }

    @Test
    public void listOutput() throws IOException {
        FileSystem fs = FileSystem.get(new Configuration());


        final RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/input"), true);

        while (iterator.hasNext()) {
            LocatedFileStatus next = iterator.next();
            System.out.println(next);

            fs.copyToLocalFile(next.getPath(), new Path("/tmp/"));

        }
    }
}
