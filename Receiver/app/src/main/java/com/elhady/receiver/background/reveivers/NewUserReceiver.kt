package com.elhady.receiver.background.reveivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.elhady.receiver.ui.main.MainActivity

/**
 * Created by islam elhady on 11-Nov-21.
 */
class NewUserReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val userJson = intent.getStringExtra("data")

        Intent(context, MainActivity::class.java).apply {
            putExtra("data", userJson)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(this)
        }
    }
}