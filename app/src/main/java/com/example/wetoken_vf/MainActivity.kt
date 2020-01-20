package com.example.wetoken_vf

import `in`.mayanknagwanshi.countrypicker.CountrySelectActivity
import `in`.mayanknagwanshi.countrypicker.bean.CountryData
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.denden.changeLang
import com.example.wetoken_vf.mobile_connect.ConnectFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       setSupportActionBar(toolbar)


      /*
        }


                         */
        val acceuilFragment = ConnectFragment()
        val fragManager = supportFragmentManager
        val transac = fragManager.beginTransaction()
        transac.replace(R.id.fragmnt, acceuilFragment)
        transac.addToBackStack(null)
        transac.commit()



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            //R.id.action_settings -> true
            R.id.English -> {
                println(Locale.getDefault().language + "---lnaa")
                var lcal = Locale("en")
                Locale.setDefault(lcal)
                var cnf = Configuration(this.resources?.configuration)
                //var cn       f = Configuration()
                cnf.setLocale(lcal)
                // activity?.baseContext?.createConfigurationContext(cnf)
                this.createConfigurationContext(cnf)
                changeLang.saveLang("en",this)
                this.recreate()
                return true
            }
            R.id.French -> {
                println("test")


                    println(Locale.getDefault().language + "---lnaa")
                    var lcal = Locale("fr")
                    Locale.setDefault(lcal)
                    var cnf = Configuration(this.resources?.configuration)
                    //var cn       f = Configuration()
                    cnf.setLocale(lcal)
                    // activity?.baseContext?.createConfigurationContext(cnf)
                    this.createConfigurationContext(cnf)
                    changeLang.saveLang("fr",this)
                    this.recreate()

                return true
            }
            R.id.Arab -> {
                println(Locale.getDefault().language + "---lnaa")
                var lcal = Locale("ar")
                Locale.setDefault(lcal)
                var cnf = Configuration(this.resources?.configuration)
                //var cn       f = Configuration()
                cnf.setLocale(lcal)
                // activity?.baseContext?.createConfigurationContext(cnf)
                this.createConfigurationContext(cnf)
                changeLang.saveLang("ar",this)
                this.recreate()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(changeLang.attach(newBase!!,changeLang.getLang(newBase)))
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        changeLang.attach(this,"en")
    }




/*
   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)
       if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
           val countryData = data!!.getSerializableExtra(CountrySelectActivity.RESULT_COUNTRY_DATA) as CountryData
           println(countryData.countryFlag)
           img.setImageResource(countryData.countryFlag)
           edittxtPays.setText(countryData.countryISD)
       }
   }*/
}