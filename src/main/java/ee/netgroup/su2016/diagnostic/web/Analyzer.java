package ee.netgroup.su2016.diagnostic.web;

/**
 * Created by pagulane on 21.06.2016.
 */
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Analyzer {

    public String analyze(final HttpServletRequest request) throws IOException {

        final String input = request.getParameter("input");

        if (input == null)
            return "";

        final StringBuffer result = new StringBuffer();

        final StringReader reader = new StringReader(input);
        final BufferedReader bufferedReader = new BufferedReader(reader);

        int linesCount = 0;

        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null)
                break;

            linesCount++;

            // TODO: line parsing logic ...
        }

        result.append("<br/>Input parsing result:");
        result.append("<br/>Detected " + linesCount + " line(s).");

        return result.toString();
    }

}
