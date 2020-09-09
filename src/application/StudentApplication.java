package application;
	
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.StudentService;
import entity.Student;
public class StudentApplication extends Application {
  private Button btView = new Button("记录查找");
  private Button btInsert = new Button("记录插入");
  private Button btUpdate = new Button("记录更新");
  private Button btClear = new Button("记录清空");
  private TextField tfID = new TextField();
  private TextField tfNum = new TextField();
  private TextField tfName = new TextField();
  private TextField tfBirthday = new TextField();
  private TextField tfDepartment = new TextField();
  private Label lblStatus = new Label();
  private Statement stmt;
  @Override
  public void start(Stage primaryStage) {
    VBox vBox = new VBox(5);  
    HBox hBox1 = new HBox(5);
    hBox1.getChildren().addAll(new Label("  您的ID  "), tfID);
    HBox hBox2 = new HBox(5);
    hBox2.getChildren().addAll(new Label(" 您的学号"), tfNum,new Label(" 您的姓名"), tfName);
    HBox hBox3 = new HBox(5);
    hBox3.getChildren().addAll(new Label(" 您的生日"), tfBirthday,new Label(" 您的班级"), tfDepartment);
    tfNum.setPrefColumnCount(8);
    tfName.setPrefColumnCount(8);
    tfID.setPrefColumnCount(8);
    tfBirthday.setPrefColumnCount(8);
    tfDepartment.setPrefColumnCount(8);
    vBox.getChildren().addAll(hBox1, hBox2,hBox3);
    HBox hBox5 = new HBox(5);
    hBox5.getChildren().addAll(btView, btInsert, btUpdate, btClear);
    hBox5.setAlignment(Pos.CENTER);
    BorderPane pane = new BorderPane();
    pane.setTop(vBox);
    pane.setCenter(hBox5);
    pane.setBottom(lblStatus);
    Scene scene = new Scene(pane, 450, 200);
    primaryStage.setTitle("何子康学生系统"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
    initializeDB();
    btView.setOnAction(e -> view());
    btInsert.setOnAction(e -> insert());
    btUpdate.setOnAction(e -> update());
    btClear.setOnAction(e -> clear()); 
  }
  private void initializeDB() {
    try {     
      Connection conn = DriverManager.getConnection
        ("jdbc:mysql://localhost/hzk", "root", "123456");
      System.out.println("Database connected\n");
      lblStatus.setText("Database connected");
      stmt = conn.createStatement();
    }
    catch (Exception ex) {
      lblStatus.setText("Connection failed: " + ex);
    }
  }
  private void view() {
	  StudentService hzkhzk = new StudentService();
	  String studentName=new String();
	hzkhzk.selectByName(studentName);
	StudentService hzkhzkhzk = new StudentService();
	  String num=new String();
	hzkhzkhzk.selectByNum(num);
    }
  
  private void loadToTextField(ResultSet rs) throws SQLException {
    if (rs.next()) {
    	tfID.setText(rs.getString(1));
      tfNum.setText(rs.getString(2));
      tfName.setText(rs.getString(3));
      tfBirthday.setText(rs.getString(4));
      tfDepartment.setText(rs.getString(5));
      lblStatus.setText("Record found");
    }
    else
      lblStatus.setText("Record not found");
  }
  private void insert() {
	  StudentService hzk = new StudentService();
	  Student student=new Student();
	  hzk.addStudent(student);
  }
  private void update() {
	  StudentService hzkkk = new StudentService();
	  Student student=new Student();
	  int id =10;
	hzkkk.modifyStudent(id,student);
  }
  private void clear() {
    tfID.setText(null);
    tfNum.setText(null);
    tfName.setText(null);
    tfBirthday.setText(null);
    tfDepartment.setText(null);
  }
  public static void main(String[] args) {
    launch(args);
  }
}
