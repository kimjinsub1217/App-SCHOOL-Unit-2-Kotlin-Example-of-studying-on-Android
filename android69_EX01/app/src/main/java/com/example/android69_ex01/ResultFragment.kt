package com.example.android69_ex01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android69_ex01.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    lateinit var fragmentResultBinding: FragmentResultBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater)
        mainActivity = activity as MainActivity

        // 파일로 부터 데이터를 가져온다.
        val studentCount = mainActivity.getStudentCount()
        val studentList = mainActivity.getStudentInfo(studentCount)

        // 선택한 행 번째의 객체에서 데이터를 가져와 출력한다.
        fragmentResultBinding.run{
            textViewResult1.text = studentList[mainActivity.rowPosition].name
            textViewResult2.text = studentList[mainActivity.rowPosition].age.toString()
            textViewResult3.text = studentList[mainActivity.rowPosition].korean.toString()
        }

        return fragmentResultBinding.root
    }
}