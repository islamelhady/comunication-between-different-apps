package com.elhady.emitter.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.elhady.emitter.R
import com.elhady.emitter.data.model.User
import com.elhady.emitter.data.remote.ApiService
import com.elhady.emitter.utils.Status
import kotlinx.coroutines.launch


/**
 * Created by islam elhady on 08-Nov-21.
 */
class MainViewModel(
    private val apiService: ApiService,
    private val context: Context
) : ViewModel() {

    private val TAG = MainViewModel::class.simpleName

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users


    fun getUsersList() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _users.value = apiService.getUsers()
                _status.value = Status.DONE
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _users.value = ArrayList()
            }
        }
    }

    fun sendUserToMiddleApp(user: User) {
        Log.i(TAG, "sendUserToMiddleApp: $user")

        Intent(getString(R.string.action_send_user)).also { intent ->
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            intent.putExtra("data", user.getUserJson())
            intent.component =
                ComponentName(
                    getString(R.string.middle_app_pkg),
                    getString(R.string.middle_app_receiver_name)
                )
            context.sendBroadcast(intent)
        }
    }


    private fun getString(@StringRes res: Int): String {
        return context.getString(res)
    }
}