package dad.cambiodivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {

    private TextField primCant;
    private TextField segCant;
    private ComboBox<String> tipoMoneda1;
    private ComboBox<String> tipoMoneda2;
    private Button cambio;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primCant = new TextField();
        primCant.setPromptText("Cantidad");

        segCant = new TextField();
        segCant.setPromptText("Cantidad");

        tipoMoneda1 = new ComboBox<String>();
        tipoMoneda1.getItems().addAll("Euro","Libra","Yen","Dolar");
        tipoMoneda1.setPromptText("Tipo");

        tipoMoneda2 = new ComboBox<String>();
        tipoMoneda2.getItems().addAll("Euro","Libra","Yen","Dolar");
        tipoMoneda2.setPromptText("Tipo");

        cambio = new Button("Cambiar");
        cambio.setDefaultButton(true);
        cambio.setOnAction(e -> onActionChange(e));

        HBox primero = new HBox(5, primCant, tipoMoneda1);
        primero.setAlignment(Pos.CENTER);

        HBox segundo = new HBox(5, segCant, tipoMoneda2);
        segundo.setAlignment(Pos.CENTER);

        VBox root = new VBox(5,primero,segundo, cambio);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root,320,200);

        primaryStage.setTitle("Cambio de Divisa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onActionChange(ActionEvent e) {
        Divisa euro = new Divisa("Euro", 1.0);
        Divisa libra = new Divisa("Libra", 0.8873);
        Divisa dolar = new Divisa("Dolar", 1.2007);
        Divisa yen = new Divisa("Yen", 133.59);

        double cambio=Double.parseDouble(primCant.getText());

        if(tipoMoneda1.getValue().equals("Euro")) {
            if(tipoMoneda2.getValue().equals("Libra")) {
                cambio =Divisa.fromTo(euro,libra, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Dolar")) {
                cambio =Divisa.fromTo(euro,dolar, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Yen")) {
                cambio =Divisa.fromTo(euro,yen, Double.parseDouble(primCant.getText()));
            }
        }
        else if(tipoMoneda1.getValue().equals("Libra")) {
            if(tipoMoneda2.getValue().equals("Euro")) {
                cambio =Divisa.fromTo(libra,euro, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Dolar")) {
                cambio =Divisa.fromTo(libra,dolar, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Yen")) {
                cambio =Divisa.fromTo(libra,yen, Double.parseDouble(primCant.getText()));
            }
        }
        else if(tipoMoneda1.getValue().equals("Yen")) {
            if(tipoMoneda2.getValue().equals("Libra")) {
                cambio =Divisa.fromTo(yen,libra, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Dolar")) {
                cambio =Divisa.fromTo(yen,dolar, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Euro")) {
                cambio =Divisa.fromTo(yen,euro, Double.parseDouble(primCant.getText()));
            }
        }
        if(tipoMoneda1.getValue().equals("Dolar")) {
            if(tipoMoneda2.getValue().equals("Libra")) {
                cambio =Divisa.fromTo(dolar,libra, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Euro")) {
                cambio =Divisa.fromTo(dolar,euro, Double.parseDouble(primCant.getText()));
            }
            else if(tipoMoneda2.getValue().equals("Yen")) {
                cambio =Divisa.fromTo(dolar,yen, Double.parseDouble(primCant.getText()));
            }
        }
        segCant.setText(cambio+"");

    }

    public static void main(String[] args) {
        launch(args);
    }

}