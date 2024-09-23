package com.example.demo

import ConstraintLayoutDemo.ConstraintLayoutDemo
import CordinatorLayoutDemo.CordinatorLayoutDemo
import DrawableDemo.DrawableDemo
import FontsDemo.FontDemo
import FragmentDemo.FragmentDemo
import FragmentDemo.FragmentDemo1
import IntentDemo.LoginActivity
import ListViewDemo.ListViewDemo
import MenuDemo.MenuDemo
import PermissionDemo.PermissionDemo
import RecyclerViewDemo.RecyclerViewDemo
import RecyclerViewDemo2.RecyclerViewDemo2
import ReturnResultDemo.ReturnResultDemo
import SharedPrefrencesDemo.EncryptedSharedPreferencesActivity
import SharedPrefrencesDemo.IndexActivity
import SharedPrefrencesDemo.UserDetailsActivity
import SnackBarDemo.SnackBarDemo
import ViewPagerDemo.ViewPagerDemo
import ViewsDemo.ViewsDemoActivity
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.google.android.material.button.MaterialButtonToggleGroup
import dialogDemo.DialogDemo


class MainActivity : AppCompatActivity() {

    lateinit var btnIntent : Button
    lateinit var btnConstaint : Button
    lateinit var btnViews : Button
    lateinit var btnDrawable : Button
    lateinit var btnViewPager : Button
    lateinit var btnListView : Button
    lateinit var btnRecyclerView : Button
    lateinit var btnCordinator : Button
    lateinit var btnSnackbar : Button
    lateinit var btnFonts : Button
    lateinit var btnMenu : Button
    lateinit var btnDialog : Button
    lateinit var btnReturnResultDemo : Button
    lateinit var btnFragment : Button
    lateinit var btnPermission : Button
    lateinit var btnSharedPrefrences : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        btnIntent = findViewById<Button>(R.id.intentDemo)
        btnConstaint = findViewById<Button>(R.id.constraintLayoutDemo)
        btnViews = findViewById<Button>(R.id.viewsDemo)
        btnDrawable = findViewById<Button>(R.id.drawableDemo)
        btnViewPager = findViewById(R.id.viewPagerDemo)
        btnListView = findViewById(R.id.listViewDemo)
        btnRecyclerView = findViewById(R.id.recyclerViewDemo)
        btnCordinator = findViewById(R.id.cordinatorLayoutDemo)
        btnSnackbar = findViewById(R.id.snackBarDemo)
        btnFonts = findViewById(R.id.fontsDemo)
        btnMenu = findViewById(R.id.menuDemo)
        btnDialog = findViewById(R.id.dialogDemo)
        btnReturnResultDemo = findViewById(R.id.returnResultDemo)
        btnFragment = findViewById(R.id.fragmenttDemo)
        btnPermission = findViewById(R.id.permissionDemo)
        btnSharedPrefrences = findViewById(R.id.sharedPrefrencesDemo)


        btnIntent.setOnClickListener(){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnConstaint.setOnClickListener(){
            intent = Intent(applicationContext, ConstraintLayoutDemo::class.java)
            startActivity(intent)
        }

        btnViews.setOnClickListener(){
            intent = Intent(applicationContext,ViewsDemoActivity::class.java)
            startActivity(intent)
        }
        btnDrawable.setOnClickListener(){
            intent = Intent(applicationContext,DrawableDemo::class.java)
            startActivity(intent)
        }
        btnViewPager.setOnClickListener(){
            intent = Intent(applicationContext,ViewPagerDemo::class.java)
            startActivity(intent)
        }
        btnListView.setOnClickListener(){
            intent = Intent(applicationContext,ListViewDemo::class.java)
            startActivity(intent)
        }
        btnRecyclerView.setOnClickListener(){
            intent = Intent(applicationContext,RecyclerViewDemo::class.java)
            startActivity(intent)
        }
        btnCordinator.setOnClickListener(){
            intent = Intent(applicationContext,CordinatorLayoutDemo::class.java)
            startActivity(intent)
        }
        btnSnackbar.setOnClickListener(){
            intent = Intent(applicationContext,SnackBarDemo::class.java)
            startActivity(intent)
        }
        btnFonts.setOnClickListener(){
            intent = Intent(applicationContext,FontDemo::class.java)
            startActivity(intent)
        }
        btnMenu.setOnClickListener(){
            intent = Intent(applicationContext, MenuDemo::class.java)
            startActivity(intent)
        }
        btnDialog.setOnClickListener(){
            intent = Intent(applicationContext, DialogDemo::class.java)
            startActivity(intent)
        }
        btnReturnResultDemo.setOnClickListener(){
            intent = Intent(applicationContext, ReturnResultDemo::class.java)
            startActivity(intent)
        }
        btnFragment.setOnClickListener{
            intent = Intent(applicationContext,FragmentDemo::class.java)
            startActivity(intent)
        }
        btnPermission.setOnClickListener{
            intent = Intent(applicationContext,PermissionDemo::class.java)
            startActivity(intent)
        }
        btnSharedPrefrences.setOnClickListener{
            intent = Intent(applicationContext,IndexActivity::class.java)
            startActivity(intent)
        }

    }
}

