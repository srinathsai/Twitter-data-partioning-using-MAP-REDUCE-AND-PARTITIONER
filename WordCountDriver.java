import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
public class WordCountDriver extends Configured implements Tool{
  @Override
  public int run(String[] args) throws Exception {

    Configuration configuration = getConf();

    Job job = Job.getInstance(configuration, "WordCountJob");

    job.setJarByClass(WordCountDriver.class);

    job.setMapperClass(WordCountMapper.class);// SETTING MAPPERCLASS

    job.setReducerClass(WordCountReducer.class);//SETTING REDUCERCLASS.

    job.setOutputKeyClass(Text.class); // TYPE OF KEY IS DECIDED.

    job.setOutputValueClass(IntWritable.class); // TYPE OF VALUE IS DECIDED.

    job.setPartitionerClass(WordCountPartitioner.class); //SETTING PARTITION CLASS.

    job.setNumReduceTasks(2);//GIVING 2 AS I AM PLANNING TO DO PARTITION ON 2 PARTS.

    FileInputFormat.setInputPaths(job, new Path(args[0]));

    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.waitForCompletion(true);
    return job.isSuccessful() ? 0 : 1;
  }
  public static void main(String[] args) throws Exception {

    int result = ToolRunner.run(new Configuration(), new WordCountDriver(), args);

    if(result==0){
      System.out.println("Job Completed successfully...");
    }
    else{
      System.out.println("Job Execution Failed with status::"+result);
    }

  }
}
