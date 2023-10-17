package org.example.enums;

public enum FxmlTab {
    EVENTS {
        @Override
        public String getFxmlFile() {
            return "/org.example/tabs/Events.fxml";
        }
    }, INITIATIVES {
        @Override
        public String getFxmlFile() {
            return "/org.example/tabs/Initiatives.fxml";
        }
    }, NEWS {
        @Override
        public String getFxmlFile() {
            return "/org.example/tabs/News.fxml";
        }
    }, USEFUL_LINKS {
        @Override
        public String getFxmlFile() {
            return "/org.example/tabs/UsefulLinks.fxml";
        }
    };

    abstract public String getFxmlFile();
}
