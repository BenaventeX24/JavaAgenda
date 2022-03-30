package com.pw.api;

public class resource {
    private static int counterArroba=0;
    private static int counterPunto=0;

    public static boolean validateEmail(String mail){
        for (int i = 0; i < mail.length(); i++) {
            if (i == '@') {
                counterArroba++;
            }
            if (i == '.') {
                counterPunto++;
            }
        }

        if (counterArroba == 1 && counterPunto > 0) {
            return true;
        }else{return false;}
    }
}
