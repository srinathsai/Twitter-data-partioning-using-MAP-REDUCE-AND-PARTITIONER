# Twitter-data-partioning-using-MAP-REDUCE-AND-PARTITIONER
## Goal :- 
TO display count of every hastag only in tweet info associated with given keyword.<br />

## Methodology:-
**Mapper**:- this is the initial phase in the execution. In which every data node will be accessing data and every node will be having computation logic which was given by main.<br />
These data nodes process the data, format or split based on key,value pairs.What will be key or value will be decided by main or can also be decided by users.<br />
**Reducer** :- This is the last step in which key values obtained from mapper are combined here. The combination is also done in such a way that for each key all values in iterator mode are added and returned.<br />
## How is this implemented here:?-
We all know a famous problem that can be solved using map reduce is word count problem. Here in a file or folder word with their frequencies are given as output that are
occurring entirely all over.Aim of this part is to calculate total rows in a dataset.So the usual wordcount program can be developed to satisfy our aim . Instead of words we should make the mapper to take the whole json object or tweet row as a key. And the value for every json object associated with the key is 1. Because these objects are tweets and in a twitter data there cannot be repeated tweets. As tweets are non repeating, we can fix only value 1 with every tweet in mapper.<br />
Now in reducer, all these 1s are added and returns total count. These total count ensures total tweets in a folder as we are adding all 1s associated as values with key
rows.<br />

## Steps of execution :-
 1) First, set up your hadoop. <br />
 2) Next in partioner code change according to your keywords in quotes. <br />
 3) run commands according to your compiling environment. <br />
                      
## Conclusion :- 
Depending on number of keywords changed in the code that many partioned files will be created in which count of hashtags are generated.<br />
