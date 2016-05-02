package it.polito.mad_lab3.common;

import android.content.Context;

import it.polito.mad_lab3.R;

/**
 * Created by Giovanna on 02/05/2016.
 */
public class Helper {


    public static String formatDate(Context context, String weekday, String date){

        String str = new String();
        int yearEnd = date.indexOf("-");
        int monthEnd = date.indexOf("-", yearEnd+1);
        String month= date.substring(yearEnd+1, monthEnd);
        month = intToMonthString(context, Integer.parseInt(month));

        str = weekday+" "+date.substring(monthEnd+1,date.length())+" "+month;
        return str;
    }

    public static String intToWeekString (Context context, int weekday){
        switch (weekday){
            case 1:
                return context.getResources().getString(R.string.sunday);

            case 2:
                return context.getResources().getString(R.string.monday);

            case 3:
                return context.getResources().getString(R.string.tuesday);

            case 4:
                return context.getResources().getString(R.string.wednesday);

            case 5:
                return context.getResources().getString(R.string.thursday);

            case 6:
                return context.getResources().getString(R.string.friday);

            case 7:
                return context.getResources().getString(R.string.saturday);
            default:
                return null;
        }
    }
    public static String intToMonthString (Context context, int month){
        switch (month){
            case 1:
                return context.getResources().getString(R.string.jenuary);

            case 2:
                return context.getResources().getString(R.string.february);

            case 3:
                return context.getResources().getString(R.string.march);

            case 4:
                return context.getResources().getString(R.string.april);

            case 5:
                return context.getResources().getString(R.string.may);

            case 6:
                return context.getResources().getString(R.string.june);

            case 7:
                return context.getResources().getString(R.string.july);

            case 8:
                return context.getResources().getString(R.string.ausgust);

            case 9:
                return context.getResources().getString(R.string.september);

            case 10:
                return context.getResources().getString(R.string.october);

            case 11:
                return context.getResources().getString(R.string.november);

            case 12:
                return context.getResources().getString(R.string.december);
            default:
                return null;
        }
    }
}
