package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private AlienDictionary dizionario;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	dizionario.clearDictionary();
    	txtResult.clear();
    	txtTesto.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = txtTesto.getText();
    	String campi[]=s.split(" ");
    	if(campi.length==1) {
    		String alienWord= campi[0].toLowerCase();
    		if (!alienWord.matches("[a-z]*")) {
    			txtResult.appendText("Sono validi solo caratteri alfanumerici \n");
        		return;
        	}
    		String traduzione= dizionario.translateWord(alienWord);
    		if(traduzione!=null)
    			txtResult.appendText(traduzione+ "\n");
    		else
    			txtResult.appendText("Traduzione non trovata \n");
    	}else if(campi.length==2) {
    		String alienWord= campi[0].toLowerCase();
    		String traduzione= campi[1].toLowerCase();
    		if (!alienWord.matches("[a-z]*") || !traduzione.matches("[a-z]*")) {
    			txtResult.appendText("Sono validi solo caratteri alfanumerici \n");
        		return;
        	}
    		dizionario.addWord(alienWord, traduzione);
    		txtResult.appendText("La parola: \"" + alienWord + "\", con traduzione: \"" + traduzione + "\", è stata inserita nel dizionario. \n");
    		
    	}else {
    		txtResult.appendText("Inserire la parola da tradurre o la parola da aggiungere al dizionario con relativa traduzione");
    	}
    		
    	
    	}

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    void setModel (AlienDictionary dizionario) {
    	this.dizionario=dizionario;
    }
}
