import java.io.*;
import java.util.*;


// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times you showed an ad on each individual domain. Every line consists of a count and a domain name. It looks like this:




// Write a function that takes this input as a parameter and returns a data structure containing the number of hits that were recorded on each domain AND each domain under it. For example, an impression on "mail.yahoo.com" counts for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains.)

// Sample output (in any order):
// 1320    com
//  900    google.com
//  410    yahoo.com
//   60    mail.yahoo.com
//   10    mobile.sports.yahoo.com
//   50    sports.yahoo.com
//   10    stackoverflow.com
//    3    org
//    3    wikipedia.org
//    2    en.wikipedia.org
//    1    es.wikipedia.org
//    1    mobile.sports
//    1    sports


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {

    String[] counts = {
      "900,google.com",
      "60,mail.yahoo.com",
      "10,mobile.sports.yahoo.com",
      "40,sports.yahoo.com",
      "300,yahoo.com",
      "10,stackoverflow.com",
      "2,en.wikipedia.org",
      "1,es.wikipedia.org",
      "1,mobile.sports"
  };
      
    
    checkHits(counts); 

  }
  
  public static void checkHits(String[] counts)
  {
    Map<String, Integer> map = new HashMap<String, Integer>();
    Set<String> domains = new HashSet<String>();


    for(int i = 0; i < counts.length; i++)
    {
      String[] KeyValue;
      String[] subDomains;


      KeyValue = counts[i].split(",");



      subDomains = KeyValue[1].split("\\.");

      for(String s1: subDomains)
      {
        domains.add(s1);

        map.put(s1, 0);
      }





      int intValue = Integer.parseInt(KeyValue[0]);

      map.put(KeyValue[1], intValue);

    }

    for(String s1: domains) {
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        String key = entry.getKey();
        int value = entry.getValue();

        if(key.contains(s1))
        {
          map.put(s1, map.get(s1) + value);
        }

      }
    }


    for (Map.Entry<String, Integer> entry : map.entrySet())
    {
      String key = entry.getKey();
      int value = entry.getValue();



      System.out.println(value +  "\t" + key);
    }



  }
  
  
}

