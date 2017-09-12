import java.io.Console;
import java.math.BigInteger;
import java.util.Scanner;

public class DemoDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger num2 = scanner.nextBigInteger();
        BigInteger maxNum = BigInteger.ZERO;
        BigInteger minNum = BigInteger.ZERO;
        if (num1.compareTo(num2) > 0) {
            maxNum = num1;
            minNum = num2;
        } else {
            ma
        }

        BigInteger overflowValue = BigInteger.ZERO;
        String smallerType = "";

        if (minNum.compareTo(new BigInteger("255")) < 0)
        {
            overflowValue = new BigInteger("255");
            smallerType = "byte";
        }
        else if (minNum.compareTo(new BigInteger("65535")) < 0)
        {
            overflowValue = new BigInteger("65535");
            smallerType = "ushort";
        }
        else if (minNumber <= uint.MaxValue)
        {
            overflowValue = uint.MaxValue;
            smallerType = "uint";
        }
        else if (minNumber <= ulong.MaxValue)
        {
            overflowValue = ulong.MaxValue;
            smallerType = "ulong";
        }
        string maxType = String.Empty;
        if (maxNumber <= byte.MaxValue)
        {
            maxType = "byte";
        }
        else if (maxNumber <= ushort.MaxValue)
        {
            maxType = "ushort";
        }
        else if (maxNumber <= uint.MaxValue)
        {
            maxType = "uint";
        }
        else if (maxNumber <= ulong.MaxValue)
        {
            maxType = "ulong";
        }

        decimal overflowCounnt = maxNumber / overflowValue;

        Console.WriteLine($"bigger type: {maxType}");
        Console.WriteLine($"smaller type: {smallerType}");
        Console.WriteLine($"{maxNumber} can overflow {smallerType} {Math.Round(overflowCounnt)} times");

    }
}
