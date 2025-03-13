import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherStationGUI extends Application implements WeatherObserver {
    private WeatherStation weatherStation;
    private Label temperatureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Button updateButton;
    private Button resetButton;
    private Button closeButton;

    @Override
    public void start(Stage stage) {
        weatherStation = new WeatherStation();
        weatherStation.addObserver(this);

        temperatureLabel = new Label("Temperature: -- °C");
        humidityLabel = new Label("Humidity: -- %");
        windSpeedLabel = new Label("Wind Speed: -- km/h");

        updateButton = new Button("Update Weather");
        resetButton = new Button("Reset");
        closeButton = new Button("Exit");

        // Attach buttons to the controller
        WeatherController controller = new WeatherController(weatherStation, updateButton, resetButton, closeButton);
        updateButton.setOnAction(controller);
        resetButton.setOnAction(controller);
        closeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10, temperatureLabel, humidityLabel, windSpeedLabel,
                new HBox(10, updateButton, resetButton, closeButton));
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        stage.setTitle("Weather Monitoring System");
        stage.setScene(new Scene(layout, 350, 250));
        stage.show();
    }

    @Override
    public void weatherChanged() {
        temperatureLabel.setText("Temperature: " + weatherStation.getTemperature() + "°C");
        humidityLabel.setText("Humidity: " + weatherStation.getHumidity() + "%");
        windSpeedLabel.setText("Wind Speed: " + weatherStation.getWindSpeed() + " km/h");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
