package com.nnt.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nnt.myapplication.databinding.ActivityDialogInfoGetBinding
import com.nnt.myapplication.databinding.ActivityInfoImcBinding
import com.nnt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoCalcular.setOnClickListener { calcular() }

        binding.botaoVoltar.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        binding.botaoInfo.setOnClickListener {
            infoIMC()
        }
    }

    private fun calcular() {
        val peso = binding.campoPeso.text.toString().replace(",", ".").toDoubleOrNull()
        val altura = binding.campoAltura.text.toString().replace(",", ".").toDoubleOrNull()
        val imc: Double

        if(peso == null || altura == null) {
            Toast.makeText(this, "Por favor preencha todos os campos.", Toast.LENGTH_SHORT).show()
        } else {
            imc = peso / (altura * altura) // IMC = peso (kg) / altura (m) x altura (m)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc", imc.toString())

            startActivity(intent)
        }
    }

    fun infoIMC() {
        val builder = AlertDialog.Builder(this, R.style.Theme_Dialog)
        val dialogBinding = ActivityInfoImcBinding.inflate(LayoutInflater.from(this))
        builder.setView(dialogBinding.root)

        dialogBinding.button.setOnClickListener { alertDialog.dismiss() }

        alertDialog = builder.create()
        alertDialog.show()
    }

}