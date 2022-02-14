package uz.amirdev.checkconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import uz.amirdev.checkconnection.databinding.ActivityMainBinding
import uz.amirdev.checkconnection.databinding.NoInternetDialogBinding
import uz.amirdev.checkconnection.ui.FirstFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var builder: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //checking connection
        checkConnection()
        //fragment transaction
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, FirstFragment()).commit()
    }

    private fun checkConnection() {
        CheckConnection.init(binding.root.context)
        CheckConnection.observe(this) {
            if (!it) {
                showAlertDialog()
            } else {
                if (builder != null)
                    builder?.dismiss()
            }
        }

    }

    private fun showAlertDialog() {
        builder = AlertDialog.Builder(binding.root.context).create()
        val view = NoInternetDialogBinding.inflate(layoutInflater)
        builder!!.setView(view.root)
        builder?.setCancelable(false)
        view.tryAgainButton.setOnClickListener {
            Toast.makeText(binding.root.context, "No internet", Toast.LENGTH_SHORT).show()
        }
        builder?.show()
    }
}