package pl.polsl.lab.vartan.babayan.alphabetCipher;

/**
 * Class that contains all letters and numbers needed for cipher
 *
 * @author vartan babayan
 * @version 1.0
 */
public class AlphabetContainer {
    /**
     * representing all digits as constants
     */
    public enum Numbers {
        ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'),
        SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), ZERO('0');
        
        /**
         * default constructor
         * @param num - to make possible initialize our constants with particular value
         */
        Numbers(Character num) {
            number = num;
        }
        
        /**
         * @return - value of constant
         */
        public Character getNum() {
            return number;
        }

        private final Character number;
    }

    /**
     * representing all lower case letters as constants
     */
    public enum LowerLetters {
        A('a'), B('b'), C('c'), D('d'), E('e'), F('f'), G('g'), H('h'), I('i'),
        J('j'), K('k'), L('l'), M('m'), N('n'), O('o'), P('p'), Q('q'), R('r'),
        S('s'), T('t'), U('u'), V('v'), W('w'), X('x'), Y('y'), Z('z');

        /**
         * default constructor
         * @param letter - to make possible initialize our constants with particular value
         */
        LowerLetters(Character letter) {
            lowLetter = letter;
        }

        /**
         * @return - value of constant
         */
        Character getLowLetter() {
            return lowLetter;
        }

        private final Character lowLetter;
    }

    /**
     * representing all upper case letters as constants
     */
    public enum UpperLetters {
        A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I('I'),
        J('J'), K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q('Q'), R('R'),
        S('S'), T('T'), U('U'), V('V'), W('W'), X('X'), Y('Y'), Z('Z');

        /**
         * default constructor
         * @param letter - to make possible initialize our constants with particular value
         */
        UpperLetters(Character letter) {
            uppLetter = letter;
        }

        /**
         * @return - value of constant
         */
        Character getUppLetter() {
            return uppLetter;
        }

        private final Character uppLetter;
    }

    /**
     * representing punctuation marks as constants
     */
    public enum PunctuationMarks {
        EXCLAMATION('!'), ATSIGN('@'), DSLASH('\\'), NUMSIGN('#'), NUM('№'),
        DOLLAR('$'), SEMICOLUMN(';'), PERCENT('%'), CIRCUMFLEX('^'), COLON(':'),
        AMPERSAND('&'), QUESTIONMARK('?'), LRBRACKET('('), RRBRACKET(')'),
        HYPHEN('-'), DASH('_'), PLUS('+'), EQUAL('='), APOSTROPHE('`'), TILDE('~'),
        LSBRACKET('['), RSBRACKET(']'), LFBRACKET('{'), RFBRACKET('}'), FULLSTOP('.'),
        COMMA(','), SLASH('/'), VERTICALBAR('|');

        /**
         * default constructor
         * @param m - to make possible initialize our constants with particular value
         */
        PunctuationMarks(Character m) {
            mark = m;
        }

        /**
         * @return - value of constant
         */
        public Character getMark() {
            return mark;
        }

        private final Character mark;
    }

    /**
     * representing Greece letters as constants
     */
    public enum SecondAlphabet {
        LESS('<'), GREATER('>'), ALPHA('α'), BETTA('β'), GAMMA('γ'), DELTA('δ'), EPSILON('ε'),
        DZETA('ζ'), ETTA('η'), TETTA('θ'), YOTTA('ί'), KAPPA('κ'), EMPTY(' ');

        /**
         * default constructor
         * @param letter - to make possible initialize our constants with particular value
         */
        SecondAlphabet(Character letter) {
            gLetter = letter;
        }

        /**
         * @return - value of constant
         */
        public Character getLetter() {
            return gLetter;
        }

        private final Character gLetter;
    }
}