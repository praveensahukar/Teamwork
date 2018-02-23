
package com.Paladion.teamwork.Filters;
/**
 *
 * @author sumukh.r
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

public final class RequestWrapper extends HttpServletRequestWrapper {
	
	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	public String[] getParameterValues(String parameter) {
            
            try{
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
            }
            catch(Exception ex){
                ex.printStackTrace();
                return null;
            }
	}

	public String getParameter(String parameter) {
		
            try{
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		
		return cleanXSS(value);
            }
            catch(Exception ex){
                ex.printStackTrace();
                return null;
            }
	}

	public String getHeader(String name) {
		try{
		String value = super.getHeader(name);
		if (value == null)
			return null;
		
		return cleanXSS(value);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    return null;
                }
	}

	private String cleanXSS(String value) {
		try{
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("exec", "");
		value = value.replaceAll("<script>", "");
		value = value.replaceAll("</script>", "");
		value = value.replaceAll("javascript", "");
		value = value.replaceAll("onclick", "");
		value = value.replaceAll("href", "");
		//value = value.replaceAll("(", "");
		//value = value.replaceAll(")", "");
		return value;
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    return null;
                }
	}
}
