package application.dataClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.jfoenix.controls.JFXButton;

import application.frameClass.ShowItemDetailFrame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VBoxItemForCus extends VBox {

	private ImageView im = new ImageView();
	private Label lbItem = new Label();
	private Label lbBusiness = new Label();
	private JFXButton btAddToCart = new JFXButton("AddtoCart");
	private JFXButton btDetail = new JFXButton("View Detail");
	private HBox hb1 = new HBox();
	private HBox hb2 = new HBox();
	private Label lbPrice = new Label();
	private int itemId;

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public VBoxItemForCus() {
	}

	public VBoxItemForCus(String picname, String name, String business, double price) {
		DropShadow ds1 = new DropShadow();
		ds1.setOffsetY(4.0f);
		ds1.setOffsetX(4.0f);
		ds1.setColor(Color.web("#f2e3e3"));
		this.setAlignment(Pos.TOP_CENTER);
		this.setEffect(ds1);
		this.setPrefHeight(270);
		this.setMaxHeight(270);
		this.setPrefWidth(190);
		this.setMaxWidth(190);
		this.setSpacing(10);
		this.getStyleClass().add("VBox-item");
		// this.setMargin(getParent(), new Insets(0, 10, 0, 10));
		this.setStyle("-fx-background-color:white;");
		im.setFitWidth(190);
		im.setFitHeight(184);
		NowInf.setPicView(im, "item/" + picname);
		// lbItem.setFont(Font.font("Verdana", 15));
		lbItem.setAlignment(Pos.CENTER_LEFT);
		lbItem.setPrefWidth(191);
		lbItem.setPrefHeight(44);
		lbItem.setText(name);
		hb1.setStyle("-fx-border-color:#BFBFBF white  white  white");
		lbBusiness.setText(business);
		lbBusiness.setAlignment(Pos.CENTER_LEFT);
		lbBusiness.setPrefSize(139, 44);
		lbPrice.setPrefSize(86, 17);
		lbPrice.setText("$" + price);
		btAddToCart.setPrefSize(95, 33);
		btAddToCart.setStyle("-fx-background-color:#39C164");
		btDetail.setStyle("-fx-background-color:#39C164");
		btDetail.setPrefSize(95, 33);
		hb1.getChildren().addAll(lbBusiness, lbPrice);
		hb2.getChildren().addAll(btAddToCart, btDetail);
		this.getChildren().addAll(im, lbItem, hb1, hb2);
		btAddToCart.setOnAction(e -> {
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			Object[] p = new Object[2];
			p[0] = NowInf.customer.getCustomerId();
			p[1] = itemId;
			try {
				String sql1 = "select count(*)from cart where customerid=? and productid=?";
				Object[] result = qr.query(db.getConnection(), sql1, p, new ArrayHandler());
				int a = Integer.parseInt(result[0].toString());
				if (a == 1) {
					NowInf.showAlert("Item has been added", "information");
					return;
				}
				String sql = "insert into cart (customerid,productid) VALUES(?,?)";
				qr.update(Db.getConnection(), sql, p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btDetail.setOnAction(e -> {
			new ShowItemDetailFrame(itemId);
		});

	}

}
