package pl.polsl.lab.vartan.babayan.alphabetCipher;

import pl.polsl.lab.vartan.babayan.alphabetCipher.AlphabetContainer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Storage where alphabet and dictionary defines for cipher
 *
 * @author vartan babayan
 * @version 1.0
 */
public class KeyStorage {
    /**
     * alphabet of values for encoding
     */
    private final ArrayList<Character> values;

    /**
     * map where for each letter own and unique array of alphabet
     */
    private final HashMap<Character, ArrayList<Character>> dictionary;

    /**
     * default constructor
     */
    public KeyStorage() {
        values = new ArrayList<>();

        ArrayList<Numbers> n = new ArrayList<>(Arrays.asList(Numbers.values()));
        ArrayList<Character> numbers = n.stream().map(Numbers::getNum).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<LowerLetters> ll = new ArrayList<>(Arrays.asList(LowerLetters.values()));
        ArrayList<Character> lowLetters = ll.stream().map(LowerLetters::getLowLetter).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<PunctuationMarks> pun = new ArrayList<>(Arrays.asList(PunctuationMarks.values()));
        ArrayList<Character> punMarks = pun.stream().map(PunctuationMarks::getMark).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<UpperLetters> upl = new ArrayList<>(Arrays.asList(UpperLetters.values()));
        ArrayList<Character> uppLetters = upl.stream().map(UpperLetters::getUppLetter).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<SecondAlphabet> gl = new ArrayList<>(Arrays.asList(SecondAlphabet.values()));
        ArrayList<Character> secLetters = gl.stream().map(SecondAlphabet::getLetter).collect(Collectors.toCollection(ArrayList::new));

        values.addAll(numbers);
        values.addAll(lowLetters);
        values.addAll(punMarks);
        values.addAll(uppLetters);
        values.addAll(secLetters);

        dictionary = new HashMap<>();
        dictionary.put('A', new ArrayList<>(values.subList(0, 8)));
        dictionary.put('B', new ArrayList<>(values.subList(8, 10)));
        dictionary.put('C', new ArrayList<>(values.subList(10, 13)));
        dictionary.put('D', new ArrayList<>(values.subList(13, 17)));
        dictionary.put('E', new ArrayList<>(values.subList(17, 29)));
        dictionary.put('F', new ArrayList<>(values.subList(29, 31)));
        dictionary.put('G', new ArrayList<>(values.subList(31, 33)));
        dictionary.put('H', new ArrayList<>(values.subList(33, 39)));
        dictionary.put('I', new ArrayList<>(values.subList(39, 45)));
        dictionary.put('J', new ArrayList<>(values.subList(45, 46)));
        dictionary.put('K', new ArrayList<>(values.subList(46, 47)));
        dictionary.put('L', new ArrayList<>(values.subList(47, 51)));
        dictionary.put('M', new ArrayList<>(values.subList(51, 53)));
        dictionary.put('N', new ArrayList<>(values.subList(53, 59)));
        dictionary.put('O', new ArrayList<>(values.subList(59, 66)));
        dictionary.put('P', new ArrayList<>(values.subList(66, 68)));
        dictionary.put('Q', new ArrayList<>(values.subList(68, 69)));
        dictionary.put('R', new ArrayList<>(values.subList(69, 75)));
        dictionary.put('S', new ArrayList<>(values.subList(75, 81)));
        dictionary.put('T', new ArrayList<>(values.subList(81, 90)));
        dictionary.put('U', new ArrayList<>(values.subList(90, 93)));
        dictionary.put('V', new ArrayList<>(values.subList(93, 94)));
        dictionary.put('W', new ArrayList<>(values.subList(94, 96)));
        dictionary.put('X', new ArrayList<>(values.subList(96, 97)));
        dictionary.put('Y', new ArrayList<>(values.subList(97, 99)));
        dictionary.put('Z', new ArrayList<>(values.subList(99, 100)));
        dictionary.put(' ', new ArrayList<>(values.subList(101, 102)));
    }

    /**
     * @return alphabet which contains all symbols for cipher
     */
    public final ArrayList<Character> getValues() {
        return this.values;
    }

    /**
     * @return dictionary which contains info about how each letter will be [E]ncrypted or [D]ecrypted
     */
    public final HashMap<Character, ArrayList<Character>> getDictionary() {
        return this.dictionary;
    }
}