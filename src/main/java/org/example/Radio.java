package org.example;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int numberOfStations;

    // Конструктор по умолчанию — 10 станций
    public Radio() {
        this.numberOfStations = 10;
    }

    // Конструктор с параметром — задаём количество станций
    public Radio(int numberOfStations) {
        if (numberOfStations <= 0) {
            this.numberOfStations = 10;
        } else {
            this.numberOfStations = numberOfStations;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public void setStation(int station) {
        if (station >= 0 && station < numberOfStations) {
            currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == numberOfStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = numberOfStations - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
