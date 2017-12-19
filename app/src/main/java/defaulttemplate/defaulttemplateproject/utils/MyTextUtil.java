package defaulttemplate.defaulttemplateproject.utils;

import android.text.TextUtils;

import java.util.List;

public class MyTextUtil {
    public static String correctMyString(String text) {

        String NA = "NA";

        if (text != null) {
            text = text.trim().replaceAll("\\s+", " "); // To remove multiple white space from string
            if (TextUtils.isEmpty(text)) {
                text = NA;
            }
        } else {
            text = NA;
        }

        return text;
    }

    public static String appendStringWithComma(List<String> aList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aList.size(); i++) {
            String prefix = " ";
            if (i < (aList.size() - 1)) {
                prefix = ", ";
            }
            sb.append(aList.get(i));
            sb.append(prefix);
        }

        return sb.toString();
    }

    public static String appendStringWithUnderscore(List<String> aList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aList.size(); i++) {
            String prefix = "";
            if (i < (aList.size() - 1)) {
                prefix = "_";
            }
            sb.append(aList.get(i));
            sb.append(prefix);
        }

        return sb.toString();
    }
}
