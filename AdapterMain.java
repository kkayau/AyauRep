public class AdapterMain {
    public static void main(String[] args) {
        WeatherService openWeatherMap = new OpenWeatherMapAPI();
        WeatherService openWeatherMapAdapter = new WeatherAPIAdapter(openWeatherMap);

        WeatherService accWeather = new AccurateWeatherAPI();
        WeatherService accWeatherAdapter = new WeatherAPIAdapter(accWeather);

        WeatherData data1 = openWeatherMapAdapter.getWeather("New York");
        WeatherData data2 = accWeatherAdapter.getWeather("Los Angeles");

        System.out.println("OpenWeatherMap Data:");
        System.out.println("Location: " + data1.getLocation());
        System.out.println("Temperature: " + data1.getTemperature() + "°C");
        System.out.println("Condition: " + data1.getCondition());

        System.out.println("\nAccuWeather Data:");
        System.out.println("Location: " + data2.getLocation());
        System.out.println("Temperature: " + data2.getTemperature() + "°C");
        System.out.println("Condition: " + data2.getCondition());
    }
}
 class WeatherData {
    private String location;
    private double temperature;
    private String condition;

     public String getLocation() {
         return location;
     }

     public void setLocation(String location) {
         this.location = location;
     }

     public double getTemperature() {
         return temperature;
     }

     public void setTemperature(double temperature) {
         this.temperature = temperature;
     }

     public String getCondition() {
         return condition;
     }

     public void setCondition(String condition) {
         this.condition = condition;
     }
}
 interface WeatherService{
     WeatherData getWeather(String location);
}
 class OpenWeatherMapAPI implements WeatherService {
    @Override
    public WeatherData getWeather(String location) {
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(20.5);
        weatherData.setCondition("Clear");


        return weatherData;
    }
}
class AccurateWeatherAPI implements WeatherService {
    @Override
    public WeatherData getWeather(String location) {
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(22.0);
        weatherData.setCondition("Partly Cloudy");

        return weatherData;
    }
}
 class WeatherAPIAdapter implements WeatherService {
    private WeatherService api;

    public WeatherAPIAdapter(WeatherService api) {
        this.api = api;
    }

    @Override
    public WeatherData getWeather(String location) {
        return api.getWeather(location);
    }
}