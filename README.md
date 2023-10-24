1)I have a common data model called WeatherData that represents weather information (location, temperature, and condition).
2)interface WeatherService, it defines methods for fetching weather data. Each API we want to use will have its implementation of this interface.
3)API Implementations:
OpenWeatherMapAPI knows how to answer the questions using OpenWeatherMap data.
AccurateWeatherAPI pretends to answer the questions using fictional data.
4)I found out that Adapters are like translators, no matter who you ask (OpenWeatherMap or AccurateWeather), you get the answers in a language you understand.
