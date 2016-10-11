package app.com.jemmyender.generalframework_1.Tools;

/**
 * Created by Jemmy Ender on 2016/10/11.
 */
public class Constants {
    private Constants(){

    }

    public static final class Color{
        private static final String[] Blue_Cyan =
                {"#E1F5FE","#B3E5FC","#81D4FA","#4FC3F7","#29B6F6"
                        ,"#03A9F4","#039BE5","#0288D1","#0277BD","#01579B"
                        ,"#E0F7FA","#B2EBF2","#80DEEA","#4DD0E1","#26C6DA"
                        ,"#00BCD4","#00ACC1","#0097A7","#00838F","#006064"};
        public static int get_Blue_Cyan(int i){
            return android.graphics.Color.parseColor(Blue_Cyan[i%(Blue_Cyan.length)]);
        }

    }
}