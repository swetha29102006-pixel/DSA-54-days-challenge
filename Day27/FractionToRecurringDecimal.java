import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 166: Fraction to Recurring Decimal
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose repeating part in parentheses.
 * Time Complexity: O(denominator) maximum distinct remainders.
 * Space Complexity: O(denominator) for hash map storing remainder positions.
 */
public class FractionToRecurringDecimal {
    // Converts fraction to decimal string detecting recurring repeating parts using remainder hash map
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal solver = new FractionToRecurringDecimal();
        System.out.println("1/2: " + solver.fractionToDecimal(1, 2));     // 0.5
        System.out.println("2/1: " + solver.fractionToDecimal(2, 1));     // 2
        System.out.println("4/333: " + solver.fractionToDecimal(4, 333)); // 0.(012)
    }
}