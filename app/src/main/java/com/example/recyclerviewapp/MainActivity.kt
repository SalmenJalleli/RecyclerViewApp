package com.example.recyclerviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val todoList = mutableListOf(
            Todo("follow androidDevs",false),
            Todo("practice chess",false),
            Todo("feed cat",true),
            Todo("do sports",true),
            Todo("change house paint",false),
            Todo("attend match",false),
            Todo("call my mom",true),
            Todo("call daddy",true),
            Todo("attend german course",false),
            Todo("Donate for charity",true),
            Todo("Go to the gym",true))
        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter=adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)
        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title,false)
            adapter.addNewTodo(todo)
        }
    }
}