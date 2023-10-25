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
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Lazy(true)
@Component
public class LoginController {
    @Value("${admin-panel.title}")
    private String adminPanelTitle;
    private final StageManager stageManager;
    private final LoginService loginService;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @Autowired
    public LoginController(StageManager stageManager, LoginService loginService) {
        this.stageManager = stageManager;
        this.loginService = loginService;
    }

    public void loginButtonOnAction(ActionEvent e) throws IOException {

        if (!userNameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            try {
                String token = loginService.getToken(userNameTextField.getText(), passwordPasswordField.getText());
                stageManager.displayView(FxmlView.MAIN);
            } catch (HttpClientErrorException httpClientErrorException) {
                loginMessageLabel.setText("Wrong credentials");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = ((Stage) cancelButton.getScene().getWindow());
        stage.close();
    }
}
