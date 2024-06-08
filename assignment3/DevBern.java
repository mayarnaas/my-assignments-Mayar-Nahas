/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.devbern;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Stack;
import java.util.Comparator;

/**
 *
 * @author mayar
 */
public class DevBern {

    public static void main(String[] args) {
        
        
        
        //task 1 true counter
       ArrayList<Boolean> boolList = new ArrayList<>();
        boolList.add(true);
        boolList.add(false);
        boolList.add(false);
        boolList.add(true);
        boolList.add(false);

        int trueCount = countTrue(boolList);
        System.out.println("Number of true values: " + trueCount);
        
        
        
        //task 2 
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        ArrayList<Object[]> array = toArray(map);
        System.out.println(array);
        
        
        //task 3 lucky number
        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        System.out.println(luckyNumber(numbers1)); // LUCKY!

        ArrayList<Integer> numbers2 = new ArrayList<>(List.of(8, 6, 33, 100));
        System.out.println(luckyNumber(numbers2)); // There is no 7 in the array.

        ArrayList<Integer> numbers3 = new ArrayList<>(List.of(2, 55, 60, 97, 86));
        System.out.println(luckyNumber(numbers3)); // LUCKY!
        
        //task 4 oddishOrEvenish
          System.out.println(oddishOrEvenish(121)); // Evenish
          System.out.println(oddishOrEvenish(41));  // Oddish
          
        //task 5 reverseOdd
        System.out.println(reverseOdd("Bananas")); // sananaB
        System.out.println(reverseOdd("One two three four")); // enO owt eerht four
        System.out.println(reverseOdd("Make sure uoy only esrever sdrow of ddo length")); // Make sure you only reverse words of odd length
        
        //task 6 hashtags
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        // [#avocado, #became, #global]

        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        // [#christmas, #probably, #will]

        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        // [#surprise, #parents, #fruit]

        System.out.println(getHashTags("Visualizing Science"));
        // [#visualizing, #science]
    
    }

    
    //task 1 function using arrayList
    public static int countTrue(ArrayList<Boolean> boolList) {
        int count = 0;
        for (boolean value : boolList) {
            if (value) {
                count++;
            }
        }
        return count;
    }
    
    
    
    //task 2 function using hashmap
      public static ArrayList<Object[]> toArray(HashMap<String, Integer> map) {
        ArrayList<Object[]> array = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Object[] pair = new Object[]{entry.getKey(), entry.getValue()};
            array.add(pair);
        }
        return array;
    }
      
      
      //task 3 lucky 
      public static String luckyNumber(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            if (num == 7 || containsSeven(num)) {
                return "LUCKY!";
            }
        }
        return "there is no 7 in the array.";
    }

    public static boolean containsSeven(int number) {
        return String.valueOf(number).contains("7");
    }
    
    
    
    //task 4 oddishOrEvenish function
     public static String oddishOrEvenish(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return (sum % 2 == 0) ? "Evenish" : "Oddish";
    }
     
     
     //task 5 reverseOdd using stack
     
      public static String reverseOdd(String str) {
        String[] words = str.split(" ");
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() % 2 == 1) {
                stack.push(reverseString(word));
            } else {
                stack.push(word);
            }
        }

        while (!stack.empty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    
    
    //task 6 hastags 
    public static List<String> getHashTags(String headline) {
        String[] words = headline.split(" ");
        List<String> hashtags = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
        }

        List<String> sortedWords = new ArrayList<>(List.of(words));
        sortedWords.sort(Comparator.comparingInt(String::length).reversed());

        int count = Math.min(3, sortedWords.size());
        for (int i = 0; i < count; i++) {
            hashtags.add("#" + sortedWords.get(i));
        }

        return hashtags;
    }
}