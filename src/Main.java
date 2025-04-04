import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {

    private Map<String, MyShape> shapeMap = new HashMap<>();
    private List<MyShape> shapeList = new ArrayList<>();
    private int shapeCounter = 1;

    private Pane canvas = new Pane();
    private ListView<String> shapeListView = new ListView<>();
    private ComboBox<String> filterBox = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        Button addShapeBtn = new Button("Add Random Shape");

        filterBox.getItems().addAll("All", "MyCircle", "MyRectangle", "MyTriangle");
        filterBox.setValue("All");

        addShapeBtn.setOnAction(e -> {
            MyShape shape = getRandomShape();
            String name = "Shape " + shapeCounter++;
            shapeMap.put(name, shape);
            shapeList.add(shape);
            shapeListView.getItems().add(name);
            shape.draw(canvas);
        });

        filterBox.setOnAction(e -> {
            String type = filterBox.getValue();
            shapeListView.getItems().clear();
            for (Map.Entry<String, MyShape> entry : shapeMap.entrySet()) {
                if (type.equals("All") || entry.getValue().getClass().getSimpleName().equals(type)) {
                    shapeListView.getItems().add(entry.getKey());
                }
            }
        });

        shapeListView.setOnMouseClicked(e -> {
            String name = shapeListView.getSelectionModel().getSelectedItem();
            if (name != null) {
                MyShape selected = shapeMap.get(name);
                canvas.getChildren().clear();
                for (MyShape s : shapeList) s.draw(canvas);
                selected.highlight(canvas);
            }
        });

        VBox controls = new VBox(10, addShapeBtn, filterBox, shapeListView);
        HBox root = new HBox(10, controls, canvas);
        root.setStyle("-fx-padding: 20");

        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("Shape Gallery with JCF");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MyShape getRandomShape() {
        double x = Math.random() * 500;
        double y = Math.random() * 300;
        int r = (int)(Math.random() * 3);
        return switch (r) {
            case 0 -> new MyCircle(x, y);
            case 1 -> new MyRectangle(x, y);
            default -> new MyTriangle(x, y);
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}