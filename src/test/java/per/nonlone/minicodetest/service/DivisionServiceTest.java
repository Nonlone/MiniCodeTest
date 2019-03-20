package per.nonlone.minicodetest.service;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;


public class DivisionServiceTest {

    private DivisionService divisionService = new DivisionService();

    private static final int MAX_COUNT = 100;

    @Test
    public void testPassIsDividedBy5() {
        for (int i = 0; i < MAX_COUNT; i++) {
            int testNumber = 5 * RandomUtils.nextInt(1, 21);
            if (!divisionService.isDividedBy5(testNumber)) {
                System.err.println(String.format("wrong number process: %s", testNumber));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void testFailIsDividedBy5() {
        for (int i = 0; i < MAX_COUNT; i++) {
            int testNumber = 5 * RandomUtils.nextInt(1, 20) + RandomUtils.nextInt(1, 5);
            if (divisionService.isDividedBy5(testNumber)) {
                System.err.println(String.format("wrong number process: %s", testNumber));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void testPassIsDividedBy3() {
        for (int i = 0; i < MAX_COUNT; i++) {
            int testNumber = 3 * RandomUtils.nextInt(1, 34);
            if (!divisionService.isDividedBy3(testNumber)) {
                System.err.println(String.format("wrong number process: %s", testNumber));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void testFailIsDividedBy3() {
        for (int i = 0; i < MAX_COUNT; i++) {
            int testNumber = 3 * RandomUtils.nextInt(1, 33) + RandomUtils.nextInt(1, 3);
            if (divisionService.isDividedBy3(testNumber)) {
                System.err.println(String.format("wrong number process: %s", testNumber));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void generateFizzBuzzIfANumberDividedBy3Or5() {
        DivisionService divisionService = spy(DivisionService.class);
        when(divisionService.isDividedBy3(anyInt())).thenReturn(true);
        when(divisionService.isDividedBy5(anyInt())).thenReturn(true);

        for (int i = 0; i < MAX_COUNT; i++) {
            int number = RandomUtils.nextInt(1, 101);
            String testResult = divisionService.generateStringIfANumberDividedBy3Or5(number);
            if (!StringUtils.equals(DivisionService.FIZZ + DivisionService.BUZZ, testResult)) {
                System.err.println(String.format("wrong generation number:%s , result:%s", number, testResult));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void generateFizzIfANumberDividedBy3Or5() {
        DivisionService divisionService = spy(DivisionService.class);
        when(divisionService.isDividedBy3(anyInt())).thenReturn(true);
        when(divisionService.isDividedBy5(anyInt())).thenReturn(false);

        for (int i = 0; i < MAX_COUNT; i++) {
            int number = RandomUtils.nextInt(1, 101);
            String testResult = divisionService.generateStringIfANumberDividedBy3Or5(number);
            if (!StringUtils.equals(DivisionService.FIZZ , testResult)) {
                System.err.println(String.format("wrong generation number:%s , result:%s", number, testResult));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void generateBuzzIfANumberDividedBy3Or5() {
        DivisionService divisionService = spy(DivisionService.class);
        when(divisionService.isDividedBy3(anyInt())).thenReturn(false);
        when(divisionService.isDividedBy5(anyInt())).thenReturn(true);

        for (int i = 0; i < MAX_COUNT; i++) {
            int number = RandomUtils.nextInt(1, 101);
            String testResult = divisionService.generateStringIfANumberDividedBy3Or5(number);
            if (!StringUtils.equals(DivisionService.BUZZ , testResult)) {
                System.err.println(String.format("wrong generation number:%s , result:%s", number, testResult));
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void generateNumberIfANumberDividedBy3Or5() {
        DivisionService divisionService = spy(DivisionService.class);
        when(divisionService.isDividedBy3(anyInt())).thenReturn(false);
        when(divisionService.isDividedBy5(anyInt())).thenReturn(false);

        for (int i = 0; i < MAX_COUNT; i++) {
            int number = RandomUtils.nextInt(1, 101);
            String testResult = divisionService.generateStringIfANumberDividedBy3Or5(number);
            if (StringUtils.containsAny(testResult,DivisionService.FIZZ,DivisionService.BUZZ)) {
                System.err.println(String.format("wrong generation number:%s , result:%s", number, testResult));
                assert false;
            }
        }
        assert true;
    }
}