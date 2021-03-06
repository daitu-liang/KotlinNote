package com.kakaxi.kotlinnote.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kakaxi.kotlinnote.R
import com.kakaxi.kotlinnote.utils.Constants
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnTip.setOnClickListener{
            Toast.makeText(activity,"toast",Toast.LENGTH_LONG).show()
//            activity?.let { it1 -> HomeDesActivity.actionStart(it1,"参数") }
            activity?.let { it1 ->
                com.kakaxi.kotlinnote.kotlinzone.startActivity<HomeDesActivity>(it1){
                    putExtra("userId",12)
                    putExtra("name","apple")
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Constants.HTTP_BASE_URL
    }
}
