package per.nonlone.minicodetest;

import per.nonlone.minicodetest.service.DivisionService;

public class Main {



    private static DivisionService divisionService = new DivisionService();

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(divisionService.generateStringIfANumberDividedBy3Or5(i));
        }
    }



}
