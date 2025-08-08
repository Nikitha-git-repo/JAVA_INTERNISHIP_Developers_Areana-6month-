import java.util.Scanner;
public class  calculator{
    public static void main(String args[] ){
        float result,num1,num2;
        Scanner s=new Scanner(System.in);
        while(true){
        System.out.println(" Enter the first number : ");
        if(s.hasNextFloat()){
         num1=s.nextFloat();
        break;}
        else {
            System.out.println(" Enter the valid input as number");
            s.next();
        }
        }
        while(true){
        System.out.println(" Enter the second number : ");
        if(s.hasNextFloat()){
         num2=s.nextFloat();
        break;}
        else { System.out.println(" invalid opterator used use interger as input");
    s.next();}
        }
        System.out.println(" Enter the operation to be performed (+,-,*,/) : ");
        char op=s.next().charAt(0);
        switch(op){
             case '+':
                result = num1 + num2; 
                System.out.println(" result after ADDING is :"+result);break;
            case '-':
                result = num1 - num2;
                System.out.println(" result after  SUBTRACTION is :"+result); break;
            case '*':
                result = num1 * num2;
                System.out.println(" result after MULTIPLICATION is :"+result); break;
            case '/':
                if (num2 != 0){
                    result = num1 / num2;
                    System.out.println(" result after DIVIDING is :"+result);}
                else {
                    System.out.println("Error: Division by zero");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator.");
                return;
        }
        
    }
}