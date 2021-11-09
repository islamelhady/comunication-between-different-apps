package com.elhady.middleman.models

import android.os.Parcelable
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.parcel.Parcelize


/**
 * Created by islam elhady on 06-Nov-21.
 */
@Parcelize
data class User(
    var id: Long,
    var name: String,
    var username: String,
    var email: String,
    var phone: String,
    var website: String
) : Parcelable {

    fun getUserJson(): String {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<User> = moshi.adapter(User::class.java)
        return jsonAdapter.toJson(this)
    }
}

fun getUserObject(userJson: String): User? {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val jsonAdapter: JsonAdapter<User> = moshi.adapter(User::class.java)
    return jsonAdapter.fromJson(userJson)
}
