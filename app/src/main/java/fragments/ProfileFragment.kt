package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.assignment.week_5_task_hakeemanimashaun.R


class ProfileFragment : Fragment() {

    private var displayName: String? = ""
    var displayEmail: String? = ""
    var displayUserName: String? = ""
    var displayMobile: String? = ""
    var displaySex: String? = ""
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

//      set fragment_users.xml to receive inputs passed into Communicator interface as parameters
        displayName = arguments?.getString("name")
        displayEmail = arguments?.getString("email")
        displayMobile = arguments?.getString("mobile")
        displayUserName = arguments?.getString("username")
        displaySex = arguments?.getString("sex")
        displayPassword = arguments?.getString("password")


        view.findViewById<TextView>(R.id.display_name).text = displayName
        view.findViewById<TextView>(R.id.display_email).text = displayEmail
        view.findViewById<TextView>(R.id.display_phone).text = displayMobile
        view.findViewById<TextView>(R.id.display_password).text = displayPassword
        view.findViewById<TextView>(R.id.display_user_name).text = displayUserName
        view.findViewById<TextView>(R.id.display_sex).text = displaySex

        return view
    }


}