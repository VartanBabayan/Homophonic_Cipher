package pl.polsl.lab.vartan.babayan.modelcipher;

/**
 * POJO class to describe a particular record inside the db
 *
 * @author vartan babayan
 * @version 1.0
 */
public class History {
    /**
     * message to contain text to encode
     */
    private String msg;

    /**
     * text that is encoded
     */
    private String encodedMsg;

    /**
     * flag that is used during encoding
     */
    private Character flag;

    /**
     * default constructor
     */
    public History() {
        msg = "";
        encodedMsg = "";
        flag = ' ';
    }

    /**
     * constructor with arguments
     *
     * @param msg        - initial text
     * @param encodedMsg - encoded text
     * @param flag       - encoding option
     */
    public History(String msg, String encodedMsg, Character flag) {
        this.msg = msg;
        this.encodedMsg = encodedMsg;
        this.flag = flag;
    }

    /**
     * getter for msg
     *
     * @return message
     */
    public String getMsg() {
        return msg;
    }

    /**
     * setter for msg
     *
     * @param msg - initial text
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * getter for encodedMsg
     *
     * @return encoded message
     */
    public String getEncodedMsg() {
        return encodedMsg;
    }

    /**
     * setter for encodedMsg
     *
     * @param encodedMsg - initial encoded text
     */
    public void setEncodedMsg(String encodedMsg) {
        this.encodedMsg = encodedMsg;
    }

    /**
     * getter for flag
     *
     * @return - encoding option
     */
    public Character getFlag() {
        return flag;
    }

    /**
     * setter for flag
     *
     * @param flag - initial flag
     */
    public void setFlag(Character flag) {
        this.flag = flag;
    }
}
