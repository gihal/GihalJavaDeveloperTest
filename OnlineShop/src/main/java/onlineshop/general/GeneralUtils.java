package onlineshop.general;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.json.JsonArray;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gihal
 */
public class GeneralUtils {

    /**
     * Check if the given String is null or blank
     *
     * @param value is the String that need to check
     * @return Returns true if the given String is null or blank
     */
    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Sends the appropriate error response to the user for the given exception.
     *
     * @param ex the exception that occurred.
     * @param response the servlet response.
     * @throws IOException
     */
    public static void handleException(Throwable ex, HttpServletResponse response) throws IOException  {
        if (ex instanceof IllegalArgumentException) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
