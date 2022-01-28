package pl.polsl.lab.vartan.babayan;

import pl.polsl.lab.vartan.babayan.controllercipher.Controller;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.viewcipher.CipherViewer;

/**
 * Main class where program starts
 *
 * @author vartan babayan
 * @version 1.0
 */
public class MainMenu {
    /**
     * starter point, processing all logic of the program
     *
     * @param args - command line arguments provided by user
     */
    public static void main(String[] args) {
        HomophonicCipher model = new HomophonicCipher();
        CipherViewer viewer = new CipherViewer();
        Controller controller = new Controller(viewer, model);
        controller.runSession();
    }
}