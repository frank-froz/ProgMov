package com.huaytalla.franklin.laboratoriocalificado03


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huaytalla.franklin.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    var list: List<Teacher>,
    private val onClick: (Teacher) -> Unit,
    private val onLongClick: (Teacher) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(val binding: ItemTeacherBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = list[position]
        with(holder.binding) {
            txtNombre.text = teacher.name
            txtApellido.text = teacher.last_name

            Glide.with(imgFoto.context)
                .load(teacher.image_url)
                .into(imgFoto)

            root.setOnClickListener { onClick(teacher) }
            root.setOnLongClickListener {
                onLongClick(teacher)
                true
            }
        }
    }

    override fun getItemCount(): Int = list.size
}