package com.anythingintellect.themoviedb.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by ishan.dhingra on 06/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class MovieResponse(
        @JsonProperty("page") val page: Int?,
        @JsonProperty("total_pages") val totalPages: Int?,
        @JsonProperty("results") val results: List<Movie>?)