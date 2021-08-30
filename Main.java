package com.hemansi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PriorityQueue<Citizen> pq = new PriorityQueue<Citizen>(10,new CitizenComparator());

        int sel = 0;
        int avail[] = new int[10];
        int cnt[] = new int[10];

        for(int i = 0 ; i < 10;i++)
        {
            avail[i] = 2;
            cnt[i] = 0;
        }

        System.out.println("******** WELCOME TO COWIN PORTAL *******");
        do {
            System.out.println("What you want? \n 1.Check vaccine availability \n 2.Book vaccine slot \n 3.Exit");
            sel = sc.nextInt();
            switch (sel)
            {
                case 1:
                    System.out.println("Vaccine availability for next 10 days is :");
                    System.out.println("|--------------|------------------------------");
                    System.out.println("|\tDay\t|\tNumber of vaccines\t");
                    System.out.println("|--------------|------------------------------");

                    for(int i = 0; i <10 ; i++)
                    {
                        System.out.println("|\t|" + i+1 + "\t|\t" + (avail[i] - cnt[i]) + "\t\t\t|");
                        System.out.println("|-------------|-----------------------------");

                    }
                break;
                case 2:
                    System.out.println("Enter number of people : ");
                    int n = sc.nextInt();
                    for(int i = 0; i < n ; i++)
                    {
                        Citizen c = new Citizen();
                        System.out.println("Enter details of person " + (i+1)+ ":");
                        c.Accept();
                        if(c.age >= 60 || (c.age>=45 && c.age<60 && (c.medical == true || c.fam == true)))
                        {
                            pq.add(c);
                            System.out.println("Registration Successful !!!");
                        }
                    }
                    System.out.println("Allocation of Vaccination Slots: ");
                    int in=0;                                                       //index
                    int j=42200;                                                    // just some fancy serial number;)
                    System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");
                    System.out.println("|\tSr. no.\t    |\tRegistration Number \t\t\t|\tAadhar Number  \t\t\t|\tDay Allocated\t|\tDate\t    |");
                    System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");

                    while(!pq.isEmpty()) {

                        System.out.println("|\t" + (in+1) + "\t    |\tPNQ" + (j+in) + "\t\t\t\t|\t"  + pq.peek().Aadhar + "\t\t\t|\t"  + (in/2 + 1) + "\t\t|  " + "\t" + (in/2 + 1) + "/06/2021   |");
                        System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");
                        cnt[in/2]++;

                        //PNQ= Pune junction code
                        in++;
                        pq.poll();
                    }
                    break;

                case 3:
                    System.out.println("Exiting !!!\n THANK YOU");
                    break;
            }
        }while (sel != 3);
    }
}
