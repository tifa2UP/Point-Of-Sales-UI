/**
 * Created by Abdellatif on 4/16/2016.
 */
public class CreditCardFactory {

    public CreditCardFactory() {
    }

    public CreditCard getCreditCard(long cardNumber){
        String cardNumberString = cardNumber + "";
        if (cardNumberString.length() < 2){
            System.out.println("The credit card you've entered is too short!!!");
            return null;
        }
        if (cardNumberString.length() > 19){
            System.out.println("Credit card numbers cannot exceed 19 digits");
            return null;
        }
        else if (cardNumberString.charAt(0) == '5' && cardNumberString.charAt(1) >= '1'&& cardNumberString.charAt(1) <= '5'
                && cardNumberString.length() == 16){
            return new MasterCC();
        }
        else if (cardNumberString.charAt(0) == '4' && (cardNumberString.length() == 13 || cardNumberString.length() == 16)){
            return new VisaCC();
        }
        else if (cardNumberString.charAt(0) == '3' && (cardNumberString.charAt(1) == '4' || cardNumberString.charAt(1) == '7')
                && cardNumberString.length() == 15){
            return new AMExCC();
        }
        else{
            System.out.println("sorry, we do not support your credit card!");
            return null;
        }

    }
}
