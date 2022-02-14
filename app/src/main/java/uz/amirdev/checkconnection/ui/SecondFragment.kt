package uz.amirdev.checkconnection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.amirdev.checkconnection.R
import uz.amirdev.checkconnection.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        binding.previousBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.containerView, FirstFragment()).commit()
        }
        return binding.root
    }

}