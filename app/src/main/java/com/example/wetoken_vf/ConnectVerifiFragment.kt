package com.example.wetoken_vf

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent.getIntent
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.text.method.KeyListener
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ConnectVerifiFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ConnectVerifiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConnectVerifiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
lateinit var edittxtCode:EditText
    lateinit var btnVerif:Button
    lateinit var txtTel:TextView
    var codeSMS = ""


    lateinit var edittxt1:EditText
    lateinit var edittxt2:EditText
    lateinit var edittxt3:EditText
    lateinit var edittxt4:EditText
    lateinit var edittxt5:EditText
    lateinit var edittxt6:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_connect_verifi, container, false)


        val sharedPrf = this.activity?.getPreferences(Context.MODE_PRIVATE)
        val tel = sharedPrf?.getString("tel", "0")!!

        edittxt1 = view.findViewById(R.id.edittext1)
        edittxt2 = view.findViewById(R.id.edittext2)
        edittxt3 = view.findViewById(R.id.edittext3)
        edittxt4 = view.findViewById(R.id.edittext4)
        edittxt5 = view.findViewById(R.id.edittext5)
        edittxt6 = view.findViewById(R.id.edittext6)



        edittxt1.setOnFocusChangeListener(object: View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                edittxt1.post(Runnable {
                    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(edittxt1, InputMethodManager.SHOW_IMPLICIT)
                })
            }

        })
        edittxt1.requestFocus()


        edittxt1.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){
                    edittxt1.setText("")
                    edittxt1.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt1.setTextColor(Color.parseColor("#000000"))
                } else {
                    edittxt1.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt1.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt1.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt1.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt1.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt1.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt1.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt1.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt1.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt1.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt1.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt1.setText("9") }
                    edittxt2.requestFocus()
                }

                return true
            }

        })





        edittxt2.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){

                    edittxt2.setText("")
                    edittxt2.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt2.setTextColor(Color.parseColor("#000000"))
                    edittxt1.requestFocus()
                } else {

                    edittxt2.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt2.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt2.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt2.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt2.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt2.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt2.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt2.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt2.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt2.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt2.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt2.setText("9") }
                    edittxt3.requestFocus()
                }
                return true
            }

        })

        edittxt3.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){

                    edittxt3.setText("")
                    edittxt3.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt3.setTextColor(Color.parseColor("#000000"))
                    edittxt2.requestFocus()
                } else {

                    edittxt3.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt3.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt3.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt3.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt3.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt3.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt3.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt3.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt3.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt3.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt3.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt3.setText("9") }
                    edittxt4.requestFocus()

                }
                return true
            }

        })

        edittxt4.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){

                    edittxt4.setText("")
                    edittxt4.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt4.setTextColor(Color.parseColor("#000000"))
                    edittxt3.requestFocus()
                } else {

                    edittxt4.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt4.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt4.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt4.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt4.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt4.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt4.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt4.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt4.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt4.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt4.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt4.setText("9") }
                    edittxt5.requestFocus()
                }
                return true
            }

        })

        edittxt5.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){

                    edittxt5.setText("")
                    edittxt5.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt5.setTextColor(Color.parseColor("#000000"))
                    edittxt4.requestFocus()
                } else {

                    edittxt5.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt5.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt5.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt5.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt5.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt5.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt5.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt5.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt5.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt5.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt5.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt5.setText("9") }
                    edittxt6.requestFocus()
                }
                return true
            }

        })

        edittxt6.setOnKeyListener(object : KeyListener, View.OnKeyListener {
            override fun onKeyDown(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun onKeyUp(view: View?, text: Editable?, keyCode: Int, event: KeyEvent?): Boolean {
                return true }
            override fun getInputType(): Int { return 1 }
            override fun onKeyOther(view: View?, text: Editable?, event: KeyEvent?): Boolean {
                return true }
            override fun clearMetaKeyState(view: View?, content: Editable?, states: Int) {}

            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(keyCode == KeyEvent.KEYCODE_DEL){


                    edittxt6.setText("")
                    edittxt6.setBackgroundResource(R.drawable.circle_edittext)
                    edittxt6.setTextColor(Color.parseColor("#000000"))
                    edittxt5.requestFocus()
                } else {
                    edittxt6.setBackgroundResource(R.drawable.circle_edittext_full)
                    edittxt6.setTextColor(Color.parseColor("#FFFFFF"))
                    if (keyCode == KeyEvent.KEYCODE_0) { edittxt6.setText("0") }
                    if (keyCode == KeyEvent.KEYCODE_1) { edittxt6.setText("1") }
                    if (keyCode == KeyEvent.KEYCODE_2) { edittxt6.setText("2") }
                    if (keyCode == KeyEvent.KEYCODE_3) { edittxt6.setText("3") }
                    if (keyCode == KeyEvent.KEYCODE_4) { edittxt6.setText("4") }
                    if (keyCode == KeyEvent.KEYCODE_5) { edittxt6.setText("5") }
                    if (keyCode == KeyEvent.KEYCODE_6) { edittxt6.setText("6") }
                    if (keyCode == KeyEvent.KEYCODE_7) { edittxt6.setText("7") }
                    if (keyCode == KeyEvent.KEYCODE_8) { edittxt6.setText("8") }
                    if (keyCode == KeyEvent.KEYCODE_9) { edittxt6.setText("9") }

                    val code = edittxt1.text.toString() + edittxt2.text.toString()+edittxt3.text.toString() + edittxt4.text.toString()+edittxt5.text.toString()+edittxt6.text.toString()
                    println(code)
                    //codeSMS = "12345"
                    codeSMS = "222222"
                    if(code.equals(codeSMS)){
                        //Toast.makeText(context,"Code correcte",Toast.LENGTH_LONG).show()
                        val signUPAFragment = SignUPAFragment()

                        val fragManager = activity?.supportFragmentManager
                        val transac = fragManager?.beginTransaction()
                        transac?.replace(R.id.fragmnt, signUPAFragment)
                        transac?.addToBackStack(null)
                        transac?.commit()
                        //confirmerCompte(tel)
                    } else {
                        Toast.makeText(context,"Code incorrecte",Toast.LENGTH_LONG).show()
                    }

                }
                return true
            }

        })

        //val phoneNumber = "+21620862299"
        // val phoneNumber = "+21622477877"

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                println("onVerificationCompleted:$p0")
                Toast.makeText(context,"Message envoyé",Toast.LENGTH_SHORT).show()
                codeSMS = p0.smsCode.toString()
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                println("error: "+p0)
                if (p0 is FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(context,"Probleme de connexion",Toast.LENGTH_LONG).show()
                    // Invalid request
                    // ...
                } else if (p0 is FirebaseTooManyRequestsException) {
                    if(context!=null) {
                        Toast.makeText(context,"Veuillez réessayer plus tard",Toast.LENGTH_LONG).show()
                    }
                    // The SMS quota for the project has been exceeded
                    // ...
                }
            }


            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                println("onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later

                println("token :"+token)
                // ...
            }
        }

//sms code
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            tel, // Phone number to verify
            60, // Timeout duration
            TimeUnit.SECONDS, // Unit of timeout
            MainActivity(), // Activity (for callback binding)
            callbacks
        )




/*


        btnVerif = view.findViewById(R.id.btnVerif)
        txtTel=view.findViewById(R.id.txtTel)
        txtTel.text = tel









        btnVerif.setOnClickListener {
  if(code.equals(edittxtCode.text.toString()))
 {
     val connectVeriflFragment = SignUPAFragment()

     val fragManager = activity?.supportFragmentManager
     val transac = fragManager?.beginTransaction()
     transac?.replace(R.id.fragmnt, connectVeriflFragment)
     transac?.addToBackStack(null)
     transac?.commit()

 } else{
     //Toast.makeText(context,"code incorecte",Toast.LENGTH_SHORT).show()



      val connectVeriflFragment = SignUPAFragment()
      val fragManager = activity?.supportFragmentManager
      val transac = fragManager?.beginTransaction()
      transac?.replace(R.id.fragmnt, connectVeriflFragment)
      transac?.addToBackStack(null)
      transac?.commit()
 }

}
*/











return view
}

// TODO: Rename method, update argument and hook method into UI event
fun onButtonPressed(uri: Uri) {
listener?.onFragmentInteraction(uri)
}


interface OnFragmentInteractionListener {
// TODO: Update argument type and name
fun onFragmentInteraction(uri: Uri)
}

companion object {
/**
* Use this factory method to create a new instance of
* this fragment using the provided parameters.
*
* @param param1 Parameter 1.
* @param param2 Parameter 2.
* @return A new instance of fragment ConnectVerifiFragment.
*/
// TODO: Rename and change types and number of parameters
@JvmStatic
fun newInstance(param1: String, param2: String) =
 ConnectVerifiFragment().apply {
     arguments = Bundle().apply {
         putString(ARG_PARAM1, param1)
         putString(ARG_PARAM2, param2)
     }
 }
}
}
