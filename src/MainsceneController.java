import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.util.EscapeTokenizer;
import com.mysql.cj.xdevapi.Statement;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.*;
import java.sql.*;

public class MainsceneController implements Initializable {

    @FXML
    private Button btnadd;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<Course, String> coursecolumn;

    @FXML
    private TableColumn<Course, Integer> idcoulmn;

    @FXML
    private TableColumn<Course, Integer> mobilecolumn;

    @FXML
    private TableColumn<Course, String> namecloumn;

    @FXML
    private TableView<Course> table;

    @FXML
    private TextField txtcourse;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtname;

    @FXML
    void add(ActionEvent event) {
        System.out.println("you click me");
        insertRecord();
    }

    @FXML
    void delete(ActionEvent event) {
        System.out.println("you clicked delete");
        deleteRecord();
    }

    @FXML
    void update(ActionEvent event) {
        System.out.println("you clicked update");
        updateRecord();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        showBooks();
        
    }
    public Connection getConnection(){
        Connection conn;
        String url="jdbc:mysql://localhost:3306/dearam";
		String name="root";
		String password="dearam8114";
        try{
            conn=DriverManager.getConnection(url,name, password);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Course> getCourseList(){
        ObservableList<Course> courseList=FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from courses";
        java.sql.Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
            Course c;
            while(rs.next()){
                c=new Course(rs.getInt("id"),rs.getString("name"),rs.getInt("mobile"),rs.getString("course"));
                courseList.add(c);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }
    public void showBooks(){
        ObservableList<Course> list = getCourseList();
        idcoulmn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("id"));
        namecloumn.setCellValueFactory(new PropertyValueFactory<Course,String>("name"));;
        mobilecolumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("mobile"));
        coursecolumn.setCellValueFactory(new PropertyValueFactory<Course,String>("course"));;
        table.setItems(list);
    }
    private void insertRecord(){
        String query="insert into courses values("+txtid.getText()+",'"+txtname.getText()+"',"+txtmobile.getText()+",'"+txtcourse.getText()+"')";
        executeQuery(query);
    }
    private void updateRecord(){
        String query="update courses set name='"+txtname.getText()+"',mobile='"+txtmobile.getText()+"',course='"+txtcourse.getText()+"' where id="+txtid.getText();
        executeQuery(query);
    }
    private void deleteRecord(){
        String query="delete from courses where id="+txtid.getText();
        executeQuery(query);
    }
    public void executeQuery(String q){
        Connection conn = getConnection();
        java.sql.Statement st;
        try{
            st=conn.createStatement();
            st.executeUpdate(q);
        }catch(Exception e){
            e.printStackTrace();
        }
        showBooks();
    }
}
