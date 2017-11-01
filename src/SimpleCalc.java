import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.*; // ActionEvent, EventHandler
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SimpleCalc extends Application {
	
	Button[] op = {new Button("+"), new Button("-"),
			new Button("*"), new Button("/")};
	TextField in1, in2;
	Label ansLabel;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		ansLabel = new Label();
		in1 = new TextField();
		in2 = new TextField();
		OperationsFactory opFact = new OperationsFactory();
		//Operations o = null;
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		ansLabel.setAlignment(Pos.CENTER);
		
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));
		root.add(op[0], 0, 0);
		root.add(op[1], 1, 0);
		root.add(op[2], 0, 1);
		root.add(op[3], 1, 1);
		//root.add(op[4], 0, 4);
		root.add(in1, 0, 2);
		root.add(in2, 1, 2);
		root.add(ansLabel, 0, 3, 2, 1);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		
		for (Button b : op) {
			b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int n1 = 0, n2 = 0,ans = 0;
				try {
					n1 = Integer.parseInt(in1.getText());
					n2 = Integer.parseInt(in2.getText());
				} catch (Exception e1) {
					ansLabel.setText("Input is not a number");
					primaryStage.show();
					return;
				}
				try {
					if (e.getSource() == op[0]) 
						ans = opFact.getOperations("add").result(n1, n2);
					 else if (e.getSource() == op[1]) 
						ans = opFact.getOperations("sub").result(n1, n2);
					 else if (e.getSource() == op[2])
						ans = opFact.getOperations("mult").result(n1, n2);
					 else if (e.getSource() == op[3]) 
						ans = opFact.getOperations("div").result(n1, n2);
					 
					ansLabel.setText(""+ans);
				} catch (ArithmeticException e1) {
					ansLabel.setText("Math Error");
				}
			}});
		}
		primaryStage.show();
	}
	

}
