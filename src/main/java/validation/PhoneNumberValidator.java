package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MOBILE_PATTERN ="(0|\\+98)?([ ]|,|-|[()]){0,2}9[1|2|3|4]([ ]|,|-|[()]){0,2}(?:[0-9]([ ]|,|-|[()]){0,2}){8}";


    public PhoneNumberValidator() {pattern = Pattern.compile(MOBILE_PATTERN);
    }
    public boolean validate(String mobile){

        matcher = pattern.matcher(mobile);
        return matcher.matches();

    }
}