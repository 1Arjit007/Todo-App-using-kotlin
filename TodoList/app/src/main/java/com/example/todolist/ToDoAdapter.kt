package com.example.todolist

import android.content.Intent
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_row.view.*

class ToDoAdapter(val todos:List<String>):RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_row,parent,false))
    }

    override fun getItemCount(): Int {
        return todos.count()
            }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val title= todos[position]
        holder.bindTodo(title)
    }

    class ToDoHolder(v:View):RecyclerView.ViewHolder(v),View.OnClickListener{
        var view:View=v
        var title:String=""
        init {
            v.setOnClickListener(this)
        }
        fun bindTodo(title:String){
            this.title=title
            view.textView.text=title
        }
        override fun onClick(p0: View?) {
           val intent= Intent(view.context,CompleteToDoActivity::class.java)
            intent.putExtra("title",title)
            startActivity(view.context,intent,null)
        }

    }
}