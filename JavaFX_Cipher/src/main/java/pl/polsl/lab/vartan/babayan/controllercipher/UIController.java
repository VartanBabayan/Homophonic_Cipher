package pl.polsl.lab.vartan.babayan.controllercipher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.modelcipher.ProductModel;

import java.io.IOException;

public class UIController {
    /**
     * overview message of the project
     */
    private final String appOverview = "The cipher encrypts messages that contain English letters only." +
            "However, you can decrypt your message by using letters " +
            "from a specific alphabet that is used by the Cipher";

    /**
     * message that contains info about the project
     */
    private final String appContext = "The homophonic substitution cipher uses a correspondence " +
            "table between the letters of the plain message. " +
            "Each letter is supposed to be translated to a letter from another alphabet, " +
            "number or even groups of characters. Consequently, the same letter may have several possible " +
            "encryption and the same message will possibly have several possible encrypted versions.";

    /**
     * message to cipher
     */
    private String message;


    /**
     * flag to cipher
     */
    private Character flag;

    /**
     * interaction with model
     */
    private HomophonicCipher model;

    /**
     * main pane of our window
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * decode box to select option - decoding
     */
    @FXML
    private CheckBox decodeBox;

    /**
     * encode box to select option - encoding
     */
    @FXML
    private CheckBox encodeBox;

    /**
     * button to get input
     */
    @FXML
    private Button submitButton;

    /**
     * Area that contains message
     */
    @FXML
    private TextArea textArea;

    /**
     * Field that contains encrypted message
     */
    @FXML
    private TextField textField;

    /**
     * menubar located in the window
     */
    @FXML
    private MenuBar menuBar;

    /**
     * history item
     */
    @FXML
    private MenuItem menuHistoryItem;

    /**
     * split pane
     */
    @FXML
    private SplitPane splitPane;

    /**
     * table to contain history of operations
     */
    @FXML
    private TableView<ProductModel> tableView;

    /**
     * column to contain messages
     */
    @FXML
    private TableColumn<ProductModel, String> colMessage;

    /**
     * column to contain flags
     */
    @FXML
    private TableColumn<ProductModel, Character> colFlag;

    /**
     * observable list to contain rows of the tableView
     */
    private ObservableList<ProductModel> observableList;

    /**
     * model that represents one row
     */
    private ProductModel productModel;

    /**
     * init session where input processes
     */
    @FXML
    public void initialize() {
        model = new HomophonicCipher();
        observableList = FXCollections.observableArrayList();
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colMessage.setMinWidth(500);
        colFlag.setCellValueFactory(new PropertyValueFactory<>("flag"));

        submitButton.setOnAction(actionEvent -> {
            String message = textArea.getText().trim();
            boolean isFlagSelected = encodeBox.isSelected() ^ decodeBox.isSelected();
            if (!message.equals("") && isFlagSelected) {
                this.message = message;
                this.flag = encodeBox.isSelected() ? 'E' : 'F';

                if (this.processData(this.message, flag)) {
                    System.out.println(this.message);
                    textField.setText(this.message);

                    productModel = new ProductModel(message, flag);
                    observableList.add(productModel);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.showAndWait();
                    textField.setText(model.getErrMessage() + " : your input contains improper symbols");
                }

            } else {
                System.out.println("Something is wrong");
            }
        });

        tableView.setItems(observableList);
    }

    /**
     * handles submit button in the window
     *
     * @param event - object that controls all events
     */
    @FXML
    public void handleSubmitButton(ActionEvent event) {
        System.out.println("Hello world");
    }

    /**
     * handles check boxes in the window
     *
     * @param event - object that controls all events
     */
    @FXML
    public void handleCheckBox(ActionEvent event) {
        if (encodeBox.isSelected() && !decodeBox.isSelected()) {
            decodeBox.setSelected(false);
        } else {
            encodeBox.setSelected(false);
        }
    }

    /**
     * handle with help item
     *
     * @param event - object that controls all events
     */
    @FXML
    public void handleHelpMenuItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Homophonic Cipher");
        alert.setContentText(appContext);
        alert.setHeaderText(appOverview);
        alert.showAndWait();
    }

    /**
     * handle with history item
     *
     * @param event - object that controls all events
     */
    @FXML
    public void handleHistoryMenuITem(ActionEvent event) throws IOException {
        menuHistoryItem.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../TableHistory.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                stage.setTitle("table");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * sending data to Model which return a processed message
     *
     * @param message - to make cipher from the text
     * @param flag    - to know [E]ncrypt or [D]ecrypt
     * @return true if everything is okay, false if message contains errors
     */
    public boolean processData(String message, Character flag) {
        this.flag = flag;
        if (this.flag == 'E') {
            this.message = model.encryptMessage(message);
        } else {
            this.message = model.decryptMessage(message);
        }

        return !this.message.equals(model.getErrMessage());
    }

    /**
     * setter for attribute <message>
     *
     * @param message - message that contains text which will be processed by encoder
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * setter for attribute <flag>
     *
     * @param flag - contains flag that represents the option (Encryption or Decryption)
     */
    public void setFlag(Character flag) {
        this.flag = flag;
    }

    /**
     * @return message ([E]ncrypted or [D]ecrypted)
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * true - [E]ncryption / false - [D]ecryption
     *
     * @return status
     */
    public Character getFlag() {
        return this.flag;
    }
}