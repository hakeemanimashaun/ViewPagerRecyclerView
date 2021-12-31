package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.assignment.week_5_task_hakeemanimashaun.Communicator
import com.assignment.week_5_task_hakeemanimashaun.R
import com.assignment.week_5_task_hakeemanimashaun.RegistrationFormUtil


class HomeFragment : Fragment() {
     //initialize communicator
    private lateinit var communicator: Communicator
    //spinner options
    private val sexList = arrayOf("male","female","others")
    //spinner result
    lateinit var sexResult: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        communicator =  activity as Communicator

        val name = view.findViewById<EditText>(R.id.name)
        val email = view.findViewById<EditText>(R.id.email)
        val userName = view.findViewById<EditText>(R.id.user_name)
        val mobile = view.findViewById<EditText>(R.id.mobile)
        val password = view.findViewById<EditText>(R.id.passWord)

        //spinner adapter
        val adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_item,sexList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        val spinner = view.findViewById<Spinner>(R.id.sexSpinner)
        spinner.adapter = adapter
        //spinner selection
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sexResult = parent?.getItemAtPosition(position).toString()
                Toast.makeText(requireActivity(), "you selected $sexResult", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        //submit button actions
        val submitButton = view.findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener {
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val userNameText = userName.text.toString()
            val mobileText = mobile.text.toString()
            val passwordText = password.text.toString()

            if(RegistrationFormUtil.validateRegistrationInput(nameText, emailText, mobileText, sexResult)){
            Toast.makeText(requireContext(), "field is empty", Toast.LENGTH_SHORT).show()
            }

            else if(RegistrationFormUtil.checkName(nameText, emailText, mobileText, sexResult)){
                Toast.makeText(requireContext(), "enter valid name", Toast.LENGTH_SHORT).show()
            }

            else if (!RegistrationFormUtil.isEmailValid(nameText, emailText, mobileText, sexResult)) {
                Toast.makeText(requireContext(), "enter valid email", Toast.LENGTH_SHORT).show()
            }

            else if (!RegistrationFormUtil.checkMobile(nameText, emailText, mobileText, sexResult)) {
                Toast.makeText(requireContext(), "Invalid phone number", Toast.LENGTH_SHORT).show()
            }
            else {
                communicator.passDataCom(
                    nameText, emailText, userNameText,
                    mobileText, sexResult, passwordText
                )
            }
        }
        return view
    }


}
