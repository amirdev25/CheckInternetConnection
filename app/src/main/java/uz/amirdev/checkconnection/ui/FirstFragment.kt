package uz.amirdev.checkconnection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.amirdev.checkconnection.R
import uz.amirdev.checkconnection.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)

        binding.nextBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.containerView, SecondFragment()).commit()
        }

        return binding.root
    }
}