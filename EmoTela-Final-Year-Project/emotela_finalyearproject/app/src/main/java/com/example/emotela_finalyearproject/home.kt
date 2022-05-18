package com.example.emotela_finalyearproject


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class home : Fragment() {
    var myFragment: View? = null
    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager = myFragment!!.findViewById(R.id.viewPager)
        tabLayout = myFragment!!.findViewById(R.id.tabLayout)
        return myFragment
    }

    //Call onActivity Create method
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewPager(viewPager)
        tabLayout!!.setupWithViewPager(viewPager)
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setUpViewPager(viewPager: ViewPager?) {
        val adapter = SectionPagerAdapter(childFragmentManager)

        adapter.addFragment(keywordfrag(), "KEYWORD")
        adapter.addFragment(textfrag(), "TEXT")
        adapter.addFragment(URLfrag(), "URL")
        viewPager!!.adapter = adapter
    }
    fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }

    companion object {
        val instance: home
            get() = home()
    }
}
