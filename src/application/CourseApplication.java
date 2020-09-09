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
	import service.CourseService;
	import entity.Course;
	public class CourseApplication extends Application {
	  private Button btView = new Button("记录查找");
	  private Button btInsert = new Button("记录插入");
	  private Button btUpdate = new Button("记录更新");
	  private Button btClear = new Button("记录清空");
	  private TextField tfID = new TextField();
	  private TextField tfNum = new TextField();
	  private TextField tfName = new TextField();
	  private TextField tfCredit = new TextField();
	  private Label lblStatus = new Label();
	  private Statement stmt;
	  @Override
	  public void start(Stage primaryStage) {
	    VBox vBox = new VBox(5);  
	    HBox hBox1 = new HBox(5);
	    hBox1.getChildren().addAll(new Label("  您的ID  "), tfID);
	    HBox hBox2 = new HBox(5);
	    hBox2.getChildren().addAll(new Label(" 您的学号"), tfNum);
	    HBox hBox3 = new HBox(5);
	    hBox3.getChildren().addAll(new Label(" 您的姓名"), tfName);
	    HBox hBox4 = new HBox(5);
	    hBox4.getChildren().addAll(new Label(" 您的成绩"), tfCredit);
	    tfNum.setPrefColumnCount(8);
	    tfName.setPrefColumnCount(8);
	    tfID.setPrefColumnCount(8);
	    tfCredit.setPrefColumnCount(8);
	    vBox.getChildren().addAll(hBox1, hBox2,hBox3,hBox4);
	    HBox hBox5 = new HBox(5);
	    hBox5.getChildren().addAll(btView, btInsert, btUpdate, btClear);
	    hBox5.setAlignment(Pos.CENTER);
	    BorderPane pane = new BorderPane();
	    pane.setTop(vBox);
	    pane.setCenter(hBox5);
	    pane.setBottom(lblStatus);
	    Scene scene = new Scene(pane, 400, 200);
	    primaryStage.setTitle("何子康课程系统"); 
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
		  CourseService hzkhzk = new CourseService();
		  String courseName=new String();
		hzkhzk.selectByName(courseName);
		CourseService hzkhzkhzk = new CourseService();
		  String num=new String();
		hzkhzkhzk.selectByNum(num);
	    }
	  
	  private void loadToTextField(ResultSet rs) throws SQLException {
	    if (rs.next()) {
	    	tfID.setText(rs.getString(1));
	      tfNum.setText(rs.getString(2));
	      tfName.setText(rs.getString(3));
	      tfCredit.setText(rs.getString(4));
	      lblStatus.setText("Record found");
	    }
	    else
	      lblStatus.setText("Record not found");
	  }
	  private void insert() {
		  CourseService hzk = new CourseService();
		  Course course=new Course();
		  hzk.addCourse(course);
	  }
	  private void update() {
		  CourseService hzkkk = new CourseService();
		  Course course=new Course();
		  int id =10;
		hzkkk.modifyCourse(id,course);
	  }
	  private void clear() {
	    tfID.setText(null);
	    tfNum.setText(null);
	    tfName.setText(null);
	    tfCredit.setText(null);
	  }
	  public static void main(String[] args) {
	    launch(args);
	  }
	}


