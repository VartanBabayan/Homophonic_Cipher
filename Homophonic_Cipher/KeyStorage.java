package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KeyStorage {
    /**
     * alphabet of values for encoding
     */
    public ArrayList<Character> values;

    /**
     * map where for each letter own and unique array of alphabet
     */
    public HashMap<Character, ArrayList<Character>> dictionary;

    public KeyStorage() {
        values = new ArrayList<Character>(
                Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c',
                        'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                        't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '@', '\\', '#', '№', '$', ';', '%', '^',
                        ':', '&', '?', '(', ')', '-', '_', '+', '=', '`', '~', '[', ']', '{',
                        '}', '.', ',', '/', '|', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L',
                        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '<',
                        '>', 'А', 'М', 'В', 'С', 'у', 'Е', 'Т', 'а', 'Х', 'З', '*')
        );

        dictionary = new HashMap<Character, ArrayList<Character>>();
        dictionary.put('A', new ArrayList<Character>(values.subList(0, 8)));
        dictionary.put('B', new ArrayList<Character>(values.subList(8, 10)));
        dictionary.put('C', new ArrayList<Character>(values.subList(10, 13)));
        dictionary.put('D', new ArrayList<Character>(values.subList(13, 17)));
        dictionary.put('E', new ArrayList<Character>(values.subList(17, 29)));
        dictionary.put('F', new ArrayList<Character>(values.subList(29, 31)));
        dictionary.put('G', new ArrayList<Character>(values.subList(31, 33)));
        dictionary.put('H', new ArrayList<Character>(values.subList(33, 39)));
        dictionary.put('I', new ArrayList<Character>(values.subList(39, 45)));
        dictionary.put('J', new ArrayList<Character>(values.subList(45, 46)));
        dictionary.put('K', new ArrayList<Character>(values.subList(46, 47)));
        dictionary.put('L', new ArrayList<Character>(values.subList(47, 51)));
        dictionary.put('M', new ArrayList<Character>(values.subList(51, 53)));
        dictionary.put('N', new ArrayList<Character>(values.subList(53, 59)));
        dictionary.put('O', new ArrayList<Character>(values.subList(59, 66)));
        dictionary.put('P', new ArrayList<Character>(values.subList(66, 68)));
        dictionary.put('Q', new ArrayList<Character>(values.subList(68, 69)));
        dictionary.put('R', new ArrayList<Character>(values.subList(69, 75)));
        dictionary.put('S', new ArrayList<Character>(values.subList(75, 81)));
        dictionary.put('T', new ArrayList<Character>(values.subList(81, 90)));
        dictionary.put('U', new ArrayList<Character>(values.subList(90, 93)));
        dictionary.put('V', new ArrayList<Character>(values.subList(93, 94)));
        dictionary.put('W', new ArrayList<Character>(values.subList(94, 96)));
        dictionary.put('X', new ArrayList<Character>(values.subList(96, 97)));
        dictionary.put('Y', new ArrayList<Character>(values.subList(97, 99)));
        dictionary.put('Z', new ArrayList<Character>(values.subList(99, 100)));
        dictionary.put(' ', new ArrayList<Character>(values.subList(101, 102)));
    }
}
