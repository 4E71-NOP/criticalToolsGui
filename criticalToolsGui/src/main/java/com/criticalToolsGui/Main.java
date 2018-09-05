package com.criticalToolsGui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * @author faust
 * 
 *         Auteur : Faust MARIA DE ARAVALO - Tous droits réservés. Projet
 *         CriticalToolsGui
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		// sceneBuilder on linux /opt/JavaFXSceneBuilder2.0/JavaFXSceneBuilder2.0
		// https://stackoverflow.com/questions/1820908/how-to-turn-off-the-eclipse-code-formatter-for-certain-sections-of-java-code

		Parent vueLancementAutonome;
		try {
			vueLancementAutonome = FXMLLoader
					.load(getClass().getResource("/com/criticalToolsGui/ihm/CriticalToolsGui.fxml"));

			Scene sceneLancementAutonome = new Scene(vueLancementAutonome);
			primaryStage.setScene(sceneLancementAutonome);
			primaryStage.setTitle("criticalToolGui");
			primaryStage.getIcons().add(new Image(getClass()
					.getResourceAsStream("/ressources/media/image/icone/Lab_javaFX_interfaces_icone.png")));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
