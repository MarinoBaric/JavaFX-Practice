import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class WeatherController implements EventHandler<ActionEvent> {
    private WeatherStation weatherStation;
    private Button updateButton;
    private Button resetButton;
    private Button closeButton;

    public WeatherController(WeatherStation weatherStation,Button updateButton, Button resetButton, Button closeButton) {
        this.weatherStation = weatherStation;
        this.updateButton = updateButton;
        this.resetButton = resetButton;
        this.closeButton = closeButton;
        
    }

    @Override
    public void handle(ActionEvent event) {
        // TODO: Implement event handling for updating weather data

        double min = 15.00;
        double max = 35.00;

        Random random = new Random();
        double randTemp = random.nextDouble();
        double randTempReal = min + (randTemp*(max-min));
        double roundedTemp = (Math.round(randTempReal * 100))/100.0;

        double minH = 0.00;
        double maxH = 100.00;
        double humidity = random.nextDouble();
        double randHum = minH + (humidity * (maxH-minH));
        double roundedHum = (Math.round(randHum * 100))/100.0;

        double minS = 0.00;
        double maxS = 50.00;
        double windSpeed = random.nextDouble();
        double randSpeed = minS + (windSpeed * (maxS - minS));
        double roundedSpeed = (Math.round(randSpeed * 100))/100.0;


        if(event.getSource() == updateButton){
            weatherStation.setTemperature(roundedTemp);
            weatherStation.setHumidity(roundedHum);
            weatherStation.setWindSpeed(roundedSpeed);
        } else if(event.getSource() == closeButton){
            Platform.exit();;
        } else if(event.getSource() == resetButton){
            weatherStation.setTemperature(20);
        }
    }
}
