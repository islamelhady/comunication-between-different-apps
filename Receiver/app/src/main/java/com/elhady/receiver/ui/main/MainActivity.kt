package com.elhady.receiver.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.elhady.receiver.R
import com.elhady.receiver.background.events.ResponseEvent
import com.elhady.receiver.data.model.User
import com.elhady.receiver.data.model.getUserObject
import org.greenrobot.eventbus.EventBus
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by islam elhady on 11-Nov-21.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleActivityIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleActivityIntent(intent)
    }


    private fun handleActivityIntent(intent: Intent?) {
        if (intent != null) {
            val userJson = intent.getStringExtra("data")
            if (!userJson.isNullOrEmpty())
                showNewUserDialog(getUserObject(userJson))
        }
    }

    private fun showNewUserDialog(user: User?) {
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.message_new_user, user?.name))
            .setPositiveButton(getString(R.string.btn_accept)) { dialog, _ ->
                viewModel.insertUser(user!!)
                EventBus.getDefault().post(ResponseEvent("OK"))
                dialog.dismiss()
            }.setNegativeButton(getString(R.string.btn_cancel)) { dialog, _ ->
                EventBus.getDefault().post(ResponseEvent("NOK"))
                dialog.dismiss()
            }.show()
    }
}