package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.CustomerOrderTable;
import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.SalesOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CustomerHomepageController {
	@FXML
	private MenuItem orderMenuSub;

	@FXML
	private JFXButton btItem;

	@FXML
	private MenuItem orderMenuBusiness;

	@FXML
<<<<<<< HEAD
<<<<<<< HEAD
	private TableColumn<CustomerOrderTable, String> orderBusinessCol;
=======
	private AnchorPane cusOrderPane1;
>>>>>>> parent of 70e0b49... Big update æœ‰headäº†
=======
	private TableColumn<CustomerOrderTable, String> orderBusinessCol;
>>>>>>> parent of 9dca3b2... Merge branch 'master' of https://github.com/TTEAMM/orderSystem

	@FXML
	private MenuItem orderMenuItem;

	@FXML
	private JFXButton btCart;

	@FXML
	private TableColumn<CustomerOrderTable, String> orderItemCol;

	@FXML
	private MenuItem orderMenuDate;

	@FXML
	private Label LabText;

	@FXML
	private TableColumn<CustomerOrderTable, String> orderDateCol;

	@FXML
	private JFXButton btUser;

	@FXML
	private TableColumn<CustomerOrderTable, Integer> orderSubCol;

	@FXML
	private JFXTextField tfSearch;

	@FXML
	private JFXButton btAddCart;

	@FXML
	private AnchorPane cusOrderPane;

	@FXML
	private AnchorPane cusItemPane;

	@FXML
	private TableView<CustomerOrderTable> customerOrderTable;

	@FXML
	private TableColumn<CustomerOrderTable, Integer> orderQuantityCol;

	@FXML
	private JFXTextField tfSearchOrder;

	@FXML
	private JFXButton btSearchOrder;

	@FXML
	private MenuButton orderMenuBtn;

	@FXML
	private JFXButton btOrder;

	@FXML
	private JFXButton btLogout;
	@FXML
	private JFXRadioButton orderItemRad;
	@FXML
	private JFXRadioButton orderBusinessRad;
	@FXML
	private JFXButton btSearch;
	@FXML
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 9dca3b2... Merge branch 'master' of https://github.com/TTEAMM/orderSystem
	private TableColumn<CustomerOrderTable, Integer> orderNumberCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderStatusCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderCommentCol;
<<<<<<< HEAD
=======
	private JFXButton btConfirmreceipt;
>>>>>>> parent of 70e0b49... Big update æœ‰headäº†
=======
>>>>>>> parent of 9dca3b2... Merge branch 'master' of https://github.com/TTEAMM/orderSystem
	// ´´½¨²¢³õÊ¼»¯Êý¾Ý

	public void initialize() throws SQLException {
		orderNumberCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("salesOrderNumber"));
		orderQuantityCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("quantity"));
		orderStatusCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("status"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("orderDate"));
		orderCommentCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("comment"));
		orderSubCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("subTotal"));
		orderItemCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("itemName"));
		orderBusinessCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("Business"));
	}

	ObservableList<CustomerOrderTable> cellData = FXCollections.observableArrayList();

	public static void main(String[] args) throws SQLException {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder";
		ArrayList<SalesOrder> list = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
				new BeanListHandler<SalesOrder>(SalesOrder.class));
		System.out.println(list.get(0).getOrderDate());
		// initOrderSearch();

	}

	public void initOrderSearch() {
<<<<<<< HEAD
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(true);
=======
>>>>>>> parent of 70e0b49... Big update æœ‰headäº†
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder where customerid =" + NowInf.customer.getCustomerId();
		try {
			cellData.clear();
			ArrayList<SalesOrder> orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			CustomerOrderTable[] t = convertToCustomerOrderTable(orderlist);

			cellData.addAll(t);
			customerOrderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CustomerOrderTable[] convertToCustomerOrderTable(ArrayList<SalesOrder> orderlist) {
		CustomerOrderTable[] t = new CustomerOrderTable[orderlist.size()];
		for (int i = 0; i < orderlist.size(); i++) {
			t[i] = new CustomerOrderTable();
		}
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql1 = "select BusinessName from business where businessId=?";
		String sql2 = "select Name from Product where ProductId=?";
		Object[] para = new Object[1];
		Object[] tmp = null;
		try {
			for (int i = 0; i < orderlist.size(); i++) {
				para[0] = orderlist.get(i).getBusinessId();
				tmp = qr.query(db.getConnection(), sql1, para, new ArrayHandler());
				t[i].setBusiness(tmp[0].toString());
				para[0] = orderlist.get(i).getProductId();
				tmp = qr.query(db.getConnection(), sql2, para, new ArrayHandler());
				t[i].setItemName(tmp[0].toString());
				t[i].setComment(orderlist.get(i).getComment());
				t[i].setOrderDate(orderlist.get(i).getOrderDate());
				t[i].setQuantity(orderlist.get(i).getQuantity());
				t[i].setSalesOrderNumber(orderlist.get(i).getSalesOrderNumber());
				t[i].setStatus(orderlist.get(i).getStatus());
				t[i].setSubTotal(orderlist.get(i).getSubTotal());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public void orderSearch() {
		try {
			cellData.clear();
			String key = tfSearchOrder.getText();
			key = "%" + key + "%";
			Object[] para = new Object[2];
			para[0] = key;
			para[1] = NowInf.customer.getCustomerId();
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			String sql = "";
			if (orderBusinessRad.isSelected()) {
				sql = "SELECT salesOrderId,business.businessId,productId,customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM business , salesorder WHERE businessName LIKE ? AND business.BusinessID =salesorder.BusinessID and CustomerID=?";
			} else {
				sql = "SELECT salesOrderId,salesorder.businessId,salesorder.productId,customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM product , salesorder WHERE product.NAME LIKE ? AND product.ProductID =salesorder.ProductID and  CustomerID=?";
			}
			ArrayList<SalesOrder> orderlist;
			orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql, para,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			// System.out.println(orderlist.get(0).getCustomerId());
			CustomerOrderTable[] t = convertToCustomerOrderTable(orderlist);
			cellData.addAll(t);
			customerOrderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void OOrderItemRad() {

		orderBusinessRad.setSelected(false);
	}

	public void OOrderBusinessRad() {

		orderItemRad.setSelected(false);
	}
	
	public void btItems() {
		cusItemPane.setVisible(true);
		cusOrderPane.setVisible(false);
		//cusOrderPane1.setVisible(false);
	}
	
	

	
}
