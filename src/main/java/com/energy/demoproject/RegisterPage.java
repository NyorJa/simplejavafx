package com.energy.demoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class RegisterPage {

    @FXML
    private AnchorPane AlreadyAMember;

    @FXML
    private BorderPane RegisterScene;

    @FXML
    private AnchorPane SignUp;

    @FXML
    private Text alreadyAMemberText;

    @FXML
    private Text firstName;

    @FXML
    private Text lastName;

    @FXML
    private Text password;

    @FXML
    private ImageView registerImage;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textUserName;

    @FXML
    private Text userName;

    @FXML
    private Label warning;

    @FXML
    void signInClick(ActionEvent event) throws IOException {
        Application application = new Application();
        application.changeScene("loginStyle.fxml");
    }

    @FXML
    void signUpClick(ActionEvent event) throws IOException{
        Application app = new Application();

        String accountFirstName = "";
        String accountLastName = "";
        String accountUserName;
        String accountPassword = "";

        if (textFirstName != null){
            accountFirstName = textFirstName.getText();
        }

        if (textLastName != null){
            accountLastName = textLastName.getText();
        }

        if (textUserName != null){
            accountUserName = textUserName.getText();
        } else {
            accountUserName = "";
        }

        if (textPassword != null){
            accountPassword = textPassword.getText();
        }

/*        try {
            File file = new File("accounts.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);

            if (!accountFirstName.isBlank() &&
                    !accountLastName.isBlank() &&
                    !accountUserName.isBlank() &&
                    !accountPassword.isBlank()) {
                br.write("First Name: " + accountFirstName);
                br.write(", Last Name: " + accountLastName);
                br.write(", User Name: " + accountUserName);
                br.write(", Password: " + accountPassword);
                br.newLine();
                br.newLine();

                br.close();
                fr.close();


                Application application = new Application();
                application.changeScene("loginStyle.fxml");
            }

            else {
                warning.setText("One or more fields are empty.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }*/

        UserRegistrationService userRegistrationService = new UserRegistrationService();
        if (!accountFirstName.isBlank() && !accountLastName.isBlank() && !accountUserName.isBlank() &&
                !accountPassword.isBlank()) {

            // check existing username
            boolean isUserExisting = userRegistrationService.loadUsers().stream().anyMatch(user -> user.getUsername().equals(accountUserName));
            if (isUserExisting) {
                warning.setText("Username " + accountUserName + " is existing");
            } else {
                // saving user
                userRegistrationService.save(new User(accountUserName, accountPassword, accountLastName, accountFirstName));

                // redirect
                Application application = new Application();
                application.changeScene("loginStyle.fxml");
            }

        } else {
            warning.setText("One or more fields are empty.");
        }
    }

}
