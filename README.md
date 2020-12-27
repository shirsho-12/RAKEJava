# RAKEJava
A Java15 Implementation of the Rapid Automatic Keyword Extraction Framework ( RAKE ) for keyword extraction. This is a completely self-contained implementation not using any external models such as the Illinois POS tagger.

The Rapid Automatic Keyword Extraction (RAKE) algorithm is as described in: Rose, S., Engel, D., Cramer, N., & Cowley, W. (2010). Automatic Keyword Extraction from Individual Documents. In M. W. Berry & J. Kogan (Eds.), Text Mining: Theory and Applications: John Wiley & Sons.

The implementation follows from https://github.com/aneesha/RAKE 's Python3 model. The source code is released under the MIT License.

## Example code

```
import src.rake;

public void run(){
  // make new model object
  RakeModel model = new RakeModel();
  
  // configurable options directly accessible from model object
  model.minKeywordFrequency = 2;   // Setting minimum number of times keyword has to appear in text to 2 (default 1)
  // Uses the Jsoup library to extract all paragraph text from Wikipedia's entry on Cheese
  String text = Jsoup.connect("https://www.wikipedia.org/wiki/Cheese")..getElementsByTag("p").text();
  // Get a reverse-sorted array (in order of decreasing scores) of keywords 
  ArrayList<String> keywords = model.run(text);  
  int i = 0;
  // Get top 10 results
  for (String keyword: keywords) {
      System.out.println(keyword + ": " + model.candidateScores.get(keyword));
      i++;
      if (i >= 10) break;
  }
}

```
