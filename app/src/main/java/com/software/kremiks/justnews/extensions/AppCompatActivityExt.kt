package com.software.kremiks.justnews.extensions

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.addFragment(fragment: Fragment, containerId: Int) {
    supportFragmentManager.inTransaction { add(containerId, fragment) }
}

fun AppCompatActivity.addFragmentWithBackStack(fragment: Fragment, containerId: Int) {
    supportFragmentManager.inTransaction { add(containerId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int) {
    supportFragmentManager.inTransaction {
        replace(containerId, fragment)
    }
}