package com.hemansi;
import java.util.Scanner;

public class Citizen {

    Scanner sc = new Scanner(System.in);
    String Aadhar;          //variable for aadhar card number
    boolean occupation;     //It will be set true when person is frontline worker
    int age;                //variable to store age of person
    boolean fam;            //Will be set true if it has family history of covid
    boolean medical;        //Will be set if person has some medical conditionc to take care of

    public Citizen()        //constructor
    {
    }

    void Accept()           //method to accept all information of person
    {
        System.out.println("Are you registering for the first dose?");
        char d = sc.next().charAt(0);
        System.out.println();

        boolean ac = false;         //Aadhar card is not already registered
        if(d == 'Y' || d == 'y') {
            while (!ac)                  //validation of aadhar card number
            {
                try {
                    Aadhar = sc.nextLine();
                    System.out.println();
                    if (Aadhar.length() != 12) {
                        throw new Exception("Invalid Aadhar Card Number");
                    }
                    ac = true;
                } catch (Exception e) {
                    System.out.println("Enter valid aadhar card number");
                }
            }
            ac = false;

            System.out.println("----------------------------------------------------------------");
            System.out.println("Are you frontline worker?");
            char c = sc.next().charAt(0);
            System.out.println();

            if (c == 'Y' || c == 'y')      //condition to check frontline warrior
            {
                occupation = true;
                age = 150;
            } else {
                occupation = false;
                System.out.println("Enter age");
                while (!ac) {
                    try
                    {
                        age = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        if (age<=0)         //condition for invalid age
                        {
                            throw new Exception("Invalid age");
                        }
                        ac =true;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Enter valid age ");
                    }
                }
                if(age<18)
                {
                    System.out.println("****You are not eligible for vaccine right now****");
                    System.out.println();
                }
                else {
                    System.out.println("Do you have any other medical condition?");
                    char a = sc.next().charAt(0);

                    if(a=='y' || a=='Y')
                    {
                        medical=true;
                    }else
                    {
                        medical=false;
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("Does you family has covid history?");
                    char b = sc.next().charAt(0);
                    if(b=='Y'|| b== 'y')
                    {
                        fam = true;
                    }
                    else
                    {
                        fam = false;
                    }
                }
            }
        }
        else
        {

            System.out.print("Enter Aadhar card number: ");
            while(!ac)
            {
                try{
                    Aadhar=sc.nextLine();
                    System.out.println();
                    if(Aadhar.length()!=12)
                    {
                        throw new Exception("Invalid Aadhar Card Number");
                    }
                    ac=true;
                }catch(Exception e){
                    System.out.println("Enter Valid 12-Digit Aadhar card Number");
                }
            }
            ac=false;
        }

    }
    @SuppressWarnings("serial")
    class Excep extends Exception{
        public Excep(String s)
        {
            // Call constructor of parent Exception
            super(s);
        }
    }


}
