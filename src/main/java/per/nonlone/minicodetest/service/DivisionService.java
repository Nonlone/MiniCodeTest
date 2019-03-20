package per.nonlone.minicodetest.service;

/**
 * Division Service provided some check function with division
 */
public class DivisionService {

    public static final String FIZZ = "Fizz";

    public static final String BUZZ = "Buzz";

    /**
     * Generate String according to a number is divided by 3 or 5 with the word "Fizz" and "Buzz"
     * @param number
     * @return
     */
    public String generateStringIfANumberDividedBy3Or5(int number) {
        boolean isFizz = this.isDividedBy3(number);
        boolean isBuzz = this.isDividedBy5(number);
        if (isFizz && isBuzz) {
            return FIZZ + BUZZ;
        } else if (isFizz) {
            return FIZZ;
        } else if (isBuzz) {
            return BUZZ;
        }
        return Integer.toString(number);
    }

    /**
     * Check if the number divided by 5 return true else return false
     * @param number
     * @return
     */
    public boolean isDividedBy5(int number) {
        if (number % 5 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Check if the number divided by 5 return true else return false
     * @param number
     * @return
     */
    public boolean isDividedBy3(int number) {
        if (number % 3 == 0) {
            return true;
        }
        return false;
    }

}
