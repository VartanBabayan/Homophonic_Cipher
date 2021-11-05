package tests;

import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.vartan.babayan.modelCipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.exceptionHandler.MessageCorrectnessException;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * @author vartan babayan
 * @version 1.0
 */
public class ModelTest {

    private HomophonicCipher obj;

    @BeforeEach
    public void setUpClass() {
        obj = new HomophonicCipher();
    }

    @ParameterizedTest
    @CsvSource({"test encryption, a, Բարև ձեզ, error"})
    public void testEncryption(String message, String borderMsg, String incorrectMsg, String errMsg) {
        try {
            String res1 = obj.encryptMessage(message);
            String res2 = obj.encryptMessage(borderMsg);
            String res3 = obj.encryptMessage(incorrectMsg);

            if (res1.equals(errMsg) || res2.equals(errMsg) || !res3.equals(errMsg)) {
                throw new MessageCorrectnessException("Encryption failed");
            }
        } catch (MessageCorrectnessException exception) {
            fail(exception.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({"XoOTκfjbKηDX№A, α, ցավդ տանեմ, error"})
    public void testDecryption(String message, String borderMsg, String incorrectMsg, String errMsg) {
        try {
            String res1 = obj.decryptMessage(message);
            String res2 = obj.decryptMessage(borderMsg);
            String res3 = obj.decryptMessage(incorrectMsg);

            if (res1.equals(errMsg) || res2.equals(errMsg) || !res3.equals(errMsg)) {
                throw new MessageCorrectnessException("Decryption failed");
            }
        } catch (MessageCorrectnessException exception) {
            fail("Decryption failed");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"error"})
    public void testErrMessage(String errMsg) {
        assertEquals(obj.getErrMessage(), errMsg);
    }
}