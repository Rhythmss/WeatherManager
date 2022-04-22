package com.rhythmss.weathermanager.Records.CurrentWeather;

import org.json.JSONObject;

public class CurrentWeather {
    private final Coord coord;

    public CurrentWeather(JSONObject jsonObject) {


    }

    public Coord getCoord() {
        return coord;
    }

    public static class Coord{

        private final double lon;
        private final double lat;

        public Coord(double lon, double lat) {
            this.lon = lon;
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }

    }

    public static class Weather{

        private final int id;
        private final String main;
        private final String description;
        private final String icon;

        public Weather(int id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    public static class Main{

        private final double temp;
        private final double feelsLike;
        private final double tempMin;
        private final double tempMax;
        private final double pressure;
        private final double humidity;
        private final double saa_level;
        private final double grndLevel;

        public Main(double temp, double feelsLike, double tempMin, double tempMax, double pressure, double humidity, double saa_level, double grndLevel) {
            this.temp = temp;
            this.feelsLike = feelsLike;
            this.tempMin = tempMin;
            this.tempMax = tempMax;
            this.pressure = pressure;
            this.humidity = humidity;
            this.saa_level = saa_level;
            this.grndLevel = grndLevel;
        }

        public double getTemp() {
            return temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public double getTempMin() {
            return tempMin;
        }

        public double getTempMax() {
            return tempMax;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getSaa_level() {
            return saa_level;
        }

        public double getGrndLevel() {
            return grndLevel;
        }
    }

    public static class Wind{

        private final double spid;
        private final double deg;
        private final double gust;

        public Wind(double spid, double deg, double gust) {
            this.spid = spid;
            this.deg = deg;
            this.gust = gust;
        }

        public double getSpid() {
            return spid;
        }

        public double getDeg() {
            return deg;
        }

        public double getGust() {
            return gust;
        }

    }



}
