package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.model.DatabaseHelper
import com.example.myapplication.model.User
import com.example.myapplication.model.UserService

class FirstFragment : Fragment(),MyClickListener {


    private var _binding: FragmentFirstBinding? = null
    lateinit var adapter: UserAdapter
    lateinit var recycle: RecyclerView
    private val userList:UserService = UserService()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        initial()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.ligtningBag.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun initial() {
            recycle = binding.recycle
            adapter = UserAdapter(this@FirstFragment)
            recycle.adapter = adapter
            adapter.setList(userList.getUsers())
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(user:User ) {
        val intent = Intent(activity, InfoPerson::class.java)
        intent.putExtra("name", user.name)
        intent.putExtra("photo", user.photo)
        intent.putExtra("jobTitle", user.jobTitle)
        intent.putExtra("experience", user.experience)// Передаем объект User в Intent
        startActivity(intent)
    }
}