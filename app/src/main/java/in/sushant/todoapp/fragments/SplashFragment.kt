package `in`.sushant.todoapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import `in`.sushant.todoapp.R

class SplashFragment : Fragment() {

    private lateinit var auth : FirebaseAuth
    private lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler(Looper.myLooper()!!)
        auth = FirebaseAuth.getInstance()
        navController = Navigation.findNavController(view)
        handler.postDelayed(Runnable {
                                     if(auth.currentUser != null){
                                         navController.navigate(R.id.action_splashFragment_to_homeFragment)
                                     }else{
                                         navController.navigate(R.id.action_splashFragment_to_signInFragment)
                                     }
        }, 2000)
    }
}