package src.rake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class WordDict implements Iterable<String>{

    HashMap<String, Integer>  frequencyDict = new HashMap<>();
    public int size(){
        return frequencyDict.size();
    }
    public Iterator<String> iterator(){
        return frequencyDict.keySet().iterator();
    }
    public void add(String word){
        if (frequencyDict.putIfAbsent(word, 1) != null)
            frequencyDict.replace(word, frequencyDict.get(word) + 1);
    }
    public void add(String word, Integer val){
        if (frequencyDict.putIfAbsent(word, val) != null)
            frequencyDict.replace(word, frequencyDict.get(word) + val);
    }
    public void addDict(WordDict wordDict){
        for (String word: wordDict)
            add(word, wordDict.getFrequency(word));
    }
    public Integer getFrequency(String word){
        return frequencyDict.get(word);
    }


}
