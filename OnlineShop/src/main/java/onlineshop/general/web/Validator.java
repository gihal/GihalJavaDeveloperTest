package onlineshop.general.web;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gihal
 */
public class Validator {

    private HttpServletRequest request;
    private String parameter;
    private boolean optional;

    public Validator(HttpServletRequest request) {
        this.request = request;
    }

    public Validator parameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    public Validator optional() {
        this.optional = true;
        return this;
    }

    /**
     * Get the long value of the parameter.
     *
     * <li>If <code>optional</code> is true and no value for the given <code>parameter</code> then returns
     * null</li>
     *
     * <li>If <code>optional</code> is false and no value for the <code>parameter</code> then throws
     * IllegalArgumentException </li>
     *
     * @return Returns the long value
     */
    public Long getLong() {
        String value = request.getParameter(parameter);
        Long longValue = null;
        if (optional && value == null) {
            return null;
        }
        if (value == null) {
            throw new IllegalArgumentException("Value for " + parameter + "is null.");
        }
        try {
            longValue = Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value for " + parameter + ". " + value + " is not an integer");
        }
        return longValue;
    }

    /**
     * Get the value of the parameter. If optional is true and no value for the
     * given parameter then returns null
     *
     * <li>If <code>optional</code> is true and no value for the given <code>parameter</code> then returns
     * null</li>
     *
     * <li>If <code>optional</code> is false and no value for the <code>parameter</code> then throws
     * IllegalArgumentException </li>
     *
     * @return Returns the value
     */
    public String getString() {
        String value = request.getParameter(parameter);
        if (optional && value == null) {
            return null;
        }
        if (value == null) {
            throw new IllegalArgumentException("Value for " + parameter + " is null.");
        }
        return value;
    }

}
