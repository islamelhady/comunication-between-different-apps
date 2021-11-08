package com.elhady.emitter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.elhady.emitter.R
import com.elhady.emitter.data.model.User
import com.elhady.emitter.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 08-Nov-21.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.list.adapter = UsersAdapter(UserClick {
            showSendDialog(it)
        })

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getUsersList()
        }

        handleActivityIntent(intent)

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleActivityIntent(intent)
    }

    private fun handleActivityIntent(intent: Intent?) {
        if (intent != null) {
            val message = intent.getStringExtra("message")
            if (!message.isNullOrEmpty())
                showReceivedDialog(message)
        }
    }

    private fun showReceivedDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton(getString(R.string.btn_ok)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun showSendDialog(user: User) {
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.message_send_user, user.name))
            .setPositiveButton(getString(R.string.btn_send)) { dialog, _ ->
                viewModel.sendUserToMiddleApp(user)
                dialog.dismiss()
            }.setNegativeButton(getString(R.string.btn_cancel)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

}
