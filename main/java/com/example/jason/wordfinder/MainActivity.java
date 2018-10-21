package com.example.jason.wordfinder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public class RegexeFindText {
        public void main(String[] args) {

            // Input for matching the regexe pattern
            String input = "HAVE THE STRING IN 2 PUT BE HERE 10";
            // Regexe to be matched
            String regexe = "\\b[1-9][0-9]+\\b";
            String regexe2 = "\\b[1-9][0-9]+\\b";

            // Step 1: Allocate a Pattern object to compile a regexe
            Pattern pattern = Pattern.compile(regexe);
            Pattern pattern2 = Pattern.compile(regexe2);
            //Pattern pattern = Pattern.compile(regexe, Pattern.CASE_INSENSITIVE);  // case-insensitive matching

            // Step 2: Allocate a Matcher object from the compiled regexe pattern,
            //         and provide the input to the Matcher
            Matcher matcher = pattern.matcher(input);
            Matcher matcher2 = pattern2.matcher(input);

            // Step 3: Perform the matching and process the matching result

            // Use method find()
            while (matcher.find()) {     // find the next match
                System.out.println("find() found the number \"" + matcher.group());

            }
            while (matcher2.find()) {     // find the next match
                System.out.println("find() found the number \"" + matcher2.group());

            }

            // Use method matches()
            if (matcher.matches()) {
                System.out.println("matches() found the pattern \"" + matcher.group()
                        + "\" starting at index " + matcher.start()
                        + " and ending at index " + matcher.end());
            } else {
                System.out.println("matches() found nothing");
            }

            // Use method lookingAt()
            if (matcher.lookingAt()) {
                System.out.println("lookingAt() found the pattern \"" + matcher.group()
                        + "\" starting at index " + matcher.start()
                        + " and ending at index " + matcher.end());
            } else {
                System.out.println("lookingAt() found nothing");
            }
            if (matcher2.lookingAt()) {
                System.out.println("lookingAt() found the pattern \"" + matcher2.group()
                        + "\" starting at index " + matcher2.start()
                        + " and ending at index " + matcher2.end());
            } else {
                System.out.println("lookingAt() found nothing");
            }
        }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        //  }

    }
}

