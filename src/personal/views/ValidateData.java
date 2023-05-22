package personal.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    String patternName = "^\\S+$";


    Pattern pattern = Pattern.compile(patternName, Pattern.MULTILINE);

    public boolean checkFirstName(String firstName){
        Matcher matcher = pattern.matcher(firstName);
        return !matcher.find();

    }
    public boolean checkLastName(String lastName) {
        Matcher matcher = pattern.matcher(lastName);
        return !matcher.find();
    }


}
