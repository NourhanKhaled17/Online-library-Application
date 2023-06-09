package com.example.onlinelibraryapplication.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinelibraryapplication.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

lateinit var email: String
lateinit var password: String
private lateinit var aauth: FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient

    companion object {
        const val RC_SIGN_IN = 9001
    }

    override fun onStart() {
        super.onStart()
        val currentUser = aauth.currentUser
        if (currentUser != null) {
            finish()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        updateUI(currentUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        aauth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //This Code to change status bar color in this activity only to Green Mint-->
        val window: Window = window
        window.statusBarColor = Color.parseColor("#5a795a")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btn_google.setOnClickListener {
            signIn()
        }

        changeTextColor()
        loginButton()
        goToSignupPage()
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        finish()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val addOnCompleteListener = aauth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "signInWithCredential:success", Toast.LENGTH_LONG).show()
                    val user = aauth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "signInWithCredential:failure", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Toast.makeText(this, "firebaseAuthWithGoogle:" + account.id, Toast.LENGTH_SHORT)
                    .show()
                firebaseAuthWithGoogle(account.idToken!!)
                finish()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "فشل تسجيل الدخول بجوجل.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun changeTextColor() {
        val myText = "هل ليس لديك حساب؟ إنشاء حساب"
        val mySpannableString = SpannableString(myText)
        val myWhite = ForegroundColorSpan(Color.WHITE)

        mySpannableString.setSpan(myWhite, 18, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        dont_have_an_account.text = mySpannableString
    }

    private fun loginButton() {
        btn.setOnClickListener {
            email = textInputLayoutEmail.editText?.text.toString().trim()
            password = textInputLayoutPassword.editText?.text.toString().trim()

            if (validation(email, password)) {
                aauth.signInWithEmailAndPassword(
                    email, password
                )
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                baseContext, "تم تسجيل الدخول بنجاح.",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "فشل تسجيل الدخول. البريد أو كلمة المرور خاطئة.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }

    private fun validation(email2: String, password2: String): Boolean {
        val regxEmail = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"

        if (email2.isEmpty()) { //check if name field is empty or not
            textInputLayoutEmail.error = "البريد الإلكتروني مطلوب"
            return false
        } else if (!email.matches(regxEmail.toRegex())) { //check email validation
            textInputLayoutEmail.error = "أدخل بريدًا إلكترونيًا صالحًا"
            return false
        } else if (password2.isEmpty()) {
            textInputLayoutEmail.error = null
            textInputLayoutPassword.error = "كلمة المرور مطلوبة"
            return false
        } else {
            textInputLayoutEmail.error = null
            textInputLayoutPassword.error = null
            return true
        }
    }

    private fun goToSignupPage() {
        dont_have_an_account.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            finish()
            startActivity(intent)
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {

    }
}