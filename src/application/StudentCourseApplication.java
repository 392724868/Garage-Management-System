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
	import service.StudentCourseService;
	import entity.StudentCourse;
	public class StudentCourseApplication extends Application {
	  private Button btView = new Button("记录查找");
	  private Button btInsert = new Button("记录插入");
	  private Button btUpdate = new Button("记录更新");
	  private Button btClear = new Button("记录清空");
	  private TextField tfID = new TextField();
	  private TextField tfSnum = new TextField();
	  private TextField tfCnum = new TextField();
	  private Label lblStatus = new Label();
	  private Statement stmt;
	  @Override
	  public void start(Stage primaryStage) {
	    VBox vBox = new VBox(5);  
	    HBox hBox1 = new HBox(5);
	    hBox1.getChildren().addAll(new Label("  您的ID  "), tfID);
	    HBox hBox2 = new HBox(5);
	    hBox2.getChildren().addAll(new Label(" 您的学生号"), tfSnum);
	    HBox hBox3 = new HBox(5);
	    hBox3.getChildren().addAll(new Label(" 您的课程号"), tfCnum);
	    tfSnum.setPrefColumnCount(8);
	    tfCnum.setPrefColumnCount(8);
	    tfID.setPrefColumnCount(8);
	    vBox.getChildren().addAll(hBox1, hBox2,hBox3);
	    HBox hBox5 = new HBox(5);
	    hBox5.getChildren().addAll(btView, btInsert, btUpdate, btClear);
	    hBox5.setAlignment(Pos.CENTER);
	    BorderPane pane = new BorderPane();
	    pane.setTop(vBox);
	    pane.setCenter(hBox5);
	    pane.setBottom(lblStatus);
	    Scene scene = new Scene(pane, 400, 200);
	    primaryStage.setTitle("何子康学生课程系统"); 
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
		  StudentCourseService hzkhzk = new StudentCourseService();
		  String snum=new String();
		hzkhzk.selectBySnum(snum);
		StudentCourseService hzkhzkhzk = new StudentCourseService();
		  String cnum=new String();
		hzkhzkhzk.selectByCnum(cnum);
	    }
	  
	  private void loadToTextField(ResultSet rs) throws SQLException {
	    if (rs.next()) {
	    	tfID.setText(rs.getString(1));
	      tfCnum.setText(rs.getString(2));
	      tfSnum.setText(rs.getString(3));
	      lblStatus.setText("Record found");
	    }
	    else
	      lblStatus.setText("Record not found");
	  }
	  private void insert() {
		  StudentCourseService hzk = new StudentCourseService();
		  StudentCourse studentcourse=new StudentCourse();
		  hzk.addStudentCourse(studentcourse);
	  }
	  private void update() {
		  StudentCourseService hzkkk = new StudentCourseService();
		  StudentCourse studentcourse=new StudentCourse();
		  int id =10;
		hzkkk.modifyStudentCourse(id,studentcourse);
	  }
	  private void clear() {
	    tfID.setText(null);
	    tfCnum.setText(null);
	      tfSnum.setText(null);
	  }
	  public static void main(String[] args) {
	    launch(args);
	  }
	}


