
public class Conversions 
{
    public static String decimalNumberTo32Bit(String userInput)
    {
    	double decimalNumber = Double.parseDouble(userInput);
    	float numberInFloatTerms = (float)decimalNumber;
    	int bits = Float.floatToIntBits(numberInFloatTerms);
    	String binaryNumberString = Integer.toBinaryString(bits);
       
    	return binaryNumberString;
    }
    public static String decimalNumberTo64Bit(String userInput)
    {
    	double decimalNumber = Double.parseDouble(userInput);
    	String binaryNumberString = Long.toString(Double.doubleToLongBits(decimalNumber), 2);
    	return binaryNumberString;
    }

    public static float binaryToFloat(String binaryNumber)
    {
    	float decimalNumber;
    	String binaryString = binaryNumber;
    	decimalNumber = Float.intBitsToFloat(Integer.parseInt(binaryString,2));
    	return decimalNumber;
    }
    public static double binaryToDouble(String binaryNumber)
    {
    	double decimalNumber;
    	decimalNumber = Double.longBitsToDouble(Long.parseLong(binaryNumber, 2));
    	return decimalNumber;
    }
	

		
}
	
	