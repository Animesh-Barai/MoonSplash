package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.service


import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.CollectionsItem
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.PhotoItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * PhotoService
 *
 * It's a service of Retrofit .
 */
interface PhotosApiService {

    /**
     * get a photo from server by id.
     */
    @GET("/photos/{id}")
    fun getPhoto(@Path("id") id: String): Call<PhotoItem>

    /**
     * get a list of photos from server.
     */
    @GET("/photos")
    fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("order_by") orderBy: String
    ): Call<List<PhotoItem>>

    /**
     * get a photo from server by random.
     *
     * param:
     * collections:Public collection ID(‘s) to filter selection. If multiple, comma-separated
     * featured: Limit selection to featured photos.
     * username: Limit selection to a single user.
     * query: Limit selection to photos matching a search term.
     * orientation: Filter search results by photo orientation. Valid values are landscape, portrait, and squarish.
     * count: The number of photos to return. (Default: 1; max: 30)
     */
    @GET("/photos/random")
    fun getRandomPhotos(
        @Query("collections") collections: String,
        @Query("featured") featured: String,
        @Query("username") username: String,
        @Query("query") query: String,
        @Query("orientation") orientation: String,
        @Query("count") count: String
    ): Call<List<PhotoItem>>

    /**
     * get a photo from server by random, without any parameters.
     */
    @GET("/photos/random")
    fun getRandomPhoto(): Call<PhotoItem>

    /**
     * get a list of photo collections curated.
     *
     * param:
     * page: optional, default 1;
     * per_page: optional, default 10;
     */
    @GET("/collections/curated")
    fun getCollections(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<CollectionsItem>

    /**
     * get a photo collection.
     *
     * param:
     * id: The collection’s ID. Required.
     * page: optional, default 1;
     * per_page: optional, default 10;
     */
    @GET("/collection/@{id}/photos")
    fun getCollections(
        @Path("id") id: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): CollectionsItem
}