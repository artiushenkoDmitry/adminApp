package org.example.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.example.enums.FxmlTab;
import org.example.enums.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class FxmlLoader {
    private final ApplicationContext applicationContext;

    @Autowired
    public FxmlLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Parent load(FxmlView view) throws IOException {
        return getParent(view.getFxmlFile());
    }

    public Parent load(FxmlTab tab) throws IOException {
        return getParent(tab.getFxmlFile());
    }

    private Parent getParent(String tab) throws IOException {
        URL resource = getClass().getResource(tab);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.setControllerFactory(applicationContext::getBean);

        return fxmlLoader.load();
    }
}
