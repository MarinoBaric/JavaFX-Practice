
---

# **Mid-Term Exam - GUI Development Assignment**
**Course:** Graphical User Interfaces (GUI)  
**Total Points:** 100  
**Time Limit:** 90 Minutes  

---

## **Instructions**
You are provided with a partially implemented **JavaFX Weather Monitoring System**. Your task is to complete and integrate the provided GUI class (`WeatherStationGUI.java`) with the **model** (`WeatherStation.java`) and **controller** (`WeatherController.java`) classes. This assignment follows the **Model-View-Controller (MVC) pattern**.

You must:
1. **Modify the GUI** to display real-time weather updates.
2. **Link the GUI to the controller** to handle user interactions.
3. **Implement missing methods** in `WeatherStation.java` to fetch and update temperature, humidity, and wind speed.
4. **Ensure the observer pattern is followed** so that the GUI updates when the model changes.

---

## **Provided Files**
- **`WeatherStationGUI.java`** (View) – Displays temperature, humidity, wind speed.
- **`WeatherStation.java`** (Model) – Stores weather data.
- **`WeatherController.java`** (Controller) – Handles interactions.
- **`WeatherObserver.java`** (Interface) – Implements Observer pattern.

---

## **Tasks**  
### **1. Modify `WeatherStation.java` (Model) (20 points)**
- Add **private variables**:  
  ```java
  private double temperature;
  private double humidity;
  private double windSpeed;
  ```
- Implement the following methods:
  ```java
  public void setTemperature(double temperature) { /* Update and notify */ }
  public void setHumidity(double humidity) { /* Update and notify */ }
  public void setWindSpeed(double windSpeed) { /* Update and notify */ }
  ```
- Ensure `notifyObserver()` is called whenever a value is changed.

---

### **2. Implement `WeatherController.java` (Controller) (20 points)**
- Modify it to handle button clicks for **updating weather conditions**.
- Implement event handling to call:
  ```java
  weatherStation.setTemperature(...);
  weatherStation.setHumidity(...);
  weatherStation.setWindSpeed(...);
  ```

---

### **3. Modify `WeatherStationGUI.java` (View) (20 points)**
- **Ensure it updates** when weather conditions change.
- **Modify labels** to reflect real-time temperature, humidity, and wind speed:
  ```java
  temperatureLabel.setText("Temperature: " + weatherStation.getTemperature() + "°C");
  humidityLabel.setText("Humidity: " + weatherStation.getHumidity() + "%");
  windSpeedLabel.setText("Wind Speed: " + weatherStation.getWindSpeed() + " km/h");
  ```
- Ensure it implements `WeatherObserver`.

---

### **4. Implement the Observer Pattern (15 points)**
- Modify `WeatherStation` to **notify observers** when weather data changes.
- `WeatherStationGUI` must implement `WeatherObserver` and update labels.

---

### **5. Implement Buttons and Event Handling (15 points)**
- Add three buttons:
  ```java
  Button updateWeatherButton = new Button("Update Weather");
  Button resetButton = new Button("Reset");
  Button closeButton = new Button("Exit");
  ```
- **Connect them** to appropriate event handlers:
  - `updateWeatherButton`: Simulate fetching new weather data.
  - `resetButton`: Reset temperature, humidity, wind speed.
  - `closeButton`: Close the application.

---

## **BONUS (10 points)**
- Implement a **random weather generator** to simulate **real-time weather updates** every **5 seconds**:
  ```java
  Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
      weatherStation.setTemperature(generateRandomTemperature());
      weatherStation.setHumidity(generateRandomHumidity());
      weatherStation.setWindSpeed(generateRandomWindSpeed());
  }));
  timeline.setCycleCount(Animation.INDEFINITE);
  timeline.play();
  ```

---

## **Submission Requirements**
- Submit the completed **`WeatherStation.java`**, **`WeatherController.java`**, and **`WeatherStationGUI.java`**.
- Ensure **code compiles and runs without errors**.
- Follow the **MVC architecture** correctly.
- Make sure the **GUI updates dynamically** when the model changes.

---

## **Expected GUI Output**
| **Scenario** | **Example Display** |
|-------------|---------------------|
| **Initial State** | `Temperature: 22°C, Humidity: 60%, Wind Speed: 5 km/h` |
| **User Clicks Update** | `Temperature: 25°C, Humidity: 55%, Wind Speed: 8 km/h` |
| **Random Weather Generator Active** | GUI updates automatically every 5 sec |

---

### **End of Assignment**
This **mid-term exam** challenges your understanding of **JavaFX, MVC, event handling, and the Observer pattern**—making it more difficult than **Practice Practical 2** but in line with your professor’s expectations. Let me know if you need modifications! 🚀