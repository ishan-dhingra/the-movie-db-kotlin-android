package com.anythingintellect.themoviedb.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by ishan.dhingra on 06/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Movie(@JsonProperty("id") val id: Long,
                 @JsonProperty("title") val title: String,
                 @JsonProperty("overview") val overview: String,
                 @JsonProperty("vote_average") val vote: Float,
                 @JsonProperty("release_date") val releaseDate: String,
                 @JsonProperty("backdrop_path") val backdrop: String?,
                 @JsonProperty("poster_path") var poster: String?)