package de.openknowledge.dockerbackendfrontendexample.application;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public class CustomCorsFilter implements ContainerResponseFilter {

  private static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
  private final static int MAX_AGE = 42 * 60 * 60;
  private final static String DEFAULT_ALLOWED_HEADERS = "origin,accept,content-type";
  private final static String DEFAULT_EXPOSED_HEADERS = "location,info";

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Headers", getRequestedAllowedHeaders(requestContext));
    headers.add("Access-Control-Expose-Headers", getRequestedExposedHeaders(requestContext));
    headers.add("Access-Control-Allow-Credentials", "true");
    headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
    headers.add("Access-Control-Max-Age", MAX_AGE);
    headers.add("x-responded-by", "cors-response-filter");
  }

  private String getRequestedAllowedHeaders(ContainerRequestContext responseContext) {
    List<String> headers = responseContext.getHeaders().get("Access-Control-Allow-Headers");
    return createHeaderList(headers, DEFAULT_ALLOWED_HEADERS);
  }

  private String getRequestedExposedHeaders(ContainerRequestContext responseContext) {
    List<String> headers = responseContext.getHeaders().get("Access-Control-Expose-Headers");
    return createHeaderList(headers, DEFAULT_EXPOSED_HEADERS);
  }

  private String createHeaderList(List<String> headers, String defaultHeaders) {
    if (headers == null || headers.isEmpty()) {
      return defaultHeaders;
    }
    StringBuilder retVal = new StringBuilder();
    for (String s : headers) {
      retVal.append(s);
      retVal.append(',');
    }
    retVal.append(defaultHeaders);
    return retVal.toString();
  }
}
