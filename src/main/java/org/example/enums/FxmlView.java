package org.example.enums;

public enum FxmlView {
    MAIN {
        @Override
        public String getTitle() {
            return "main.app.title";
        }

        @Override
        public String getFxmlFile() {
            return "/org.example/Main.fxml";
        }
    }, LOGIN {
        @Override
        public String getTitle() {
            return "login.title";
        }

        @Override
        public String getFxmlFile() {
            return "/org.example/Login.fxml";
        }
    };

    abstract public String getTitle();

    abstract public String getFxmlFile();
}
