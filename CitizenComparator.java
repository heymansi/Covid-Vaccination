package com.hemansi;

import java.util.Comparator;

public class CitizenComparator implements Comparator<Citizen>{

    @Override
    public int compare(Citizen o1, Citizen o2) {
        if(o1.age >= 60 && o2.age>=60)
        {
            if(o1.age >=o2.age)
            {
                return 1;
            }
            else
            return 1;
        }
        else if(o1.medical == true && o2.medical == false)
        {
            return 1;
        }
        else if(o1.fam == true && o2.fam == false)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}

