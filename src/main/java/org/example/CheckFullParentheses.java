package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class CheckFullParentheses {

    private final char left = '(';

    private final char right = ')';

    int lastRightParentheses;



    public String checkFullParentheses(String str) {
        if (!str.isEmpty()) {
            List<Character> characterList = str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
            lastRightParentheses = characterList.lastIndexOf(right);
            int firstLeftParentheses = characterList.indexOf(left);
            if (firstLeftParentheses < lastRightParentheses && characterList.contains(left)) {
                characterList = characterList.subList(
                        firstLeftParentheses,
                        lastRightParentheses + 1);
            } else
                return "0";
            return foundFullParentheses(characterList);
        }
        return "Should not be empty";
    }

    private String foundFullParentheses(List<Character> characterList) {
        List<Character> parenthesesList = new LinkedList<>();
        int level = 0;
        List<Character> characterList2 = new LinkedList<>(characterList);
        for (int i = 0; i < characterList.size(); i++) {
            int lastRightIndex2 = characterList2.lastIndexOf(right);
            if (characterList.get(i).equals(left) && i < lastRightParentheses) {
                if (lastRightIndex2 > 0) {
                    parenthesesList.add(parenthesesList.size() - level, left);
                    parenthesesList.add(parenthesesList.size() - level, right);
                    level++;
                    characterList2.remove(lastRightIndex2);
                }
            }
            boolean isEqualsRight = characterList.get(i).equals(right);
            if (isEqualsRight && level == 0){
                characterList2.remove(lastRightIndex2);
            }
            if (isEqualsRight && level > 0) {
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

