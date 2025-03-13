import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private double temperature;
    private double humidity;
    private double windSpeed;
    private List<WeatherObserver> observers = new ArrayList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.weatherChanged();
        }
    }

    // TODO: Implement these methods
    public void setTemperature(double temperature) {
        // Update temperature and notify observers
        this.temperature = temperature;
        notifyObservers();
    }

    public void setHumidity(double humidity) {
        // Update humidity and notify observers
        this.humidity = humidity;
        notifyObservers();
    }

    public void setWindSpeed(double windSpeed) {
        // Update wind speed and notify observers
        this.windSpeed = windSpeed;
        notifyObservers();
    }

    // Getter methods
    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getWindSpeed() { return windSpeed; }
}
