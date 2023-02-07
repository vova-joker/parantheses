package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class CheckFullParentheses {

    private final char left = '(';

    private final char right = ')';

    private List<Character> characterList2;


    public String checkFullParentheses(String str) {
        if (!str.isEmpty()) {
            List<Character> characterList = str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
            if (characterList.indexOf(left) < characterList.lastIndexOf(right) && characterList.indexOf(left) >= 0) {
                characterList = characterList.subList(
                        characterList.indexOf(left),
                        characterList.lastIndexOf(right) + 1);
            } else
                return "0";
            return foundFullParentheses(characterList);
        }
        return "Should not be empty";
    }

    private String foundFullParentheses(List<Character> characterList) {
        List<Character> parenthesesList = new LinkedList<>();
        int level = 0;
        characterList2 = new LinkedList<>(characterList);
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).equals(left) && i < characterList.lastIndexOf(right)) {
                int lastRightIndex = characterList2.lastIndexOf(right);
                if (lastRightIndex > 0) {
                    parenthesesList.add(parenthesesList.size() - level, left);
                    parenthesesList.add(parenthesesList.size() - level, right);
                    level++;
                    characterList2.remove(characterList2.lastIndexOf(right));
                }
            }
            if (characterList.get(i).equals(right) && level == 0){
                characterList2.remove(characterList2.indexOf(right));
            }
            if (characterList.get(i).equals(right) && level > 0) {
                level--;
            }

        }
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

