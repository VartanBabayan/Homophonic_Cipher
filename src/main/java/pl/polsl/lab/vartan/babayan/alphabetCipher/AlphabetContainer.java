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

        Numbers(Character num) {
            number = num;
        }

        public Character getNum() {
            return number;
        }

        private Character number;
    }

    /**
     * representing all lower case letters as constants
     */
    public enum LowerLetters {
        A('a'), B('b'), C('c'), D('d'), E('e'), F('f'), G('g'), H('h'), I('i'),
        J('j'), K('k'), L('l'), M('m'), N('n'), O('o'), P('p'), Q('q'), R('r'),
        S('s'), T('t'), U('u'), V('v'), W('w'), X('x'), Y('y'), Z('z');

        LowerLetters(Character letter) {
            lowLetter = letter;
        }

        Character getLowLetter() {
            return lowLetter;
        }

        private Character lowLetter;
    }

    /**
     * representing all upper case letters as constants
     */
    public enum UpperLetters {
        A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I('I'),
        J('J'), K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q('Q'), R('R'),
        S('S'), T('T'), U('U'), V('V'), W('W'), X('X'), Y('Y'), Z('Z');

        UpperLetters(Character letter) {
            uppLetter = letter;
        }

        Character getUppLetter() {
            return uppLetter;
        }

        private Character uppLetter;
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
        COMMA(','), SLASH('/'), VERTICALBAR('|'), LESS('<'), GREATER('>'), EMPTY(' ');

        PunctuationMarks(Character m) {
            mark = m;
        }

        public Character getMark() {
            return mark;
        }

        private Character mark;
    }

    /**
     * representing Greece letters as constants
     */
    public enum GreeceLetters {
        ALPHA('α'), BETTA('β'), GAMMA('γ'), DELTA('δ'), EPSILON('ε'),
        DZETA('ζ'), ETTA('η'), TETTA('θ'), YOTA('ί'), KAPPA('κ');

        GreeceLetters(Character letter) {
            gLetter = letter;
        }

        public Character getGreeceLetter() {
            return gLetter;
        }

        private Character gLetter;
    }
}