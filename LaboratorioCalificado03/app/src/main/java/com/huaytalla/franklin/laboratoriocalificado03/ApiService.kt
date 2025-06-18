package com.huaytalla.franklin.laboratoriocalificado03

import com.huaytalla.franklin.laboratoriocalificado03.TeacherResponse

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("list/teacher-b")
    suspend fun getTeachers(): Response<TeacherResponse>
}
