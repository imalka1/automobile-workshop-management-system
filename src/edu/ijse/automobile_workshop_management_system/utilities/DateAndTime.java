package edu.ijse.automobile_workshop_management_system.utilities;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateAndTime extends javax.swing.JPanel {

    private GregorianCalendar calendar;
    private static String year;
    private static String month;
    private static String day;
    private static String hour;
    private static String minute;
    private static String second;
    private static String ampm;

    public DateAndTime() {
        initComponents();
        customize();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        calendar = new GregorianCalendar();
                        year = Integer.toString(calendar.get(Calendar.YEAR));
                        if (calendar.get(Calendar.MONTH) + 1 < 10) {
                            month = "0" + Integer.toString(calendar.get(Calendar.MONTH) + 1);
                        } else {
                            month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
                        }
                        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
                            day = "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
                        } else {
                            day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
                        }
                        hour = Integer.toString(calendar.get(Calendar.HOUR));
                        if (calendar.get(Calendar.HOUR) == 0) {
                            hour = "12";
                        }
                        if (calendar.get(Calendar.MINUTE) < 10) {
                            minute = "0" + Integer.toString(calendar.get(Calendar.MINUTE));
                        } else {
                            minute = Integer.toString(calendar.get(Calendar.MINUTE));
                        }
                        if (calendar.get(Calendar.SECOND) < 10) {
                            second = "0" + Integer.toString(calendar.get(Calendar.SECOND));
                        } else {
                            second = Integer.toString(calendar.get(Calendar.SECOND));
                        }
                        if (calendar.get(Calendar.AM_PM) == 0) {
                            ampm = "AM";
                        } else {
                            ampm = "PM";
                        }
                        labelDate.setText(day + "-" + month + "-" + year);
                        labelTime.setText(hour + ":" + minute + ":" + second + " " + ampm);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DateAndTime.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
        setVisible(true);
    }

    public DateAndTime(String x) {
        calendar = new GregorianCalendar();
        year = Integer.toString(calendar.get(Calendar.YEAR));
        if (calendar.get(Calendar.MONTH) + 1 < 10) {
            month = "0" + Integer.toString(calendar.get(Calendar.MONTH) + 1);
        } else {
            month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        }
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            day = "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        }
        String hour = hour = Integer.toString(calendar.get(Calendar.HOUR));
        if (calendar.get(Calendar.HOUR) == 0) {
            if (calendar.get(Calendar.AM_PM) == 1) {
                hour = "12";
            }
        }
        if (calendar.get(Calendar.MINUTE) < 10) {
            minute = "0" + Integer.toString(calendar.get(Calendar.MINUTE));
        } else {
            minute = Integer.toString(calendar.get(Calendar.MINUTE));
        }
        if (calendar.get(Calendar.SECOND) < 10) {
            second = "0" + Integer.toString(calendar.get(Calendar.SECOND));
        } else {
            second = Integer.toString(calendar.get(Calendar.SECOND));
        }
        if (calendar.get(Calendar.AM_PM) == 0) {
            ampm = "AM";
        } else {
            ampm = "PM";
        }
    }

    public static String getDate() {
        return (day + "-" + month + "-" + year);
    }

    public static String getTime() {
        return (hour + ":" + minute + ":" + second + " " + ampm);
    }

    public void customize() {
        labelDate.setFont(new Font("Book Antiqua", 1, 25));
        labelTime.setFont(new Font("Book Antiqua", 1, 25));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDate = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 35, 35));
        setPreferredSize(new java.awt.Dimension(390, 90));
        setLayout(null);

        labelDate.setBackground(new java.awt.Color(35, 35, 35));
        labelDate.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        labelDate.setForeground(new java.awt.Color(102, 102, 102));
        labelDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDate.setOpaque(true);
        add(labelDate);
        labelDate.setBounds(0, 0, 160, 40);

        labelTime.setBackground(new java.awt.Color(35, 35, 35));
        labelTime.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        labelTime.setForeground(new java.awt.Color(102, 102, 102));
        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTime.setOpaque(true);
        add(labelTime);
        labelTime.setBounds(0, 50, 160, 40);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables
}
