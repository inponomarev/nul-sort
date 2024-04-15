package uk.ac.nulondon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static uk.ac.nulondon.App.shuffle;

public class AppTest {

    int[] array;

    @BeforeEach
    void setup() {
        array = IntStream.range(0, 10).toArray();
        shuffle(array);
    }

    @Test
    void bubble() {
        App.bubble(array);
        Assertions.assertThat(array).isSorted();
    }

    @Test
    void insertion() {
        App.insertion(array);
        Assertions.assertThat(array).isSorted();
    }

    @Test
    void mergeSort() {
        App.mergeSort(array);
        Assertions.assertThat(array).isSorted();
    }

    @Test
    void quickSort() {
        App.quickSort(array);
        Assertions.assertThat(array).isSorted();
    }
}
