package com.pw.api;

public class resource {

    public static boolean validateEmail(String mail){
        int counterArroba=0;
        int counterPunto=0;

        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == '@') {
                counterArroba++;
            }
            if (mail.charAt(i) == '.') {
                counterPunto++;
            }
        }

        if (counterArroba == 1 && counterPunto > 0) {
            return true;
        }else{
            return false;}
    }

}
