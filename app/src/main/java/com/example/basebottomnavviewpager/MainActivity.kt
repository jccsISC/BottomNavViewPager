package com.example.basebottomnavviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.basebottomnavviewpager.adapters.MenuBottomAdapter
import com.example.basebottomnavviewpager.databinding.ActivityMainBinding
import com.example.basebottomnavviewpager.fragments.HelpFragment
import com.example.basebottomnavviewpager.fragments.HomeFragment
import com.example.basebottomnavviewpager.fragments.PerfilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var previewMenuItem: MenuItem
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setSupportActionBar(mainBinding.toolbar)

        mainBinding.apply {
            val menuAdapter = MenuBottomAdapter(initiFragments(), supportFragmentManager) //inicializando adapter
            viewPager.adapter = menuAdapter

            bottomNav.setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.homeFragment -> {
                        viewPager.currentItem = 0
                    }
                    R.id.helpFragment -> {
                        viewPager.currentItem = 1
                    }
                    R.id.perfilFragment -> {
                        viewPager.currentItem = 2
                    }
                }

                true
            }

            //sincronizar el paginado con el botttom
            viewPager.addOnPageChangeListener( object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    //Deshabilitar los elementos anteriores
                    if (::previewMenuItem.isInitialized) {
                        previewMenuItem.isChecked = false
                    }else {
                        bottomNav.menu.getItem(0).isChecked = false
                    }

                    bottomNav.menu.getItem(position).isChecked = true
                    previewMenuItem = bottomNav.menu.getItem(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                }

            })
        }

    }

    private fun initiFragments(): ArrayList<Fragment> {
        return arrayListOf(
            HomeFragment.newInstance(),
            HelpFragment.newInstance(),
            PerfilFragment.newInstance()
        )
    }
}