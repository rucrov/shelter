package com.example.myapplication

import ImageLoader
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.User


interface MyClickListener{
    fun onClick(user: User)
}


class UserAdapter(val listener: MyClickListener, val fragmentManager: FragmentManager, val fragment: FirstFragment) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var usersList = emptyList<User>()

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val firstNameView: TextView = view.findViewById(R.id.nameTextView)
        val companyView: TextView = view.findViewById(R.id.companyTextView)
        val moreButton: ImageButton = view.findViewById(R.id.moreButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_person_component, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = usersList[position]
        val imageView = ImageLoader(holder.imageView)

        imageView.execute(usersList[position].photo)
        holder.firstNameView.text = currentUser.name
        holder.companyView.text = currentUser.jobTitle

        holder.itemView.setOnClickListener {
            listener.onClick(usersList[position])
        }

        holder.moreButton.setOnClickListener(View.OnClickListener {
            FirstFragmentDialog(usersList[position],fragment).show(fragmentManager,"dialog")
        })
    }

    override fun getItemCount(): Int {
        return usersList.size
    }



    fun setList(list: List<User>) {
        usersList = list
        notifyDataSetChanged()
    }
}
