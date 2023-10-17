package org.example.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.config.StageManager;
import org.example.enums.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Lazy(true)
@Component
public class LoginController {
    @Value("${admin-panel.title}")
    private String adminPanelTitle;
    private final StageManager stageManager;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @Autowired
    public LoginController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public void loginButtonOnAction(ActionEvent e) throws IOException {

        if (!userNameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            stageManager.displayView(FxmlView.MAIN);
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = ((Stage) cancelButton.getScene().getWindow());
        stage.close();
    }
}
