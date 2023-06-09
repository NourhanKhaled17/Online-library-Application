package com.example.onlinelibraryapplication.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.Users
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

lateinit var name: String
lateinit var email2: String
lateinit var phone: String
lateinit var password2: String
lateinit var auth: FirebaseAuth
private lateinit var database: DatabaseReference

class SignupActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient

    companion object {
        private const val RC_SIGN_IN = 9001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //This Code to change status bar color in this activity only to Green Mint-->
        val window: Window = window
        window.statusBarColor = Color.parseColor("#5a795a")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btn_google.setOnClickListener {
            signIn()
        }

        editTextTextPhoneNumber.suffixTextView.gravity = Gravity.CENTER

        loginButton()
        changeTextColor()
        goToLoginPage()
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, LoginActivity.RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val addOnCompleteListener = auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "signInWithCredential:success", Toast.LENGTH_LONG).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "signInWithCredential:failure", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == LoginActivity.RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Toast.makeText(this, "firebaseAuthWithGoogle:" + account.id, Toast.LENGTH_LONG)
                    .show()
                firebaseAuthWithGoogle(account.idToken!!)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "Google sign in failed", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loginButton() {
        signup.setOnClickListener {
            name = textInputLayoutPerson.editText?.text.toString().trim()
            email2 = textInputLayoutEmail2.editText?.text.toString().trim()
            phone = editTextTextPhoneNumber.editText?.text.toString().trim()
            password2 = textInputLayoutPassword2.editText?.text.toString().trim()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = Users(name, phone, email2, password2)
            database.child(name).setValue(user).addOnSuccessListener {
                textInputLayoutPerson.editText?.text?.clear()
                textInputLayoutEmail2.editText?.text?.clear()
                editTextTextPhoneNumber.editText?.text?.clear()
                textInputLayoutPassword2.editText?.text?.clear()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed ", Toast.LENGTH_SHORT).show()
            }
            if (validation(name, email2, phone, password2)) {
                auth.createUserWithEmailAndPassword(
                    email2,
                    password2
                ).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(
                            baseContext, "SignUp Done.",
                            Toast.LENGTH_LONG
                        ).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)

                    } else {

                        Toast.makeText(
                            baseContext, "SignUp failed.Email Already Exist",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun validation(
        name: String,
        email: String,
        phone: String,
        password: String,
    ): Boolean {
        val regxName = "^[\\p{L} .'-]+$"
        val regxEmail = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
        val regxPhone = "^\\d{10}$"
        val regxPasswordLength = "^(?=.*[A-Z])" +
                "(?=.*[a-z])" +
                "(?=.*?[0-9])" +
                "(?=.*?[!@#$&*~])" +
                ".{8,}"

        if (name.isEmpty()) { //check if name field is empty or not
            textInputLayoutPerson.error = "الاسم مطلوب"
            return false
        } else if (!name.matches(regxName.toRegex())) { //check name validation
            textInputLayoutPerson.error = "أدخل الأحرف الأبجدية فقط"
            return false
        } else if (email.isEmpty()) { //check if email field is empty or not
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = "البريد الإلكتروني مطلوب"
            return false
        } else if (!email.matches(regxEmail.toRegex())) { //check email validation
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = "أدخل بريدًا إلكترونيًا صالحًا"
            return false
        } else if (phone.isEmpty()) { //check if phone field is empty or not
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = null
            editTextTextPhoneNumber.error = "الهاتف مطلوب"
            return false
        } else if (!phone.matches(regxPhone.toRegex())) { //check phone validation
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = null
            editTextTextPhoneNumber.error = "أدخل رقم هاتف صالحًا"
            return false
        } else if (password.isEmpty()) {
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = null
            editTextTextPhoneNumber.error = null
            textInputLayoutPassword2.error = "كلمة المرور مطلوبة"
            return false
        } else if (!password.matches(regxPasswordLength.toRegex())) {
            textInputLayoutPerson.error = null
            textInputLayoutEmail2.error = null
            editTextTextPhoneNumber.error = null
            textInputLayoutPassword2.error = "كلمة المرور ضعيفة جدا"
            return false
        } else {
            textInputLayoutPassword2.error = null
            return true
        }
    }

    private fun changeTextColor() {
        val myText = "هل لديك حساب؟ سجِل"
        val mySpannableString = SpannableString(myText)
        val myWhite = ForegroundColorSpan(Color.WHITE)

        mySpannableString.setSpan(myWhite, 14, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        do_you_have_an_account.text = mySpannableString
    }

    private fun goToLoginPage() {
        do_you_have_an_account.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}