package com.elhady.middleman

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.*
import com.elhady.middleman.background.SocketWorker
import com.elhady.middleman.models.getUserObject
import java.util.concurrent.TimeUnit

class UserReceiver : BroadcastReceiver() {

    private val TAG = UserReceiver::class.simpleName

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val userJson = intent.getStringExtra("data")
        val user = userJson?.let { getUserObject(it) }
        Log.i(TAG, "onReceive: $user")


        val socketWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SocketWorker>()
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                ).addTag(System.currentTimeMillis().toString())
                .setInputData(workDataOf("user" to userJson))
                .build()

        WorkManager
            .getInstance(context)
            .enqueue(socketWorkRequest)
    }
}