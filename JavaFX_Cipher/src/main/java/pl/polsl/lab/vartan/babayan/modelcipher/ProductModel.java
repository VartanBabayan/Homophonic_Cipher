package pl.polsl.lab.vartan.babayan.modelcipher;

/**
 * class to contain all messages and flags as a one object
 */
public class ProductModel {
    /**
     * encrypted message
     */
    private String message;

    /**
     * flag - [E]ncrypt or [D]ecrypt
     */
    private Character flag;

    /**
     * default constructor
     *
     * @param message - encrypted message
     * @param flag    - [E]ncrypt or [D]ecrypt
     */
    public ProductModel(String message, Character flag) {
        this.message = message;
        this.flag = flag;
    }

    /**
     * makes accessible field message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * makes accessible field flag
     *
     * @return flag
     */
    public Character getFlag() {
        return flag;
    }
}