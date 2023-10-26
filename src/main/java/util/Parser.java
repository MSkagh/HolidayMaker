package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Parser {


    public static LocalDate intParseToDate(int dateInteger){
            LocalDate date = LocalDate.parse(
                    String.valueOf(dateInteger), DateTimeFormatter.BASIC_ISO_DATE);
            return date;


    }
}
