package org.wikiedufoundation.wikiedudashboard.data.network

import org.wikiedufoundation.wikiedudashboard.ui.campaign.data.ExploreCampaignsResponse
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.articlesedited.data.ArticlesEdited
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.common.data.CourseDetailResponse
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.recentactivity.data.RecentActivityResponse
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.students.data.StudentListResponse
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.uploads.data.CourseUploadResponse
import org.wikiedufoundation.wikiedudashboard.ui.courselist.data.ExploreCoursesResponse
import org.wikiedufoundation.wikiedudashboard.ui.dashboard.data.MyDashboardResponse
import org.wikiedufoundation.wikiedudashboard.ui.profile.data.ProfileDetailsResponse
import org.wikiedufoundation.wikiedudashboard.ui.profile.data.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url

interface WikiEduDashboardApi {

    /**
     * This API is used to fetch course details and statistics.
     ***/
    @GET
    suspend fun getCourseDetail(@Url url: String): CourseDetailResponse

    /**
     * This API is used to fetch list of articles of a course.
     ***/
    @GET
    suspend fun getArticlesEdited(@Url url: String): ArticlesEdited

    /**
     * This API is used to fetch list of articles edited in a course.
     ***/
    @GET
    suspend fun getRecentActivity(@Url url: String): RecentActivityResponse

    /**
     * This API is used to fetch list of students in a course.
     ***/
    @GET
    suspend fun getStudentList(@Url url: String): StudentListResponse

    /**
     * This API is used to fetch list of uploads by the users in a course.
     ***/
    @GET
    suspend fun getCourseUploads(@Url url: String): CourseUploadResponse

    /**
     * This API is used to fetch Dashboard details. Ex - My Courses - Active, Archived.
     ***/
    @GET("dashboard.json")
    suspend fun getDashboardDetail(
        @Header("Cookie") sessionIdAndToken: String
    ): MyDashboardResponse

    /**
     * This API is used to fetch list of active courses.
     ***/
    @GET("explore.json")
    suspend fun getExploreCourses(@Header("Cookie") sessionIdAndToken: String): ExploreCoursesResponse

    /**
     * This API is used to fetch list of active campaigns.
     ***/
    @GET("campaigns.json")
    suspend fun getExploreCampaigns(@Header("Cookie") sessionIdAndToken: String): ExploreCampaignsResponse

    /**
     * This API is used to fetch profile stats.
     ***/
    @GET("user_stats.json")
    suspend fun getProfileResponse(
        @Header("Cookie") sessionIdAndToken: String,
        @Query("username") username: String
    ): ProfileResponse

    /**
     * This API is used to fetch profile stats.
     ***/
    @GET
    suspend fun getProfileDetailsResponse(
        @Url url: String
    ): ProfileDetailsResponse
}
