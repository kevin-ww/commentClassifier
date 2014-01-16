import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegx {

  public static void main(String[] args) {

    final String exp = "(?<what>cat)";

    final String text = "here come cat and dog ";

    Pattern pattern = Pattern.compile(exp);
    Matcher matcher = pattern.matcher(text);
    
    boolean b = matcher.matches();
    
    System.out.println(b);

    boolean found = false;

    while (matcher.find()) {

      String loginfo = String
          .format(
              "found the text [%s] , starting at index [%d]  and ending at index [%d]",
              matcher.group(), matcher.start(), matcher.end());

      System.out.println(loginfo);

      found = true;
    }

    if (!found) {
      System.out.println("No match found.");
    }
  }

}
