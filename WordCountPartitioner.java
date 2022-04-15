import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner < Text, IntWritable> {
  @Override
  public int getPartition(Text key,IntWritable value, int numReduceTasks)
  {

          String str = key.toString();

          if ( str.contains("Anime") || str.contains("anime"))         //PARTITIONING INTO TWO FILES BASED ON KEYWORDS WITHOUT CASE SENSITIVE.
                          return 0;

          if (str.contains("Cricket") || str.contains("cricket"))     //ALL TWEETS WITH KEYWORDS ANIME ARE STORED IN FILE ARE STORED IN 00000.
                        return 1;                                    //ALL TWEETS WITH KEYWORDS CRICKET ARE STORED IN FILE ARE STORED IN 00001

                return 0;


      }
   }
