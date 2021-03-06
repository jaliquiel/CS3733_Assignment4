package converter;

import com.sun.deploy.util.StringUtils;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {
    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        for(int n = 0; n < number.length(); n++){
            char ch = number.charAt(n);
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                if(n+1 < number.length()){
                    if(number.charAt(n+1) == ' ')
                        throw new MalformedNumberException("There are spaces in between characters ");
                }
            }
        }
        number = number.replaceAll(" ","");
        char c = number.charAt(0);
        if (Character.isDigit(c)) {
            // todo CHECK: this checks so that we can't get anything but chars between 0 to 9 ***************
            for(int m = 0; m < number.length(); m++){
                char c3 = number.charAt(m);
                if (c3 != '0' && c3 != '1' && c3 != '2' && c3 != '3' && c3 != '4' && c3 != '5' && c3 != '6' && c3 != '7' && c3 != '8' && c3 != '9')
                    throw new ValueOutOfBoundsException("Invalid Arabic Number: There were Letters with Arabic Numbers: " + number);
            }
            // todo **************************************************************
            double testDec = Double.parseDouble(number);
            if (testDec % 1 != 0) {
                throw new ValueOutOfBoundsException("Only whole numbers allowed");
            }
            int arabicNum = Integer.parseInt(number);
            if (arabicNum > 3999 || arabicNum < 1) {
                throw new ValueOutOfBoundsException("Arabic number" + number + "is out of bounds");
            }
            this.number = number;
        } else {
            for (int i = 0; i < number.length(); i++) {
                char c2 = number.charAt(i);
                if (c2 != 'M' && c2 != 'C' && c2 != 'D' && c2 != 'e' && c2 != 'L' && c2 != 'm' && c2 != 'X' && c2 != 'V' && c2 != 'w' && c2 != 'I') {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("M", "").length() > 3) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("D", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("L", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("V", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("e", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("m", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("w", "").length() > 1) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("C", "").length() > 3) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("X", "").length() > 3) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);

                } else if (number.length() - number.replace("I", "").length() > 3) {

                    throw new MalformedNumberException("Invalid Elbonian number: " + number);
                }
                boolean hase = false;
                boolean hasm = false;
                boolean hasw = false;
                if (number.length() - number.replace("e", "").length() > 0) {
                    hase = true;
                }
                if (number.length() - number.replace("m", "").length() > 0) {
                    hasm = true;
                }
                if (number.length() - number.replace("w", "").length() > 0) {
                    hasw = true;
                }
                if (number.length() - number.replace("C", "").length() > 0 && hase) {
                    throw new MalformedNumberException("No C with e");
                }
                if (number.length() - number.replace("X", "").length() > 0 && hasm) {
                    throw new MalformedNumberException("No X with m");
                }
                if (number.length() - number.replace("I", "").length() > 0 && hasw) {
                    throw new MalformedNumberException("No I with w");
                }
                ArrayList<Integer> order = new ArrayList<>();
                for (int j = 0; j < number.length(); j++) {
                    if (number.charAt(j) == 'M') {
                        order.add(1);
                    } else if (number.charAt(j) == 'e') {
                        order.add(2);
                    } else if (number.charAt(j) == 'D') {
                        order.add(3);
                    } else if (number.charAt(j) == 'C') {
                        order.add(4);
                    } else if (number.charAt(j) == 'm') {
                        order.add(5);
                    } else if (number.charAt(j) == 'L') {
                        order.add(6);
                    } else if (number.charAt(j) == 'X') {
                        order.add(7);
                    } else if (number.charAt(j) == 'w') {
                        order.add(8);
                    } else if (number.charAt(j) == 'V') {
                        order.add(9);
                    } else {
                        order.add(10);
                    }
                }
                for (int k = 0; k < order.size() - 1; k++) {
                    if (order.get(k + 1) < order.get(k)) {
                        throw new MalformedNumberException("Incorrect order of Elbonian number: " + number);
                    }
                }

            }
            this.number = number;
        }
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic () {
        char c = number.charAt(0);
        if (Character.isDigit(c)) {
            return Integer.parseInt(number);
        } else {
            int countM = number.length() - number.replace("M", "").length();
            int countD = number.length() - number.replace("D", "").length();
            int counte = number.length() - number.replace("e", "").length();
            int countC = number.length() - number.replace("C", "").length();
            int countL = number.length() - number.replace("L", "").length();
            int countm = number.length() - number.replace("m", "").length();
            int countx = number.length() - number.replace("X", "").length();
            int countV = number.length() - number.replace("V", "").length();
            int countw = number.length() - number.replace("w", "").length();
            int countI = number.length() - number.replace("I", "").length();
            int total = countM * 1000 + countD * 500 + counte * 400 + countC * 100 + countL * 50 + countm * 40 + countx * 10 + countV * 5 + countw * 4 + countI;
            return total;
        }
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian () {
        String elbo = "";

        if (Character.isLetter(number.charAt(0))) {
            return number;
        } else {
            int n = Integer.parseInt(number);
            boolean hasE = false;
            boolean hasM = false;
            boolean hasW = false;

            if (n >= 1000) {
                for (int i = 0; i < 3; i++) {
                    elbo += "M";
                    n -= 1000;
                    if (n < 1000) {
                        break;
                    }
                }
            }
            if (n >= 900) {
                elbo += "e";
                n -= 400;
                hasE = true;
            }
            if (n >= 500) {
                elbo += "D";
                n -= 500;
            }
            if (n >= 400 && !hasE) {
                elbo += "e";
                n -= 400;
            }
            if (n >= 100 && !hasE) {
                for (int i = 0; i < 3; i++) {
                    elbo += "C";
                    n -= 100;
                    if (n < 100) {
                        break;
                    }
                }
            }
            if (n >= 90) {
                elbo += "m";
                n -= 40;
                hasM = true;
            }
            if (n >= 50) {
                elbo += "L";
                n -= 50;
            }
            if (n >= 40 && !hasM) {
                elbo += "m";
                n -= 40;
            }
            if (n >= 10 && !hasM) {
                for (int i = 0; i < 3; i++) {
                    elbo += "X";
                    n -= 10;
                    if (n < 10) {
                        break;
                    }
                }
            }
            if (n >= 9) {
                elbo += "w";
                n -= 4;
                hasW = true;
            }
            if (n >= 5) {
                elbo += "V";
                n -= 5;
            }
            if (n >= 4 && !hasW) {
                elbo += "w";
                n -= 4;
            }
            if (n >= 1 && !hasW) {
                for (int i = 0; i < 3; i++) {
                    elbo += "I";
                    n -= 1;
                    if (n < 1) {
                        break;
                    }
                }
            }
        }
        return elbo;
    }


}
