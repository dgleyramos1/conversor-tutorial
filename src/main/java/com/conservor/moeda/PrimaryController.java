package com.conservor.moeda;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

public class PrimaryController {

    @FXML
    private SplitMenuButton fromCoinMenu;

    @FXML
    private TextField inputQtd;

    @FXML
    private Label labelInfoConvert;

    @FXML
    private Label labelInfoResult;

    @FXML
    private SplitMenuButton toCoinMenu;

    private String fromCoin;
    private String toCoin;

    Alert a;

    @FXML
    void handleConvertCoin(MouseEvent event) {
        if (fromCoin == null || toCoin == null) {
            a.setContentText("Por favor informe todas as moedas");
            a.show();
            return;
        }
        if (inputQtd.getText().matches("^[a-zA-Z]*")) {
            a.setContentText("Entre somente com números!");
            a.show();
            return;
        }
        if (fromCoin.equals(toCoin)) {
            a.setContentText("As moedas não podem ser iguais!");
            a.show();
            return;
        }
        labelInfoConvert.setText(inputQtd.getText() + " " + fromCoin + " TO " + toCoin);
        convert(Double.parseDouble(inputQtd.getText()), fromCoin, toCoin);
        inputQtd.setText("");
    }

    private void convert(double valor, String from, String to) {
        Double result = 0.00;
        switch (from) {
            case "USD":
                if (to.equals("EUR")) {
                    result = valor * 0.93;
                    break;
                }
                if (to.equals("BRL")) {
                    result = valor * 5.21;
                    break;
                }
                if (to.equals("ARS")) {
                    result = valor * 200.73;
                    break;
                }
                break;
            case "EUR":
                if (to.equals("USD")) {
                    result = valor * 1.07;
                    break;
                }
                if (to.equals("BRL")) {
                    result = valor * 5.55;
                    break;
                }
                if (to.equals("ARS")) {
                    result = valor * 213.57;
                    break;
                }
                break;
            case "BRL":
                if (to.equals("USD")) {
                    result = valor * 0.19;
                    break;
                }
                if (to.equals("EUR")) {
                    result = valor * 0.18;
                    break;
                }
                if (to.equals("ARS")) {
                    result = valor * 38.47;
                    break;
                }
                break;
            case "ARS":
                if (to.equals("USD")) {
                    result = valor * 0.005;
                    break;
                }
                if (to.equals("EUR")) {
                    result = valor * 0.0046;
                    break;
                }
                if (to.equals("BRL")) {
                    result = valor * 0.026;
                    break;
                }
                break;
        }
        labelInfoResult.setText(String.format("%.2f", result));
    }

    @FXML
    void initialize() {
        a = new Alert(AlertType.ERROR);
        a.initStyle(StageStyle.UTILITY);
        a.setTitle("Error");

        labelInfoConvert.setText("");
        labelInfoResult.setText(String.format("%.2f", 0.00));

        fromCoinMenu.getItems().get(0).setOnAction((e) -> {
            fromCoin("USD");
        });
        fromCoinMenu.getItems().get(1).setOnAction((e) -> {
            fromCoin("BRL");
        });
        fromCoinMenu.getItems().get(2).setOnAction((e) -> {
            fromCoin("EUR");
        });
        fromCoinMenu.getItems().get(3).setOnAction((e) -> {
            fromCoin("ARS");
        });

        toCoinMenu.getItems().get(0).setOnAction((e) -> {
            toCoin("USD");
        });
        toCoinMenu.getItems().get(1).setOnAction((e) -> {
            toCoin("BRL");
        });
        toCoinMenu.getItems().get(2).setOnAction((e) -> {
            toCoin("EUR");
        });
        toCoinMenu.getItems().get(3).setOnAction((e) -> {
            toCoin("ARS");
        });
    }

    private void fromCoin(String valor) {
        fromCoin = valor;
        fromCoinMenu.setText(valor);
    }

    private void toCoin(String valor) {
        toCoin = valor;
        toCoinMenu.setText(valor);
    }
}
