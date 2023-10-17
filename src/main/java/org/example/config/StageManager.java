package org.example.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.enums.FxmlTab;
import org.example.enums.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Lazy(true)
@Component
public class StageManager {

    @Value("${admin-panel.width}")
    private String adminPanelWidth;
    @Value("${admin-panel.height}")
    private String adminPanelHeight;

    private final Stage stage;
    private final ApplicationContext applicationContext;
    private final FxmlLoader loader;

    @Autowired
    public StageManager(Stage stage, ApplicationContext applicationContext, FxmlLoader loader) {
        this.stage = stage;
        this.applicationContext = applicationContext;
        this.loader = loader;
    }

    public void displayView(FxmlView view) throws IOException {
        Parent root = loader.load(view);
        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle(view.getTitle());
        this.stage.centerOnScreen();
        this.stage.show();
    }

    public void updateBorderPane(BorderPane pane, FxmlTab tab) throws IOException {
        Parent root = loader.load(tab);
        pane.setCenter(root);
    }
}
