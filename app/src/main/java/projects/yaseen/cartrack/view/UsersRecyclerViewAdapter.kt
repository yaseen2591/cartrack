package projects.yaseen.cartrack.view

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.amulyakhare.textdrawable.TextDrawable
import projects.yaseen.cartrack.R
import projects.yaseen.cartrack.room.model.RestUserModel
import com.amulyakhare.textdrawable.util.ColorGenerator


class UsersRecyclerViewAdapter(_context: Context, _userList: List<RestUserModel>) :
    RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder>() {

    val context = _context
    val userList = _userList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.name

        val generator = ColorGenerator.MATERIAL // or use DEFAULT
        val color: Int = generator.getColor(user.email)

        val drawable = TextDrawable.builder()
            .buildRect(user.name.get(0).toString(), color)

        holder.userAvatar.setImageDrawable(drawable)

    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.userName)
        val userAvatar: ImageView = itemView.findViewById(R.id.userAvatar)
    }

}