package com.alvarolc.psp_playground.exercise_plagricola.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.alvarolc.psp_playground.R
import com.alvarolc.psp_playground.exercise_plagricola.app.MockApiClient
import com.alvarolc.psp_playground.exercise_plagricola.app.RetrofitApiClient
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertDataRepository
import com.alvarolc.psp_playground.exercise_plagricola.domain.GetAlertsUseCase
import com.alvarolc.psp_playground.ut02.folder.data.Exercise02Activity
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertRemoteSource

class AlertActivity : AppCompatActivity() {

    private val TAG: String = AlertActivity::class.java.simpleName

    private val alertViewModel : AlertViewModel=
        AlertViewModel(GetAlertsUseCase(AlertDataRepository(AlertRemoteSource(RetrofitApiClient()))))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        render()
    }

    private fun render() {
        Thread {
            val model = alertViewModel.getAlertModel()
            Log.d(TAG, model.toString())
        }.start()

    }


}

