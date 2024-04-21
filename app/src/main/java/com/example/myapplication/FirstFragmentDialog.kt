package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.model.DatabaseHelper
import com.example.myapplication.model.User

class FirstFragmentDialog(val user: User, val fragment: FirstFragment) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addBtd: Button = view.findViewById(R.id.editBtn)
        val deleteBtn: Button = view.findViewById(R.id.deleteBtn)
        addBtd.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, AddNewUser::class.java)
            intent.putExtra("id",user.id)
            intent.putExtra("name", user.name)
            intent.putExtra("photo", user.photo)
            intent.putExtra("jobTitle", user.jobTitle)
            intent.putExtra("experience", user.experience)// Передаем объект User в Intent
            this.dismiss()
            startActivity(intent)
        })

        deleteBtn.setOnClickListener(View.OnClickListener {
            DatabaseHelper(requireContext()).deleteUser(user.id)
            fragment.updateRecycleView()
            this.dismiss()
        })
    }
}