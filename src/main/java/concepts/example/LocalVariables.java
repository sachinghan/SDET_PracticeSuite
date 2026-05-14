package concepts.example;
/*
float	double
Upper limit	3.4028235E38	1.7976931348623157E308
Lower limit	1.4E-45	4.9E-324
Size	32 bits	64 bits
Explicit notation	The letter f (.01f)	The letter d (0.1d)
Common uses	Microdevices, IoT, mobile	Enterprise apps, JPA, JDBC
Java default	false	true
Alternate	BigDecimal	BigDecimal
Matching integer type	32-bit int	64-bit long
Wrapper class	Float (Upper case ‘F’)	Double (Upper case ‘D’)
*/

//Access modifiers cannot be used for local variables
//Below Variables are Local variables (variables inside methods)
public class LocalVariables {
    public static void main(String args[]){

        int age=25; //(whole numbers)
         System.out.println(age);
        String name="sachin";
        System.out.println(name);
        double salary= 200000.50;//decimal
        System.out.println(salary);
        float average= 20.5664F;
        System.out.println(average);
        boolean isJavaFun= true;
        System.out.println(isJavaFun);
        int vehiclenumber;
        vehiclenumber=30;
        System.out.println(vehiclenumber);
    }
}
