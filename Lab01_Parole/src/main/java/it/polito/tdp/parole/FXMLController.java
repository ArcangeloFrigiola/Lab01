package it.polito.tdp.parole;

//import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleArray elenco ;
	//Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTempi;
    
    @FXML
    void doCancella(ActionEvent event) {

    	double startTime = System.nanoTime();
    	String p = this.txtResult.getSelectedText();
    	elenco.cancellaParola(p);
    	this.txtResult.clear();
    	for(String t: elenco.getElenco()) {
    		this.txtResult.appendText(t+"\n");
    	}
    	this.txtTempi.appendText("Tempo di esecuzione per la cancellazione: "+(System.nanoTime()-startTime)+" nanosecondi\n");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double startTime = System.nanoTime();
    	
    	String p = this.txtParola.getText();
    	
    	String pattern = "[a-zA-Z ]*";
    	
    	if(!p.matches(pattern)) {
    		this.txtResult.appendText("Inserire solo caratteri alfabetici!\n");
    		this.txtParola.clear();
    		return;
    	}
    	elenco.addParola(p);
    	this.txtResult.appendText(p+"\n");
    	this.txtParola.clear();
    	this.txtTempi.appendText("Tempo di esecuzione per l'inserimento: "+(System.nanoTime()-startTime)+" nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	double startTime = System.nanoTime();
    	elenco.reset();
    	this.txtResult.clear();
    	this.txtTempi.appendText("Tempo di esecuzione per il reset: "+(System.nanoTime()-startTime)+" nanosecondi\n");
    }

    @FXML
    void initialize() {
    	 assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
         
        elenco = new ParoleArray() ;
        //elenco = new Parole() ;
    }
}
