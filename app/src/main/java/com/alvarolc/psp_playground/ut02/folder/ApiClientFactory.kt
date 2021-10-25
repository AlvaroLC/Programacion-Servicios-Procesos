package com.alvarolc.psp_playground.ut02.folder

import com.alvarolc.psp_playground.R

class ApiClientFactory {

    fun build(actionId: Int): ApiClient =
        when (actionId) {
            R.id.action_mock -> MockApiClient()
            else -> MockApiClient()
        }
}