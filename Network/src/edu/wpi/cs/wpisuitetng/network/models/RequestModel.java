package edu.wpi.cs.wpisuitetng.network.models;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestModel implements IRequest {
	protected String body;
	protected Map<String, List<String>> headers;
	protected Map<String, String> urlData;
	protected URL url;
	protected HttpMethod httpMethod;
	protected ResponseModel response;

	public RequestModel() {
		headers = new HashMap<String, List<String>>();
		urlData = new HashMap<String, String>();
	}

	/**
	 * Adds a header to the RequestModel.
	 * 
	 * @param key		A String representing the header key.
	 * @param value		A String representing the header value.
	 * 
	 * @throws NullPointerException		If the key is null.
	 */
	public void addHeader(String key, String value) throws NullPointerException {
		// check to see if the key is null
		if (key == null) {
			throw new NullPointerException("The key must not be null.");
		}

		// get the List of current values from the requestHeaders Map
		List<String> currentValues = headers.get(key);

		// if the List of current values is null, create a new list of current values
		if (currentValues == null) {
			currentValues = new ArrayList<String>();
		}

		// add the new value to the list of current values
		currentValues.add(value);

		// store the updated List of current values in the Map
		headers.put(key, currentValues);
	}

	/**
	 * Adds a urlData key-value pair to the RequestModel.
	 * 
	 * @param key		A String representing the urlData key.
	 * @param value		A String representing the urlData value.
	 * 
	 * @throws NullPointerException		If the key or value is null.
	 */
	public void addUrlData(String key, String value) throws NullPointerException {
		// check to see if the key is null
		if (key == null) {
			throw new NullPointerException("The key must not be null.");
		}
		// check to see if the value is null
		if (value == null) {
			throw new NullPointerException("The value must not be null.");
		}

		// add the new value to the list of current values
		urlData.put(key, value);
	}

	/**
	 * Sets the body of the RequestModel.
	 * 
	 * @param body	The body of the request to send to the server.
	 * 
	 * @throws NullPointerException		If the body is null.
	 */
	public void setBody(String body) throws NullPointerException {
		// check to see if the key is null
		if (body == null) {
			throw new NullPointerException("The body parameter must not be null.");
		}

		this.body = body;
	}

	/**
	 * Sets the HTTP method for the Request.
	 * 
	 * @param httpMethod The HttpMethod to use when sending data to the server.
	 * 
	 * @throws NullPointerException		If the httpMethod is null.
	 */
	public void setHttpMethod(HttpMethod httpMethod) throws NullPointerException {
		// check to see if the requestMethod is null
		if (httpMethod == null) {
			throw new NullPointerException("The httpMethod parameter must not be null.");
		}

		this.httpMethod = httpMethod;
	}

	/**
	 * Sets the server's response to the request.
	 * 
	 * @param response	The server's ResponseModel to the request.
	 * 
	 * @throws NullPointerException		If the response is null.
	 */
	protected void setResponse(ResponseModel response) throws NullPointerException {
		// check to see if the response is null
		if (response == null) {
			throw new NullPointerException("The response parameter must not be null.");
		}

		this.response = response;
	}

	/**
	 * Sets the RequestModel's URL.
	 * 
	 * @param url The URL to make the request to.
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequest#getBody()
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequest#getHeaders()
	 */
	@Override
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequest#getHttpMethod()
	 */
	@Override
	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequest#getResponse()
	 */
	@Override
	public ResponseModel getResponse() {
		return response;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequest#getURL()
	 */
	@Override
	public URL getUrl() {
		return url;
	}

	/**
	 * @see edu.wpi.cs.wpisuitetng.network.models.IRequests#getUrlData()
	 */
	@Override
	public Map<String, String> getUrlData() {
		return urlData;
	}
}