package szakdolgozat.ujkripto.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import szakdolgozat.dialog.warner.DialogWarner;
import szakdolgozat.ujkripto.Ujkripto;
import szakdolgozat.ujkripto.scene.UjkriptoScene;
import szakdolgozat.ujkripto.server.UjkriptoServer;

import static szakdolgozat.texts.Texts.UJKRIPTO_APPLICATION_TITLE;

public class UjkriptoApplication extends Application {

    public static void main(String[] args) {
        Ujkripto.getInstance().setDialogWarner(new DialogWarner());
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle(UJKRIPTO_APPLICATION_TITLE);
        stage.setScene(new UjkriptoScene());
        stage.sizeToScene();
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        UjkriptoServer.getInstance().stop();
    }
}
