package com.example.a24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.a24.databinding.FragmentBlank2Binding
import com.example.a24.databinding.FragmentBlankBinding

class BlankFragment2 : Fragment() {
    private val dataModel:DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.message_to_fragment2.observe(activity as LifecycleOwner,{
            binding.textView2.text=it
        })
        binding.sendMess.setOnClickListener{
            dataModel.message_to_fragment1.value="Hello from fragment 2"
        }
        binding.sendMessToActivity.setOnClickListener{
            dataModel.message_to_activity.value="Hello activity from fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}