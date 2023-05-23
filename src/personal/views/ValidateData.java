package personal.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    String patternName = "^\\S+$";
    String patternPhone = "^\\+7\\(\\d{3}\\)\\d{7}$";


    Pattern pattern1 = Pattern.compile(patternName, Pattern.MULTILINE);
    Pattern pattern2 = Pattern.compile(patternPhone, Pattern.MULTILINE);

    public boolean checkFirstName(String firstName){
        Matcher matcher = pattern1.matcher(firstName);
        return !matcher.find();

    }
    public boolean checkLastName(String lastName) {
        Matcher matcher = pattern1.matcher(lastName);
        return !matcher.find();
    }

    public boolean checkPhone(String phoneNumber){
        Matcher matcher = pattern2.matcher(phoneNumber);
        return !matcher.find();

    }


}
