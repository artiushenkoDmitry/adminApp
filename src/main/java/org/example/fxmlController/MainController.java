package org.example.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.example.config.StageManager;
import org.example.enums.FxmlTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Lazy(true)
@Component
public class MainController {

    private final StageManager stageManager;

    @Autowired
    public MainController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;

    public void home(ActionEvent e) {
        bp.setCenter(ap);
    }

    public void eventTabOnAction(ActionEvent e) throws IOException {
        stageManager.updateBorderPane(bp, FxmlTab.EVENTS);
    }

    public void initiativesTabOnAction(ActionEvent e) throws IOException {
        stageManager.updateBorderPane(bp, FxmlTab.INITIATIVES);
    }

    public void newsTabOnAction(ActionEvent e) throws IOException {
        stageManager.updateBorderPane(bp, FxmlTab.NEWS);
    }

    public void usefulLinksTabOnAction(ActionEvent e) throws IOException {
        stageManager.updateBorderPane(bp, FxmlTab.USEFUL_LINKS);
    }
}
