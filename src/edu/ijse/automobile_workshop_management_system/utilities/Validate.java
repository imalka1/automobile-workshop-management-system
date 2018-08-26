package edu.ijse.automobile_workshop_management_system.utilities;

import java.security.MessageDigest;

public class Validate {

    public static String checkName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static String checkVehicleNo(String vehicleNo) {
        return vehicleNo.toUpperCase();
    }

    public static String encryptPassword(String password) {
        byte[] plainText = password.getBytes();
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA");
        } catch (Exception e) {

        }

        md.reset();
        md.update(plainText);
        byte[] encodedPassword = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedPassword.length; i++) {
            sb.append(Long.toString(encodedPassword[i] & 255, 16));
        }
        return sb.toString();
    }

    /*public static String incrementPrimary(String key) {
     char[] x = key.toCharArray();
     String letter = "";
     String number = "";
     for (int i = 0; i < x.length; i++) {
     if (x[i] == '0' || x[i] == '1' || x[i] == '2' || x[i] == '3' || x[i] == '4' || x[i] == '5' || x[i] == '6' || x[i] == '7' || x[i] == '8' || x[i] == '9') {
     number += x[i];
     } else {
     letter += x[i];
     }
     }
     int y = Integer.parseInt(number);
     y++;
     return letter + y;
     }*/
}
