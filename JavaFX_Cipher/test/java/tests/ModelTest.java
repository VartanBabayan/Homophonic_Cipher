package tests;

import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * class to test all public methods of model package
 *
 * @author vartan babayan
 * @version 1.0
 */
public class ModelTest {
    /**
     * object to test all model's methods
     */
    private HomophonicCipher obj;

    /**
     * initialize the object
     */
    @BeforeEach
    public void setUpClass() {
        obj = new HomophonicCipher();
    }

    /**
     * test how encryption works
     *
     * @param message      - test message to encrypt
     * @param borderMsg    - border message to encrypt (contains only one symbol)
     * @param incorrectMsg - incorrect message to encrypt (contains only improper symbols)
     * @param errMsg       - error message to check the result
     */
    @ParameterizedTest
    @CsvSource({"test encryption, a, Բարև ձեզ, error"})
    public void testEncryption(String message, String borderMsg, String incorrectMsg, String errMsg) {
        assertNotEquals(obj.encryptMessage(message), errMsg);
        assertNotEquals(obj.encryptMessage(borderMsg), errMsg);
        assertEquals(obj.encryptMessage(incorrectMsg), errMsg);
    }

    /**
     * test how decryption works
     *
     * @param message      - test message to decrypt
     * @param borderMsg    - border message to decrypt (contains only one symbol)
     * @param incorrectMsg - incorrect message to decrypt (contains only improper symbols)
     * @param errMsg       - error message to check the result
     */
    @ParameterizedTest
    @CsvSource({"XoOTκfjbKηDX№A, α, ցավդ տանեմ, error"})
    public void testDecryption(String message, String borderMsg, String incorrectMsg, String errMsg) {
        assertNotEquals(obj.decryptMessage(message), errMsg);
        assertNotEquals(obj.decryptMessage(borderMsg), errMsg);
        assertEquals(obj.decryptMessage(incorrectMsg), errMsg);
    }

    /**
     * check that returned value is correct
     *
     * @param errMsg - expected return value
     */
    @ParameterizedTest
    @ValueSource(strings = {"error"})
    public void testErrMessage(String errMsg) {
        assertEquals(obj.getErrMessage(), errMsg);
    }
}