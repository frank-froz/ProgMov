package com.huaytalla.franklin.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.huaytalla.franklin.laboratoriocalificado03.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        adapter = TeacherAdapter(emptyList(),
            onClick = { teacher -> llamarAlProfesor(teacher.phone_number) },
            onLongClick = { teacher -> enviarCorreo(teacher.email) }
        )

        binding.rvTeachers.adapter = adapter
        binding.rvTeachers.layoutManager = GridLayoutManager(this, 2)

        observarViewModel()
    }

    private fun observarViewModel() {
        viewModel.teacherList.observe(this) { teachers ->
            adapter.list = teachers
            adapter.notifyDataSetChanged()
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.isVisible = isLoading
        }

        viewModel.errorApi.observe(this) { error ->
            Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun llamarAlProfesor(numero: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$numero")
        startActivity(intent)
    }

    private fun enviarCorreo(correo: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$correo")
        startActivity(intent)
    }
}