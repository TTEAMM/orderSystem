package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.MenuBar;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Menu;

public class CustomerHpController {
	@FXML
	private AnchorPane CusHomepage;
	@FXML
	private MenuBar mnBar;
	@FXML
	private Menu mnUserName;
	@FXML
	private Menu mnItems;
	@FXML
	private Menu mnOrders;
	@FXML
	private Menu mnLogOut;
	@FXML
	private Label lbUserName;
	@FXML
	private Label lbID;
	@FXML
	private Label lbPhoneNum;
	@FXML
	private Label lbEmail;
	@FXML
	private TextField txUserName;
	@FXML
	private TextField txID;
	@FXML
	private TextField txPhoneNumber;
	@FXML
	private TextField txEmail;

}
