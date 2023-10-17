package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.example.config.FxmlLoader;
import org.example.config.StageManager;
import org.example.enums.FxmlView;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class Main extends Application {
    private ConfigurableApplicationContext applicationContext;
    private StageManager stageManager;

    private FxmlLoader fxmlLoader;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(SpringBootMain.class).run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        applicationContext.publishEvent(new StageReadyEvent(stage));
        fxmlLoader = applicationContext.getBean(FxmlLoader.class, applicationContext);
        stageManager = applicationContext.getBean(StageManager.class, stage, applicationContext, fxmlLoader);

        stageManager.displayView(FxmlView.LOGIN);
    }

    @Override
    public void stop() {
        applicationContext.stop();
        Platform.exit();
    }

    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}