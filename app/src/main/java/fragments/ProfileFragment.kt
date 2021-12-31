package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.assignment.week_5_task_hakeemanimashaun.R


class ProfileFragment : Fragment() {

    private var displayName: String? = ""
    private var displayEmail: String? = ""
    private var displayUserName: String? = ""
    private var displayMobile: String? = ""
    private var displaySex: String? = ""
    private var displayPassword: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

//      set fragment_profile.xml to receive inputs passed into Communicator interface as parameters
        displayName = arguments?.getString("name")
        displayEmail = arguments?.getString("email")
        displayMobile = arguments?.getString("mobile")
        displayUserName = arguments?.getString("username")
        displaySex = arguments?.getString("sex")
        displayPassword = arguments?.getString("password")

        // display inputs on fragments_profile.xml
        view.findViewById<TextView>(R.id.display_name).text = displayName
        view.findViewById<TextView>(R.id.display_email).text = displayEmail
        view.findViewById<TextView>(R.id.display_phone).text = displayMobile
        view.findViewById<TextView>(R.id.display_password).text = displayPassword
        view.findViewById<TextView>(R.id.display_user_name).text = displayUserName
        view.findViewById<TextView>(R.id.display_sex).text = displaySex

        return view
    }


}