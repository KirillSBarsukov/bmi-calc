/**
 * Teacher: Anju Chawla
 * @author: Kirill Barsukov / 200395896
 * @version: October 12, 2018
 * Description: A simple Body Mass Index calculator 
 * formula is BMI = Weight / Heigth**2
*/


import java.util.*;

public class HealthCalculator {

    static Scanner input = new Scanner(System.in); //get input from a user
    static Scanner reader = new Scanner(System.in); //get one character (M,m, F,f) from a user

    //Main method
    public static void main(String[] args) {

        String userName; //get a name from a user as a String
        String userGender; //get gender from a user
        byte userAge; //get user age
        float userHeight; //to calculate user height
        short userWeight; //to calculate user weight
        int maximumHeartRate; //to calculate Maximum Heart Rate
        double targetHeartRate; // to caclulate Target Heart Rate
        float bodyMassIndex; // to caclulate Body Mass Index(BMI)
                   
        displayHelloMessage(); //Display the first message "Hello user......"
                
        userName = getUserName(); // The method getUserName
        userAge = getUserAge(userName); // The method getUserAge
        userGender = getUserGender(userName); // The method getUserGender
        userHeight = getUserHeight(userName); // The method getUserHeight
        userWeight = getUserWeight(userName); // The method getUserWeight
        maximumHeartRate = getUserHeartRate(userAge, userName); // The method getUserHeartRate
        targetHeartRate = getTargetHeartRate(maximumHeartRate, userName); // The method getUserTargetHeartRate
        bodyMassIndex = getBodyMassIndex(userHeight,userWeight,userName); // The method getUserBodyMassIndex
        
        displayUserInformation(userName, userAge, userGender, userHeight, userWeight, maximumHeartRate, targetHeartRate, 
        bodyMassIndex); //Display the last message with whole calculated information
        
    }//end of main method

    //Hello message
    public static void displayHelloMessage() {

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("------Hello! There is a simple BMI calculator-------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        
    }//end of displayHelloMessage mehtod

    //Get an information from a user
    public static String getUserName() {
        
        String userName;
        System.out.print("Please, input your name: ");
        userName = input.nextLine();
        return userName;
        
    }//end of getUserName mehtod
    
    //Get an information about Age from a user. It should be byte, but I was not able to make an addition (byte+short)
    public static byte getUserAge(String userName ) {
        
        byte userAge;
        byte USER_AGE_MIN = 0; //CONSTANT// minimum age is 0
        byte USER_AGE_MAX = 123; //CONSTANT// maximum age is 123

        do
        {
            System.out.printf("%s, input your age(0 through 123) in years as a whole number: ",userName);
            userAge = input.nextByte();
            input.nextLine();
        }while (userAge < USER_AGE_MIN || userAge > USER_AGE_MAX);
        return userAge;
        
    }//end of getUserAge mehtod
    
    //Get an information about gender from a user
    public static String getUserGender(String userName) {
              
        String userGender;

        do
        {
           
           System.out.printf("%s, input your  gender (F or M), please: ",userName);
           userGender = input.nextLine();
           
        }while (!"M".equals(userGender) && !"m".equals(userGender) && !"F".equals(userGender) && !"f".equals(userGender));
        if ((userGender.equals("M")) || (userGender.equals("m"))) {
            return "Male";
        } else {
            return "Female";
        }
        
        
    }//end of getUserGender mehtod
    
    //Get an information about Height from a user
    public static float getUserHeight(String userName) {
        double MIN_USER_HEIGHT = 21.5; //Local CONSTANT minimum height is 21.5
        double MAX_USER_HEIGHT = 107.1; //Local CONSTANT maximum height is 107.1
        
        float userHeight;

        do
        {
           
           System.out.printf("%s, please enter your height in inches(20.0 through 108.0), for example, 63, 21.5 etc: ",userName);
           userHeight = input.nextFloat();
           
           
        }while(userHeight < MIN_USER_HEIGHT || userHeight > MAX_USER_HEIGHT);
        return userHeight;
    }//end of getUserHeight method
        
    //Get an information about Weight from a user
    public static short getUserWeight(String userName) {
        
        short userWeight;
        byte MIN_USER_WEIGHT = 1; //Local CONSTANT minimum weight is 1
        short MAX_USER_WEIGHT = 1400; //Local CONSTANT maximum weight is 1400

        do
        {
          
          System.out.printf("%s, please enter your weight in pounds (1 through 1400), as a whole number: ",userName);
          userWeight = input.nextShort();  
          
        }while(userWeight < MIN_USER_WEIGHT || userWeight > MAX_USER_WEIGHT);
        return userWeight;
                
    }//end of getUserWeight method
    
    //Calculate Maximum Heart Rate. A formula is MHR = 220 - userAge
    public static int getUserHeartRate(byte userAge,String userName) {
        
        int maximumHeartRate;
        int MAX_HEART_RATE = 220;         
        maximumHeartRate =  MAX_HEART_RATE - (int)userAge;
        
        return maximumHeartRate;
        
    }//end of getUserHeartRate method
    
    //Calculate Target Heart Rate. A formula is THR = maximumHeartRate * 0.6
    public static double getTargetHeartRate(int maximumHeartRate, String userName) {
        
        double targetHeartRate;
        targetHeartRate = maximumHeartRate * 0.6;
        return targetHeartRate;
            
    }//end of getTargetHeartRate method
    
    //Calculate BMI. A formula is BMI = (userWeight * 703) / (userHeight * userHeight)// Make it as a table
    public static float getBodyMassIndex(float userHeight,short userWeight, String userName) {
        
        float bodyMassIndex;
        
        bodyMassIndex = (userWeight * 703) / (userHeight * userHeight);
        return bodyMassIndex;
        
    }//end of getBodyMassIndex mehtod
    
    /**
     * This method whole user information
     * @param userName the user name
     * @param userAge the user age
     * @param userGender the user gender
     * @param userHeight the user height
     * @param userWeight the user weighte
     * @param maximumHeartRate the maximum heart rate
     * @param targetHeartRate the target heart rate
     * @param bodyMassIndex the body mass index(BMI)
     */
     private static void displayUserInformation(String userName,byte userAge,String userGender,float userHeight, 
     short userWeight, int maximumHeartRate, double targetHeartRate,float bodyMassIndex)
     {
        System.out.println("------------------------------USER INFORMATION-------------------------------------------------");
        System.out.printf("%30s: %s%n","User name", userName);
        System.out.printf("%30s: %d %s%n", "User age", (int)userAge, "years");
        System.out.printf("%30s: %s%n", "User gender", userGender);
        System.out.printf("%30s: %.2f %s%n", "User height", userHeight, "inches");
        System.out.printf("%30s: %d %s%n", "User weight", (int)userWeight, "pounds");
        System.out.printf("%30s: %d %s%n", "User maximum heart rate", maximumHeartRate, "beats/minute");
        System.out.printf("%30s: %.1f %s%n", "User target heart rate",targetHeartRate, "beats/minute");
        System.out.printf("%30s: %.1f%n", "User BMI", bodyMassIndex);

            if (bodyMassIndex < 18.5)
            {
               
               System.out.printf("%30s: %s%n", "Health Status","Underweight(" );
          
            } else if (bodyMassIndex >= 18.5 && bodyMassIndex <= 24.9)
            {
               
               System.out.printf("%30s: %s%n", "Health Status","Normal Weight" );
            
            } else if (bodyMassIndex >= 25 && bodyMassIndex <= 29.9){
               
               System.out.printf("%30s: %s%n", "Health Status","Overweight" );
            
            } else {
               System.out.printf("%30s: %s%n", "Health Status","Obese" );
            }
   
        System.out.println("--------------------------------------------------------------------------------------")
            
    }//end of displaySUserInformation method

}
