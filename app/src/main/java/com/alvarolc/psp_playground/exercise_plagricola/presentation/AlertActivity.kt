package com.alvarolc.psp_playground.exercise_plagricola.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.alvarolc.psp_playground.R
import com.alvarolc.psp_playground.exercise_plagricola.app.AlertRetrofitApiClient
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertDataRepository
import com.alvarolc.psp_playground.exercise_plagricola.domain.GetAlertsUseCase
import com.alvarolc.psp_playground.ut02.folder.data.Exercise02Activity
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertRemoteSource

class AlertActivity : AppCompatActivity() {

        private val TAG: String = AlertActivity::class.java.simpleName
        private val userRepository = AlertDataRepository(AlertRemoteSource(AlertRetrofitApiClient()))

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            Thread {
                runRepository()
            }.start()
        }

        private fun runRepository() {

            //Visualizo el listado de alerts
            val alerts = userRepository.getAlerts()
            alerts.forEach { userApiModel ->
                Log.d(TAG, "$userApiModel")
            }

            //Obtengo un usuario y visualizo el usuario
            val alert = userRepository.getAlert("1671086")
            alert?.run {
                Log.d(TAG, "$this")
            }

        }

    }

