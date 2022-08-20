package uz.exemple.less4kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import uz.exemple.less4kotlinapp.model.Member
import uz.exemple.less4kotlinapp.model.User

class SecondActivity : AppCompatActivity() {

    var TAG = SecondActivity::class.java.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    fun initViews() {
        val text1 = findViewById<TextView>(R.id.tv1_SecondActivity)
        val btnToHome = findViewById<Button>(R.id.btnToHome)
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val user = intent.getSerializableExtra("user")
        Log.d(TAG,name!!)
        text1.text = "Mening ismim $name,\nMening yoshim $age da.\n${user.toString()}"

        val member = Member(2002,"Khushnud")
        btnToHome.setOnClickListener {
            val member = Member(2002,"Khushnud")
            goHome(member)
        }
    }
    fun goHome(member:Member){
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("result", member)
        setResult(RESULT_OK,intent)
        finish()
    }
}