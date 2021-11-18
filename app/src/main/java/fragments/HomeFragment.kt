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

    private lateinit var communicator: Communicator
    var sexList = arrayOf("male","female","others")
    lateinit var sexResult: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        communicator =  activity as Communicator
        var name = view.findViewById<EditText>(R.id.name)
        var email = view.findViewById<EditText>(R.id.email)
        var userName = view.findViewById<EditText>(R.id.user_name)
        var mobile = view.findViewById<EditText>(R.id.mobile)
        var password = view.findViewById<EditText>(R.id.passWord)


        val adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_item,sexList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        val spinner = view.findViewById<Spinner>(R.id.sexSpinner)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sexResult = parent?.getItemAtPosition(position).toString()
                Toast.makeText(requireActivity(), "you selected ${sexResult}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val submitButton = view.findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener {
            var nameText = name.text.toString()
            var emailText = email.text.toString()
            var userNameText = userName.text.toString()
            var mobileText = mobile.text.toString()
            var passwordText = password.text.toString()

            if(!RegistrationFormUtil.validateRegistrationInput(nameText, emailText, mobileText, sexResult)){
            Toast.makeText(requireContext(), "invalid input", Toast.LENGTH_SHORT).show()
            }
            else if (nameText.isBlank()){
                Toast.makeText(requireContext(), "name cannot be blank", Toast.LENGTH_SHORT).show()
            }
            else if(!RegistrationFormUtil.checkName(nameText)){
                Toast.makeText(requireContext(), "enter valid name", Toast.LENGTH_SHORT).show()
            }
            else if (emailText.isBlank()){
                Toast.makeText(requireContext(), "email is empty", Toast.LENGTH_SHORT).show()
            }
            else if (!RegistrationFormUtil.isEmailValid(emailText)) {
                Toast.makeText(requireContext(), "wrong email input", Toast.LENGTH_SHORT).show()
            }
            else if (mobileText.isBlank()){
                Toast.makeText(requireContext(), "please enter a phone number", Toast.LENGTH_SHORT).show()
            }
            else if (!RegistrationFormUtil.checkMobile(mobileText)) {
                Toast.makeText(requireContext(), "Invalid phone", Toast.LENGTH_SHORT).show()
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
