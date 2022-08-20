package uz.exemple.less4kotlinapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import uz.exemple.less4kotlinapp.model.User

class MainActivity : AppCompatActivity() {
    lateinit var tv_home:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var secondPageLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val member = data!!.getSerializableExtra("result")
            tv_home.setText(member.toString())
        }
    }

    fun initViews() {
        tv_home = findViewById<TextView>(R.id.tv_home)
        val btnNextPage = findViewById<Button>(R.id.btnNextPage)

        btnNextPage.setOnClickListener {
            val user = User("Xushnud",  25)
            openNext(user)
        }
    }

    fun openNext(user: User) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name","Xushnud")
        intent.putExtra("age","32")
        intent.putExtra("user",user)
        //startActivity(intent)
        secondPageLauncher.launch(intent)
    }
}