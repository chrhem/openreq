package com.vogella.prioritizer.service;

import java.util.List;

import com.vogella.prioritizer.core.model.Bug;
import com.vogella.prioritizer.core.model.PriorityBug;

import okhttp3.ResponseBody;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface PrioritizerApi {

	@GET("/getChart")
	@Streaming
	Mono<ResponseBody> getKeywordImageBytes(@Query("assignee") String assignee, @Query("width") int width,
			@Query("height") int height, @Query("product") String product, @Query("component") String component,
			@Query("limit") int limit);

	@GET("/findSuitableBugs")
	Mono<List<PriorityBug>> getSuitableBugs(@Query("assignee") String assignee, @Query("product") String product,
			@Query("component") String component, @Query("limit") int limit);

	@GET("/mostDiscussedBugsOfTheMonth")
	Mono<List<Bug>> getMostDiscussedBugsOfTheMonth(@Query("product") List<String> product,
			@Query("component") List<String> component);
}
