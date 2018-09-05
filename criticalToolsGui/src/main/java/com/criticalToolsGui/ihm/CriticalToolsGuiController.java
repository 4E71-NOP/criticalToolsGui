package com.criticalToolsGui.ihm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import com.criticalTools.section.system.MemoryService;
import com.criticalTools.section.system.SystemScout;
import com.criticalToolsGui.entity.LigneResultat;
import com.criticalTools.section.hardware.HardwareInformation;
import com.criticalTools.agent.MySQLCnx;
import com.criticalTools.section.convert.DateManipulation;
import com.criticalTools.section.convert.NumberRepesentation;

public class CriticalToolsGuiController {
	private SystemScout ss = SystemScout.getInstance();
	private NumberRepesentation nr = NumberRepesentation.getInstance();
	private DateManipulation dm = DateManipulation.getInstance();
	private HardwareInformation hi = HardwareInformation.getInstance();
	private MemoryService ms = MemoryService.getInstance();

	// @formatter:off
	@FXML	private AnchorPane PrincipalId;

	@FXML	private Tab Tab01;
	@FXML	private Tab Tab02;
	@FXML	private Tab Tab03;
	@FXML	private Tab Tab04;
	@FXML	private Tab Tab05;
	@FXML	private Tab Tab06;

	@FXML	private Button Tab01ButtonA01;
	@FXML	private Label Tab01LabelA02;
	@FXML	private Button Tab01ButtonB01;

	@FXML	private Button Tab02ButtonA01;
	@FXML	private Button Tab02ButtonB01;
	@FXML	private Label Tab02LabelB02;
	@FXML	private Label Tab02LabelB03;
	@FXML	private Label Tab02LabelB04;
	@FXML	private Label Tab02LabelB05;
	@FXML	private Label Tab02LabelB06;
	@FXML	private Label Tab02LabelB07;

	@FXML	private TextField Tab03TextFieldA03;
	@FXML	private TextField Tab03TextFieldB03;
	@FXML	private TextField Tab03TextFieldC03;
	@FXML	private Button Tab03ButtonD03;
	@FXML	private Label Tab03LabelE03;

	@FXML	private TextField Tab04TextFieldA02;
	@FXML	private TextField Tab04TextFieldA05;

	@FXML	private TextField Tab04TextFieldB02;

	@FXML	private Button Tab04ButtonC02;
	@FXML	private Button Tab04ButtonC03;
	@FXML	private Button Tab04ButtonC04;
	@FXML	private Button Tab04ButtonC05;
	@FXML	private Button Tab04ButtonC06;
	@FXML	private Button Tab04ButtonC07;
	@FXML	private Button Tab04ButtonC08;

	@FXML	private Button Tab04ButtonD01;
	@FXML	private Label Tab04LabelD02;
	@FXML	private Label Tab04LabelD03;
	@FXML	private Label Tab04LabelD04;
	@FXML	private Label Tab04LabelD05;
	@FXML	private Label Tab04LabelD06;
	@FXML	private Label Tab04LabelD07;
	@FXML	private Label Tab04LabelD08;

	@FXML	private Button Tab05ButtonA01;
	@FXML	private Button Tab05ButtonA02;
	@FXML	private Label Tab05LabelB02;
	@FXML	private Circle Tab02Circle01;
	@FXML	private Circle Tab02Circle02;

	@FXML	private TextField Tab06LabelB02;
	@FXML	private TextField Tab06LabelB03;
	@FXML	private PasswordField Tab06PasswordFieldB04;
	@FXML	private TextField Tab06LabelB05;
	@FXML	private TextField Tab06LabelB06;
	@FXML	private TextField Tab06LabelB07;
	@FXML	private Button Tab06ButtonB01;
	@FXML	private Button Tab06ButtonB08;
	@FXML	private TextArea Tab06TextAreaC02;
	@FXML	private TableView Tab06TableViewC05;
	
	// @formatter:on

	// ------------------------------------------------------------------------
	// Tab01
	public void Tab01ButtonA01Action(ActionEvent event) {
		Tab01LabelA02.setText(ss.getAllInformation());

		Clipboard clipboard = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString(ss.getAllInformation());
		// content.putHtml("<b>Some</b> text");
		clipboard.setContent(content);
	}

	public void Tab01ButtonB01Action(ActionEvent event) {
		Tab01LabelA02.setText("");
	}

	// ------------------------------------------------------------------------
	// Tab02
	public void Tab02ButtonA01Action(ActionEvent event) {
		setupUpdate();
	}

	public void Tab02ButtonB01Action(ActionEvent event) {
		Tab02LabelB02.setText("");
		Tab02LabelB03.setText("");
		Tab02LabelB04.setText("");
		Tab02LabelB05.setText("");
		Tab02LabelB06.setText("");
		Tab02LabelB07.setText("");
	}

	/**
	 * Create a thread in order to let JavaFX free to manage items
	 */
	public void setupUpdate() {
		Task<Integer> task = new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {

				RotateTransition rt1 = new RotateTransition(Duration.millis(5000), Tab02Circle01);
				rt1.setRate(5);
				rt1.setByAngle(720);
				rt1.setCycleCount(20);
				rt1.setAutoReverse(false);
				rt1.setAxis(new Point3D(0, 0, 1));
				rt1.play();

				RotateTransition rt2 = new RotateTransition(Duration.millis(5000), Tab02Circle02);
				rt2.setRate(5);
				rt2.setByAngle(360);
				rt2.setCycleCount(20);
				rt2.setAutoReverse(false);
				rt2.setAxis(new Point3D(0, 0, 1));
				rt2.play();

				setOpacityCircles(1, true);
				hi.update();

				// try {
				// TimeUnit.SECONDS.sleep(5);
				// } catch (Exception e) {
				// System.out.println(e.getMessage());
				// }
				return 0;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				Tab02LabelB02.setText(hi.getVendorId());
				Tab02LabelB03.setText(hi.getModelName());
				Tab02LabelB04.setText("" + hi.getNumberOfCpu());
				Tab02LabelB05.setText(hi.getCacheSize());
				Tab02LabelB06.setText(hi.getFlags());
				Tab02LabelB07.setText(hi.getCpuMhz().toString());
				setOpacityCircles(0, false);
			}

			@Override
			protected void cancelled() {
				super.cancelled();
				System.out.println("Thread canceled");
			}

			@Override
			protected void failed() {
				super.failed();
				System.out.println("Thread Failed");
			}
		};
		new Thread(task).start();
	}

	public void setOpacityCircles(double opacite, boolean visible) {
		Tab02Circle01.setOpacity(opacite);
		Tab02Circle02.setOpacity(opacite);
		Tab02Circle01.setVisible(visible);
		Tab02Circle02.setVisible(visible);
	}

	// ------------------------------------------------------------------------
	// Tab03
	public void Tab03ButtonD03Action(ActionEvent event) {
		Tab03LabelE03.setText(nr.BaseConvertion(Tab03TextFieldA03.getText(),
				Integer.parseInt(Tab03TextFieldB03.getText()), Integer.parseInt(Tab03TextFieldC03.getText())));
	}

	// ------------------------------------------------------------------------
	// Tab04
	public void Tab04ButtonC02Action(ActionEvent event) {
		Timestamp t = dm.StringToTimestamp(Tab04TextFieldA02.getText());
		Tab04LabelD02.setText(dm.TimestampToSimpleDateFormat(t, Tab04TextFieldB02.getText()));
	}

	public void Tab04ButtonC03Action(ActionEvent event) {
		Timestamp t = dm.StringToTimestamp(Tab04TextFieldA02.getText());
		Tab04LabelD03.setText("" + dm.TimestampToLongMillisecond(t));
	}

	public void Tab04ButtonC04Action(ActionEvent event) {
		Timestamp t = dm.StringToTimestamp(Tab04TextFieldA02.getText());
		Tab04LabelD04.setText("" + dm.TimestampToLongSecond(t));
	}

	public void Tab04ButtonC05Action(ActionEvent event) {
		Tab04LabelD05.setText("" + dm.StringToTimestamp(Tab04TextFieldA05.getText()));
	}

	public void Tab04ButtonC06Action(ActionEvent event) {
		Tab04LabelD06.setText("" + dm.StringToLocaDateTime(Tab04TextFieldA05.getText()));
	}

	public void Tab04ButtonC07Action(ActionEvent event) {
		Tab04LabelD07.setText("" + dm.StringToLocaDate(Tab04TextFieldA05.getText()));
	}

	public void Tab04ButtonC08Action(ActionEvent event) {
		Tab04LabelD08.setText("" + dm.StringToLocaTime(Tab04TextFieldA05.getText()));
	}

	public void Tab04ButtonD01Action() {
		Tab04LabelD02.setText("");
		Tab04LabelD03.setText("");
		Tab04LabelD04.setText("");
		Tab04LabelD05.setText("");
		Tab04LabelD06.setText("");
		Tab04LabelD07.setText("");
		Tab04LabelD08.setText("");
	}

	// ------------------------------------------------------------------------
	// Tab05
	public void Tab05ButtonA01Action(ActionEvent event) {
		ms.executeSystemGc();
	}

	public void Tab05ButtonA02Action(ActionEvent event) {
		Tab05LabelB02.setText(ms.getRuntime());
	}

	// ------------------------------------------------------------------------
	// Tab06

	// https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/

	private List<TableColumn<ObservableList, String>> ltcSauvegarde = FXCollections.observableArrayList();

	@FXML
	void Tab06ButtonB01Action(ActionEvent event) {
		Tab06LabelB02.setText("192.168.1.12");
		Tab06LabelB03.setText("root");
		Tab06PasswordFieldB04.setText("1a2b3c4d");
		Tab06LabelB05.setText("");
		Tab06LabelB06.setText("");
		Tab06LabelB07.setText("SELECT * FROM code_test.utilisateurs;");
	}

	@FXML
	void Tab06ButtonB08Action(ActionEvent event) {

		boolean verificationFormulaire = true;

		if (Tab06LabelB02.getText().length() == 0) {
			verificationFormulaire = false;
		}
		if (Tab06LabelB03.getText().length() == 0) {
			verificationFormulaire = false;
		}
		if (Tab06PasswordFieldB04.getText().length() == 0) {
			verificationFormulaire = false;
		}

		if (verificationFormulaire == true) {
			try {
				MySQLCnx.setBddServeur(Tab06LabelB02.getText());
				MySQLCnx.setBddUtilisateur(Tab06LabelB03.getText());
				MySQLCnx.setBddMdp(Tab06PasswordFieldB04.getText());
				MySQLCnx.setBddNom(Tab06LabelB05.getText());
				MySQLCnx.setBddOptions(Tab06LabelB06.getText());

				Connection cnx = MySQLCnx.getConnexion();

				if (Tab06LabelB07.getText().length() > 0) {

					Tab06TableViewC05.getColumns().removeAll(ltcSauvegarde);

					Statement st01 = cnx.createStatement();
					ResultSet rs01 = st01.executeQuery(Tab06LabelB07.getText());
					ResultSetMetaData rsm01 = rs01.getMetaData();
					Tab06TextAreaC02.setText(rsm01.toString());
					int nbrColumn = rsm01.getColumnCount();

					// Créer la liste de colonnes et le modele qui va avec dans le tableView
					List<TableColumn<ObservableList, String>> listeTableViewColumn = FXCollections
							.observableArrayList();
					for (int i = 0; i < nbrColumn; i++) {
						TableColumn tc = new TableColumn<LigneResultat, String>(rsm01.getColumnName(i + 1));
						tc.setCellValueFactory(new PropertyValueFactory<>("col" + (i + 1)));
						listeTableViewColumn.add(tc);
					}

					Tab06TableViewC05.getColumns().addAll(listeTableViewColumn);
					ltcSauvegarde = listeTableViewColumn;

					// Remplir le tableau de données List<LigneResultat> llr = new
					ObservableList<LigneResultat> listeResultatRequeteSQL = FXCollections.observableArrayList();
					nbrColumn = rsm01.getColumnCount();
					while (rs01.next()) {
						LigneResultat lr = new LigneResultat();
						for (int i = 1; i <= nbrColumn; i++) {
							switch (rsm01.getColumnType(i)) {
							case 4:
								lr.addString(Integer.toString(rs01.getInt(i)));
								break;
							case 12:
								lr.addString(rs01.getString(i));
								break;
							case 93:
								lr.addString(rs01.getDate(i).toString());
								break;
							}
						}
						listeResultatRequeteSQL.addAll(lr);
					}
					// Initialiser le tableView avec les données.
					System.out.println(listeResultatRequeteSQL.toString());
					Tab06TableViewC05.setItems(listeResultatRequeteSQL);

					rs01.close();
					st01.close();
				}
				// cnx.close();

			} catch (Exception e) {
				System.err.println(
						getClass().getName() + " : An error occured.\n" + e.getMessage() + "\n" + e.getStackTrace());
			}
		}

	}

}
