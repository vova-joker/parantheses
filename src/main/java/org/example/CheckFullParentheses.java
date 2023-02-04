package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class CheckFullParentheses {

    private List<Character> parenthesesList;
    private final char left = '(';

    private final char right = ')';

    private List<Character> characterList2;


    public String checkFullParentheses(String str) {
        if (!str.isEmpty()) {
            List<Character> characterList = str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
//            System.out.println(characterList.indexOf(left) + " " + characterList.lastIndexOf(right));
            if (characterList.indexOf(left) < characterList.lastIndexOf(right)) {
                characterList = characterList.subList(
                        characterList.indexOf(left),
                        characterList.lastIndexOf(right) + 1);
            } else
                return "0";
            characterList2 = new LinkedList<>(characterList);
            String fullParentheses = foundFullParentheses(characterList);
//            System.out.println(characterList);
            return fullParentheses;
        }
        return "Should not be empty";
    }

    private String foundFullParentheses(List<Character> characterList) {
        parenthesesList = new LinkedList<>();
        int level = 0;
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).equals(left) && i < characterList.lastIndexOf(right)) {
                int lastRightIndex = characterList2.lastIndexOf(right);
                if (lastRightIndex > 0) {
                    parenthesesList.add(parenthesesList.size() - level, left);
                    parenthesesList.add(parenthesesList.size() - level, right);
                    level++;
                    characterList2.remove(lastRightIndex);
//                    System.out.println(lastRightIndex);
                }
//                if (lastRightIndex > 0 && (i > lastRightIndex || parenthesesList.isEmpty())) {
//                    parenthesesList.add(left);
//                    parenthesesList.add(right);
//                    characterList2.remove(lastRightIndex);
//                    System.out.println(lastRightIndex);
//                }
            }
            if (characterList.get(i).equals(right) && level > 0) {
                level--;
            }
        }

//        System.out.println("Full " + parenthesesList.size() + " - " + parenthesesList);
        return parenthesesList.size() + " - " + parenthesesListToString(parenthesesList);
    }

    private String parenthesesListToString(List<Character> parenthesesList){
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character: parenthesesList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}

