package com.nexosis;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.nexosis.impl.NexosisClientException;
import com.nexosis.model.*;
import com.nexosis.util.Action;

import java.util.UUID;

public interface IContestClient {
    Action<HttpRequest, HttpResponse> getHttpMessageTransformer();
    void setHttpMessageTransformer(Action<HttpRequest, HttpResponse> httpMessageTransformer);

    /**
     * Gets detailed data science information generated by a session
     * <P>
     * Gets detailed data science information generated by a session
     * During the execution of a session, many different algorithms can be run, in order to see which
     * algorithm produces the best results.  The contest information returned from this endpoint contains
     * details about all of the algorithms that were attempted, which one is the champion, and various scoring
     * metrics which were used to determine the best algorithm.
     * <p>
     * <b>Note:</b> This endpoint is not available under the community plan.  Please [upgrade](http://nexosis.com/pricing)
     * to a paid plan if you are currently on Community.
     * Be sure to use the <a href="https://developers.nexosis.com/developer">Paid Subscription key</a> if you have already upgraded.
     *
     * PUT of https://ml.nexosis.com/api/data/{dataSetName}
     * <P>
     * @param sessionId Name of the dataset to which to add data.
     * @return A {@link ContestResponse ContestResponse} object
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ContestResponse getContest(UUID sessionId) throws NexosisClientException;

    /**
     * Gets the champion of a contest, and the test data used in scoring the algorithm.
     * <p>
     * Gets the champion of a contest, and the test data used in scoring the algorithm
     * This is the algorithm which was determined to score the best for the given contest.  Scoring metrics,
     * as well as the test data, is returned.
     * <p>
     * <b>Note:</b> This endpoint is not available under the community plan.  Please [upgrade](http://nexosis.com/pricing) to a paid plan if you are currently on Community.
     * Be sure to use the [Paid Subscription key](https://developers.nexosis.com/developer) if you have already upgraded.
     *
     * @param sessionId Session identifier for which to retrieve champion details.
     * @param options Optional. Additional options for querying for the champion
     * @return A {@link ContestantResponse ContestantResponse} object
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ContestantResponse getChampion(UUID sessionId, ChampionQueryOptions options) throws NexosisClientException;

    /**
     * Gets the selection criteria that is used to determined which algorithms were executed.
     * <p>
     * Gets the selection criteria that is used to determined which algorithms were executed.
     * The <i>metricSets</i> contain some information about the data source that was used by the session.  It includes
     * some basic stats about the dataset, such as the mean and standard deviation.  For a forecast or impact session,
     * it will also include information about what levels of seasonality were detected in the data.
     * <p>
     * <b>Note:</b> This endpoint is not available under the community plan.  Please <a href="http://nexosis.com/pricing">upgrade</a>
     * to a paid plan if you are currently on Community.
     * Be sure to use the [Paid Subscription key](https://developers.nexosis.com/developer) if you have already upgraded.
     *
     * @param sessionId Session identifier for which to retrieve champion details.
     * @return A {@link ContestResponse ContestResponse} object
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ContestSelectionResponse getSelection(UUID sessionId) throws NexosisClientException;

    /**
     * Lists the contestant algorithms which were executed for this contest.
     * <p>
     * <b>Note:</b> This endpoint is not available under the community plan.  Please [upgrade](http://nexosis.com/pricing) to a paid plan if you are currently on Community.
     * Be sure to use the [Paid Subscription key](https://developers.nexosis.com/developer) if you have already upgraded.
     *
     * @param sessionId Session identifier for which to retrieve contestant algorithms.
     * @return A {@link ContestResponse ContestResponse} object
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
    ChampionContestantList listContestants(UUID sessionId) throws NexosisClientException;

    /**
     * Gets a specific contestant algorithm, and the test data used in scoring the algorithm.
     * <p>
     * Gets a specific contestant algorithm, and the test data used in scoring the algorithm
     * This is one of the algorithms which were executed during a session.  Scoring metrics, as well as the test data, is returned.
     * <b>Note:</b> This endpoint is not available under the community plan.  Please [upgrade](http://nexosis.com/pricing) to a paid plan if you are currently on Community.
     * Be sure to use the [Paid Subscription key](https://developers.nexosis.com/developer) if you have already upgraded.
     *
     * @param sessionId Session identifier for which to retrieve algorithm details.
     * @param contestantId Identifier of the specific algorithm execution for which to retrieve details.
     * @param options Optional. Additional query options.
     * @return A {@link ContestResponse ContestResponse} object
     * @throws NexosisClientException when 4xx or 5xx response is received from server, or errors in parsing the response.
     */
     ContestantResponse getContestant(UUID sessionId, String contestantId, ChampionQueryOptions options) throws NexosisClientException;
}
