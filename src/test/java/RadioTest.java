import org.example.Radio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    // Тесты для установки станции

    @Test
    void shouldSetStationWithinRange() {
        Radio radio = new Radio();
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSetBoundaryStationZero() {
        Radio radio = new Radio();
        radio.setStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSetBoundaryStationNine() {
        Radio radio = new Radio();
        radio.setStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    // Тесты для nextStation

    @Test
    void shouldGoToNextStationFromMiddle() {
        Radio radio = new Radio();
        radio.setStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapFromNineToZero() {
        Radio radio = new Radio();
        radio.setStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoFromZeroToOne() {
        Radio radio = new Radio();
        radio.setStation(0);
        radio.nextStation();
        assertEquals(1, radio.getCurrentStation());
    }

    // Тесты для prevStation

    @Test
    void shouldGoToPrevStationFromMiddle() {
        Radio radio = new Radio();
        radio.setStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldWrapFromZeroToNine() {
        Radio radio = new Radio();
        radio.setStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldGoFromNineToEight() {
        Radio radio = new Radio();
        radio.setStation(9);
        radio.prevStation();
        assertEquals(8, radio.getCurrentStation());
    }

    // Тесты для громкости

    @Test
    void shouldIncreaseVolumeWithinRange() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for (int i = 0; i < 98; i++) {
            radio.increaseVolume();
        }
        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseAboveMax() {
        Radio radio = new Radio();
        // Достигаем максимума
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        // Пытаемся увеличить ещё
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolumeWithinRange() {
        Radio radio = new Radio();
        // Сначала увеличим до 50
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        assertEquals(50, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseBelowMin() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldHandleVolumeAtBoundaries() {
        Radio radio = new Radio();

        // Минимальное значение
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        // Максимальное значение
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    // Комбинированные тесты

    @Test
    void shouldResetVolumeToZeroAfterFullCycle() {
        Radio radio = new Radio();

        // Увеличиваем до макс
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        // Уменьшаем до 0
        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldHandleStationCycles() {
        Radio radio = new Radio();
        radio.setStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());

        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());

        radio.setStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Новые тесты

    @Test
    void shouldCreateRadioWithDefaultTenStations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getNumberOfStations());
    }

    @Test
    void shouldCreateRadioWithCustomNumberOfStations() {
        Radio radio = new Radio(30);
        assertEquals(30, radio.getNumberOfStations());
    }

    @Test
    void shouldSetDefaultTenStationsWhenInvalidNumberProvided() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getNumberOfStations());
    }
}
