package com.example.mobile.service;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NumberServiceImpl {
    public List<String> getAllProbableNumber(String number){

        List<String> resultNumber = new ArrayList<>();
        Map<Character,List<String>> keyPadNumbers = new HashMap<>();{
            keyPadNumbers.put('1', Arrays.asList(" "));
            keyPadNumbers.put('2', Arrays.asList("a","b","c"));
            keyPadNumbers.put('3', Arrays.asList("d","e","f"));
            keyPadNumbers.put('4', Arrays.asList("g","h","i"));
            keyPadNumbers.put('5', Arrays.asList("j","k","l"));
            keyPadNumbers.put('6', Arrays.asList("m","n","o"));
            keyPadNumbers.put('7', Arrays.asList("p","q","r","s"));
            keyPadNumbers.put('8', Arrays.asList("t","u","v"));
            keyPadNumbers.put('9', Arrays.asList("w","x","y","z"));
            keyPadNumbers.put('0', Arrays.asList(" "));
        }
        List<String> chars = keyPadNumbers.get(number.charAt(number.length()-1));
        chars.forEach(chars1->{
            StringBuffer sb = new StringBuffer(number);
            sb.setCharAt(sb.length()-1,chars1.charAt(0));
            resultNumber.add(sb.toString());
        });
        return resultNumber;
    }

}
