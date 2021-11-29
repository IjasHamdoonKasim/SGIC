package com.sgic.employee.utill;

public class Utills {
    public static boolean notNullValidation(String name){
        if(name != null && !name.trim().isEmpty()){
            return true;
        }
        return false;
    }
}
