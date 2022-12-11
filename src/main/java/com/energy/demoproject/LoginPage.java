package com.energy.demoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class LoginPage {

    //@FXML objects (private) for GUI design
    @FXML
    private BorderPane LoginScene;

    @FXML
    private AnchorPane NewHere;

    @FXML
    private AnchorPane SignIn;

    @FXML
    private ImageView loginImage;

    @FXML
    private Text newHereText;

    @FXML
    private Text registerText;

    @FXML
    private Label seeLabel;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Label warning;

    //@FXML objects that execute actions

    //check username and/or password if it is null or mismatched to refrain user from
    //entering the program

    //user only gains entry if username and password is matched and found based on the "accounts.txt" file
    @FXML
    void onSignInClick(ActionEvent event) throws IOException{
        boolean found = false;
        File file = new File("accounts.txt");
        String username = textName != null ? textName.getText() : "";
        String password = textPassword != null ? textPassword.getText() : "";

        // validation
        if (!username.isBlank() && !password.isBlank()) {
            UserRegistrationService userRegistrationService = new UserRegistrationService();
            Optional<User> userOptional = userRegistrationService.loadUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst();
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (user.getPassword().equals(password)) {
                    Application application = new Application();
                    application.changeScene("energyCostStyle.fxml");
                } else {
                    warning.setText("Wrong credentials");
                }
            } else {
                warning.setText("User is not registered");
            }

        }

        else {
            warning.setText("One or more fields are empty.");
        }
    }

    @FXML
    void onSignUpClick(ActionEvent event) throws IOException {
        Application application = new Application();
        application.changeScene("registerStyle.fxml");
    }

}
