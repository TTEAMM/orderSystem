package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterAsCustomerFrame {
	public RegisterAsCustomerFrame() {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//RegisterAsCustomer.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Register As Customer");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}