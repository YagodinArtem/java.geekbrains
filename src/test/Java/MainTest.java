import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.level3.lesson6.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class MainTest {

    private static Main main;

    @BeforeEach
    private void init() {
        main = new Main();
    }


    @MethodSource("dataForExtractorTest")
    @ParameterizedTest
    public void lastFourExtractor_basic(int[] input, int[] expected) {
        Assertions.assertArrayEquals(expected, main.lastFourExtractor(input));
    }

    @Test
    public void lastFourExtractor_runTimeException_test() {
        Assertions.assertThrows(RuntimeException.class, ()->main.lastFourExtractor(new int[]{0,0,0,0,0}));
        Assertions.assertThrows(RuntimeException.class, ()->main.lastFourExtractor(new int[]{}));
        Assertions.assertThrows(RuntimeException.class, ()->main.lastFourExtractor(new int[]{0,0,0,0,3}));
    }

    @Test
    public void checkOneAndFour_basic() {
        Assertions.assertTrue(main.checkArrayStructureOfOneAndFour(new int[]{1,1,4,4}));
        Assertions.assertTrue(main.checkArrayStructureOfOneAndFour(new int[]{1,1,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4}));
        Assertions.assertTrue(main.checkArrayStructureOfOneAndFour(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{4,4,4,4,4,4,4,4,4,4,4,4}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{4,4,4,4,4,4,4,44,4,4,4,4}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{1,2,3,4}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{0,0,0,0}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{1,2,3,1}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{-9,-123,0,4}));
        Assertions.assertFalse(main.checkArrayStructureOfOneAndFour(new int[]{-900000000, 999999,1,4}));
    }

    /**
     * Метод генерирует набор аргументов для тестирования main.lastFourExtractor
     * Случайно генерируертся количество аргументов List<Arguments> out используя Random
     * Случайно генерируется содержимое каждого массива и вставляется цифра 4
     * Далее правая половина массива копируется в ожидаемый массив
     *
     * @return out.stream();
     */
    private static Stream<Arguments> dataForExtractorTest() {
        List<Arguments> out = new ArrayList<>();
        Random random = new Random();
        int bound = 100;
        int numberOfArrays = 500;
        for (int i = 0; i < random.nextInt(numberOfArrays); i++) {
            int inputLength = 0;
            while (inputLength == 0) {
                inputLength = random.nextInt(bound);
            }

            int[] input = new int[inputLength];

            for (int j = 0; j < input.length; j++) {

                int number = random.nextInt(bound);
                if (number != 4) {
                    input[j] = number;
                }
            }
            int indexOfFour = random.nextInt(input.length);
            input[indexOfFour] = 4;
            int[] result = new int[input.length - 1 - indexOfFour];
            System.arraycopy(input, indexOfFour + 1, result, 0, result.length);
            out.add(Arguments.arguments(input, result));
        }
        return out.stream();
    }
}
