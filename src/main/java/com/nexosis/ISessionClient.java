package com.nexosis;

import com.nexosis.impl.NexosisClientException;
import com.nexosis.model.*;
import com.nexosis.util.Action;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.joda.time.DateTime;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;

/**
 *
 */
public interface ISessionClient {
    /**
     * Forecast from data posted in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param data          A list of data set rows containing the data used for the forecast.
     * @param startDate     The starting date of the forecast period.
     * @param endDate       The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(SessionData data, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Forecast from data posted in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param data              A list of data set rows containing the data used for the forecast.
     * @param startDate         The starting date of the forecast period.
     * @param endDate           The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @param statusCallbackUrl An optional url used for callbacks when the forecast session status changes.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(SessionData data, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl) throws NexosisClientException;

    /**
     * Forecast from data posted in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param data                   A list of data set rows containing the data used for the forecast.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param statusCallbackUrl      An optional url used for callbacks when the forecast session status changes.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(SessionData data, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Forecast from data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param dataSetName    The name of the saved data set that has the data to forecast on.
     * @param targetColumn   The name of the column that should be used as the source data.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(String dataSetName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Forecast from data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param dataSetName       The name of the saved data set that has the data to forecast on.
     * @param targetColumn      The name of the column that should be used as the source data.
     * @param startDate         The starting date of the forecast period.
     * @param endDate           The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @param statusCallbackUrl An optional url used for callbacks when the forecast session status changes.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(String dataSetName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl) throws NexosisClientException;

    /**
     * Forecast from data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param dataSetName            The name of the saved data set that has the data to forecast on.
     * @param targetColumn           The name of the column that should be used as the source data.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param statusCallbackUrl      An optional url used for callbacks when the forecast session status changes.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse createForecast(String dataSetName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Analyze impact for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param data           The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName      The name of the event.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(SessionData data, String eventName, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Analyze impact for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param data              The data to run the impact analysis on.
     * @param eventName         The name of the event.
     * @param startDate         The starting date of the forecast period.
     * @param endDate           The ending date of the forecast period.
     * @param resultInterval    The interval at which predictions should be generated.
     * @param statusCallbackUrl An optional url used for callbacks when the forecast session status changes.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(SessionData data, String eventName, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl) throws NexosisClientException;

    /**
     * Analyze impact for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param data                   The data to run the impact analysis on.
     * @param eventName              The name of the event.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param statusCallbackUrl      An optional url used for callbacks when the forecast session status changes.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(SessionData data, String eventName, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Analyze impact for an event with data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param dataSetName    The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName      The name of the event.
     * @param targetColumn   The name of the column that should be used as the source data.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(String dataSetName, String eventName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Analyze impact for an event with data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param dataSetName       The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName         The name of the event.
     * @param targetColumn      The name of the column that should be used as the source data.
     * @param startDate         The starting date of the forecast period.
     * @param endDate           The ending date of the forecast period.
     * @param resultInterval    The interval at which predictions should be generated.
     * @param statusCallbackUrl An optional url used for callbacks when the forecast session status changes.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(String dataSetName, String eventName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl) throws NexosisClientException;

    /**
     * Analyze impact for an event with data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param dataSetName            The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName              The name of the event.
     * @param targetColumn           The name of the column that should be used as the source data.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param statusCallbackUrl      An optional url used for callbacks when the forecast session status changes.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse analyzeImpact(String dataSetName, String eventName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, String statusCallbackUrl, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;
    
    /**
     * Estimate the cost of a forecast from data posted in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param data           A list of data set rows containing the data used for the forecast.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateForecast(SessionData data, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Estimate the cost of a forecast from data posted in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param data                   A list of data set rows containing the data used for the forecast.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateForecast(SessionData data, org.joda.time.DateTime startDate, DateTime endDate, ResultInterval resultInterval, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Estimate the cost of a forecast from data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param dataSetName    The name of the saved data set that has the data to forecast on.
     * @param targetColumn   The name of the column that should be used as the source data.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateForecast(String dataSetName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Estimate the cost of a forecast from data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/forecast
     * <P>
     * @param dataSetName            The name of the saved data set that has the data to forecast on.
     * @param targetColumn           The name of the column that should be used as the source data.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateForecast(String dataSetName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Estimate the cost of impact analysis for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param data           The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName      The name of the event.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateImpact(SessionData data, String eventName, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * Estimate the cost of impact analysis for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param data           The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName      The name of the event.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateImpact(SessionData data, String eventName, DateTime startDate, DateTime endDate, ResultInterval resultInterval, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Estimate the cost of impact analysis for an event with data in the request.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param dataSetName            The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName              The name of the event.
     * @param targetColumn           The name of the column that should be used as the source data.
     * @param startDate              The starting date of the forecast period.
     * @param endDate                The ending date of the forecast period.
     * @param resultInterval         The interval at which predictions should be generated.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateImpact(String dataSetName, String eventName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Estimate the cost of impact analysis for an event with data already saved to the API.
     * <P>
     * POST to https://ml.nexosis.com/api/sessions/impact
     * <P>
     * @param dataSetName    The name of the saved data set that has the data to run the impact analysis on.
     * @param eventName      The name of the event.
     * @param targetColumn   The name of the column that should be used as the source data.
     * @param startDate      The starting date of the forecast period.
     * @param endDate        The ending date of the forecast period.
     * @param resultInterval The interval at which predictions should be generated.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse estimateImpact(String dataSetName, String eventName, String targetColumn, DateTime startDate, DateTime endDate, ResultInterval resultInterval) throws NexosisClientException;

    /**
     * List all sessions that have been run. This will show the information about them such as the id, status, and the analysis date range.
     * All parameters are optional and will be used to limit the list returned.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions
     * <P>
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponses list() throws NexosisClientException;

    /**
     * List sessions that have been run and limit results by dataset name. This will show the information about them such as the id, status, and the analysis date range.
     * All parameters are optional and will be used to limit the list returned.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName Limits sessions to those with the specified name.
     * @return A {@link com.nexosis.model.SessionResponse SessionResponse} object providing information about the sesssion.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponses list(String dataSetName) throws NexosisClientException;

    /**
     * List sessions that have been run and limit results by both dataset name and event name. This will show the information about them such as the id, status, and the analysis date range.
     * All parameters are optional and will be used to limit the list returned.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName   Limits sessions to those with the specified name.
     * @param eventName     Limits impact sessions to those for a particular event.
     * @return The List&lt;T&gt; of {@link com.nexosis.model.SessionResponse SessionResponse}  objects.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponses list(String dataSetName, String eventName) throws NexosisClientException;

    /**
     * List sessions that have been run and limit results by dataset name, event name, as well as start and end dates. This will show the information about them such as the id, status, and the analysis date range.
     * All parameters are optional and will be used to limit the list returned.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName           Limits sessions to those with the specified name.
     * @param eventName             Limits impact sessions to those for a particular event.
     * @param requestedAfterDate    Limits sessions to those created on or after the specified date.
     * @param requestedBeforeDate   Limits sessions to those created on or before the specified date.
     * @return The List&lt;T&gt; of {@link SessionResponse SessionResponse} objects
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponses list(String dataSetName, String eventName, DateTime requestedAfterDate, DateTime requestedBeforeDate) throws NexosisClientException;

    /**
     * List sessions that have been run and limit results by dataset name, event name, as well as start and end dates. This will show the information about them such as the id, status, and the analysis date range.
     * All parameters are optional and will be used to limit the list returned.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName           Limits sessions to those with the specified name.
     * @param eventName             Limits impact sessions to those for a particular event.
     * @param requestedAfterDate    Limits sessions to those created on or after the specified date.
     * @param requestedBeforeDate   Limits sessions to those created on or before the specified date.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return The List&lt;T&gt; of {@link SessionResponse SessionResponse} objects
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponses list(String dataSetName, String eventName, DateTime requestedAfterDate, DateTime requestedBeforeDate, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Remove all sessions that have been run.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove() throws NexosisClientException;

    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName Limits sessions to those with the specified name.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(String dataSetName) throws NexosisClientException;

    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param type Limits sessions to only these type
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(SessionType type) throws NexosisClientException;

    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName Limits sessions to those with the specified name.
     * @param type Limits sessions to only these type
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(String dataSetName, SessionType type) throws NexosisClientException;

    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName Limits sessions to those with the specified name.
     * @param eventName     Limits impact sessions to those for a particular event.
     * @param type Limits sessions to only these type
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(String dataSetName, String eventName, SessionType type) throws NexosisClientException;

    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName           Limits sessions to those with the specified name.
     * @param eventName             Limits impact sessions to those for a particular event.
     * @param type                  Limits sessions to only these type
     * @param requestedAfterDate    Limits sessions to those created on or after the specified date.
     * @param requestedBeforeDate   Limits sessions to those created on or before the specified date.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(String dataSetName, String eventName, SessionType type, DateTime requestedAfterDate, DateTime requestedBeforeDate) throws NexosisClientException;
    /**
     * Remove sessions that have been run. All parameters are optional and will be used to limit the sessions removed.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions
     * <P>
     * @param dataSetName            Limits sessions to those with the specified name.
     * @param eventName              Limits impact sessions to those for a particular event.
     * @param type                   Limits sessions to only these type
     * @param requestedAfterDate     Limits sessions to those created on or after the specified date.
     * @param requestedBeforeDate    Limits sessions to those created on or before the specified date.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(String dataSetName, String eventName, SessionType type, DateTime requestedAfterDate, DateTime requestedBeforeDate, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Get a specific session by id.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}
     * <P>
     * @param id The identifier of the session.
     * @return A SessionResponse containing the reqeusted session.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse get(UUID id) throws NexosisClientException;

    /**
     * Get a specific session by id.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}
     * <P>
     * @param id                      The identifier of the session.
     * @param httpMessageTransformer  A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A SessionResponse containing the reqeusted session.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResponse get(UUID id, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Lookup the status of the session.
     *
     * HEAD of https://ml.nexosis.com/api/sessions/{id}
     *
     * @param id The identifier of the session.
     * @return A {@link com.nexosis.model.SessionResultStatus} object.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResultStatus getStatus(UUID id) throws NexosisClientException;

    /**
     * Lookup the status of the session.
     * <P>
     * HEAD of https://ml.nexosis.com/api/sessions/{id}
     * <P>
     * @param id                     The identifier of the session.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return SessionStatus
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResultStatus getStatus(UUID id, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Remove the session.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions/{id}
     * <P>
     * @param id The identifier of the session to remove.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(UUID id) throws NexosisClientException;

    /**
     * Remove the session.
     * <P>
     * DELETE to https://ml.nexosis.com/api/sessions/{id}
     * <P>
     * @param id The identifier of the session to remove.
     * @param httpMessageTransformer  A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void remove(UUID id, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Get the results of the session.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}/results
     * <P>
     * @param id The identifier of the session.
     * @return A {@link SessionResult SessionResult} which contains the results of the run.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResult getResults(UUID id) throws NexosisClientException;

    /**
     * Get the results of the session.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}/results
     * <P>
     * @param id                     The identifier of the session.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @return A SessionResult which contains the results of the run.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    SessionResult getResults(UUID id, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Get the results of the session.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}/results
     * <P>
     * @param id                     The identifier of the session.
     * @param output                 Output stream to write the session results to.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ReturnsStatus getResults(UUID id, OutputStream output) throws NexosisClientException;

    /**
     * Get the results of the session.
     * <P>
     * GET of https://ml.nexosis.com/api/sessions/{id}/results
     * <P>
     * @param id                     The identifier of the session.
     * @param output                 Output stream to write the session results data to.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ReturnsStatus getResults(UUID id, OutputStream output, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

    /**
     * Get results of the session written to a file as CSV. It will only write the values of the forecast or impact session and not any of the
     * other data normally returned in a {@link SessionResult SessionResult}
     * <P>
     * @param id     The identifier of the session.
     * @param output The {@link java.io.Writer Writer} where the results should be written.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void writeResults(UUID id, Writer output) throws NexosisClientException;

    /**
     * Get results of the session written to a file as CSV. It will only write the values of the forecast or impact session and not any of the
     * other data normally returned in a {@link SessionResult SessionResult}
     * <P>
     * @param id                     The identifier of the session.
     * @param output                 The {@link java.io.Writer Writer} where the results should be written.
     * @param httpMessageTransformer A function that is called immediately before sending the request and after receiving a response which allows for message transformation.
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    void writeResults(UUID id, Writer output, Action<HttpRequest, HttpResponse> httpMessageTransformer) throws NexosisClientException;

}
