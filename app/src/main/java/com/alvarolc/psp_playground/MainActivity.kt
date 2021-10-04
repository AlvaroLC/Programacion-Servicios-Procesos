package com.alvarolc.psp_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var label: TextView
    lateinit var button: Button
    lateinit var spinner: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        label = findViewById(R.id.label)
        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            //launchARN()
            //withThread()
            //withThreadAndPost()
            //withRunUiThread()
            //threadFromParam()
            //launchMultipleThreads()
            //launchInsideThread()
            //launchInsideThread2()
            //postDelayed()
            //progressBar
            progressBarWhileCounting()
        }
    }

    //Este metodo si se ejecta desde la UI
    private fun launchARN() {
        for (i in 1..100) {
            label.text = "Hola $i"
            Thread.sleep(2000)
        }
    }

    //Este metodo crea un nuevo hilo y no se ejecuta en el hilo UI
    //Da error al intentar modificar la vista de la UI fuera del hilo de la UI
    private fun withThread() {
        Thread(Runnable {
            for (i in 1..100) {
                label.text = "Hola $i"
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun withThreadAndPost() {
        Thread(Runnable {
            for (i in 1..100) {
                //post obliga a ejecutar el metodo en el hilo de la UI
                label.post {
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun withRunUiThread() {
        Thread(Runnable {
            for (i in 1..100) {
                runOnUiThread {
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun threadFromParam() {
        val thread = Thread(Runnable {
            for (i in 1..100) {
                runOnUiThread {
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
            }
        })

        thread.start()
    }

    private fun launchMultipleThreads(){
        val thread1 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "Thread1 $i")
                Thread.sleep(1000)
            }
        })

        val thread2 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "Thread2 $i")
                Thread.sleep(1500)
            }
        })

        val thread3 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "Thread3 $i")
                Thread.sleep(2000)
            }
        })
        thread3.start()
        thread1.start()
        thread2.start()
    }

    //Primero ejecuta el for del hilo1 al empezar a ejecutarse antes de crear el hilo 2
    private fun launchInsideThread(){
        Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "Thread1 $i")
                Thread.sleep(1000)
            }

            Thread(Runnable {
                for (i in 1..100) {
                    Log.d("@dev", "Thread2 $i")
                    Thread.sleep(1000)
                }
            }).start()
        }).start()
    }

    //En este caso se ejecuta el padre, y lo primero que hace es crear al hijo
    //entonces empiezan a ejecutarse los 2 a la vez
    private fun launchInsideThread2(){
        Thread(Runnable {
            Thread(Runnable {
                for (i in 1..100) {
                    Log.d("@dev", "Thread2 $i")
                    Thread.sleep(1000)
                }
            }).start()
            for (i in 1..100) {
                Log.d("@dev", "Thread1 $i")
                Thread.sleep(1000)
            }

        }).start()
    }

    //Hilo con delay

    private fun postDelayed(){
        Handler(Looper.getMainLooper()).postDelayed({
            label.text = "Hola!!"
        }, 3000)
    }

    private fun progressBar() {
        Thread(Runnable {
            for (i in 1..10) {
                runOnUiThread {
                    label.text = "Hola $i"
                }
                Thread.sleep(1000)
            }

            runOnUiThread{
                spinner.visibility = View.VISIBLE
            }
            Handler(Looper.getMainLooper()).postDelayed({
                spinner.visibility = View.GONE
            }, 3000)

        }).start()
    }

    private fun progressBarWhileCounting() {
        Thread(Runnable {
            for (i in 1..10) {
                runOnUiThread {
                    label.text = "Hola $i"
                    spinner.visibility = View.VISIBLE
                }
                Thread.sleep(1000)
            }

            runOnUiThread{
                spinner.visibility = View.GONE
            }


        }).start()
    }

}