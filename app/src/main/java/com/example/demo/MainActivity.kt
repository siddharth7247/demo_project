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
import WebViewDemo.WebViewDemoActivity
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.google.android.material.button.MaterialButtonToggleGroup
import dialogDemo.DialogDemo
import imageLoadingLibrary.GlideDemoActivity
import roomDataBaseDemo.RoomDatabaseDemoActivity


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
    lateinit var btnWebView : Button
    lateinit var btnImageLoadingLibrary : Button
    lateinit var btnRoomDatabse : Button
    lateinit var btnRetrofit : Button

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
        btnWebView = findViewById(R.id.webViewDemo)
        btnImageLoadingLibrary = findViewById(R.id.imageLoadingLibraryDemo)
        btnRoomDatabse = findViewById(R.id.roomDatabseDemo)
        btnRetrofit = findViewById(R.id.RetrofitJSONDemo)


        btnIntent.setOnClickListener(){
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnConstaint.setOnClickListener(){
            intent = Intent(this, ConstraintLayoutDemo::class.java)
            startActivity(intent)
        }

        btnViews.setOnClickListener(){
            intent = Intent(this,ViewsDemoActivity::class.java)
            startActivity(intent)
        }
        btnDrawable.setOnClickListener(){
            intent = Intent(this,DrawableDemo::class.java)
            startActivity(intent)
        }
        btnViewPager.setOnClickListener(){
            intent = Intent(this,ViewPagerDemo::class.java)
            startActivity(intent)
        }
        btnListView.setOnClickListener(){
            intent = Intent(this,ListViewDemo::class.java)
            startActivity(intent)
        }
        btnRecyclerView.setOnClickListener(){
            intent = Intent(applicationContext,RecyclerViewDemo::class.java)
            startActivity(intent)
        }
        btnCordinator.setOnClickListener(){
            intent = Intent(this,CordinatorLayoutDemo::class.java)
            startActivity(intent)
        }
        btnSnackbar.setOnClickListener(){
            intent = Intent(this,SnackBarDemo::class.java)
            startActivity(intent)
        }
        btnFonts.setOnClickListener(){
            intent = Intent(this,FontDemo::class.java)
            startActivity(intent)
        }
        btnMenu.setOnClickListener(){
            intent = Intent(this, MenuDemo::class.java)
            startActivity(intent)
        }
        btnDialog.setOnClickListener(){
            intent = Intent(this, DialogDemo::class.java)
            startActivity(intent)
        }
        btnReturnResultDemo.setOnClickListener(){
            intent = Intent(this, ReturnResultDemo::class.java)
            startActivity(intent)
        }
        btnFragment.setOnClickListener{
            intent = Intent(this,FragmentDemo::class.java)
            startActivity(intent)
        }
        btnPermission.setOnClickListener{
            intent = Intent(this,PermissionDemo::class.java)
            startActivity(intent)
        }
        btnSharedPrefrences.setOnClickListener{
            intent = Intent(this,IndexActivity::class.java)
            startActivity(intent)
        }
        btnWebView.setOnClickListener{
            intent = Intent(this,WebViewDemo.IndexActivity::class.java)
            startActivity(intent)
        }
        btnImageLoadingLibrary.setOnClickListener{
           intent = Intent(this,GlideDemoActivity::class.java)
           startActivity(intent)
       }
        btnRoomDatabse.setOnClickListener{
            intent = Intent(this, RoomDatabaseDemoActivity::class.java)
            startActivity(intent)
        }
        btnRetrofit.setOnClickListener{
            intent = Intent(this,RetrofitAndJSONDemo.UserDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}

