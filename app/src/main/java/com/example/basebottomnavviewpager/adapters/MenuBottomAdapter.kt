package com.example.basebottomnavviewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class MenuBottomAdapter(val fragments: ArrayList<Fragment>, fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    //arreglo de fragmentos

    //si son pocos recursos por cada fragments FragmentSpaceAdapter todos los fragment los carga en memoria

    //si requieren de muchos recursos es el fragmentStateAdapter destruye los fragmentos cuando no se estan ocupando

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]


}