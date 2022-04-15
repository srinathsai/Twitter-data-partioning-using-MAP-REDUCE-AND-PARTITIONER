import java.util.*;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class WordCountMapper extends Mapper<Object,Text,Text,IntWritable>
{

  private static final IntWritable countOne = new IntWritable(1);

  private Text word = new Text();

  public void map(Object key, Text value, Context context) throws IOException,InterruptedException
  { List<String>cricketHashtags=new ArrayList<>();
    List<String>animeHashtags=new ArrayList<>();
    String [] words = value.toString().split(":");//EACH JASON FILE IS SPLITTED BASED ON : AND STORED IN WORDS ARRAY.
    String requiredword="";
    for(int i=0;i<words.length;i++){
        String eachpart=words[i];             //TAKING EACHWORD
        String[]cache=eachpart.split(",");    //AND SPLITING BASED ON , BECAUSE TEXT TAG IN JSON WILL BE GETTING HUGE NUMBER, TEXT AFTER SPLITTING BASED ON :.
        if(cache.length==2){
            if(cache[1].equals("\"text\"")){
                    requiredword=words[i+1];//IF AFTER SPLITING WITH , HAS 2 IN SIZE ONLY CHECKING SECOND PLACE IS "text" .IF YES TAKING WHOLE TWEET CONTENT IN A STRING.
                    break;
                }
            }
        }


    String[] content=requiredword.split(" ");// SPLITING TWEET CONTENT BASED ON GAPS.
    for(int i=0;i<content.length;i++){
        if(!content[i].equals("")){
         if(content[i].charAt(0)=='#'&& (requiredword.contains("cricket")||requiredword.contains("Cricket"))){
           cricketHashtags.add(content[i]+" " +"cricket");//ITERATING THE TWEET CONTENT IN SPLITTED ARRAY AND CHECKING IF IT HAS INTIALLY # AND OUR KEYWORDS THEN CALLING CONTEXT IMMEDIATELY.
           word.set(content[i]+" " +"cricket");
           context.write(word,countOne);
         }
         else if(content[i].charAt(0)=='#' && (requiredword.contains("anime")||requiredword.contains("Anime"))){
          animeHashtags.add(content[i]+" " +"anime");
          word.set(content[i] + " " +"anime");
          context.write(word,countOne);

        }

    }
    }
  }
}
   /* for(String string : cricketHashtags)
    {
      String word1=string ;
      word.set(word1);

      context.write(word, countOne);

    }
    for(String string : animeHashtags){
     String word2= string;
     word.set(word2);
     context.write(word,countOne);
  }
}
}*/
