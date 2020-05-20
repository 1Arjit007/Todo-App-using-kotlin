package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_todo.*

class CreateTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)
        SaveButton.setOnClickListener {
            var title=""
            if(ImportantCheckBox.isChecked)
            {
                title ="❕ "+TitleEditText.text.toString()
            }
            else{
                title = TitleEditText.text.toString()
            }
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()
            todos?.add(title)
            prefs.edit().putStringSet("todostrings",todos).apply()
            finish()
        }
    }
}
