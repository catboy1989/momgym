package com.catboy.momgym.screens

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.catboy.momgym.R
import com.catboy.momgym.presenters.IPermissionView
import com.catboy.momgym.presenters.PermissionsActivityPresenter

class PermissionsActivity : AppCompatActivity(), IPermissionView {

    private var presenter: PermissionsActivityPresenter? = null
    private var overlayButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        presenter = PermissionsActivityPresenter(this)

        overlayButton = findViewById(R.id.permission_overlay_button)
        overlayButton!!.setOnClickListener { presenter!!.getOverlayPermission() }
    }

    override fun onResume() {
        super.onResume()
        presenter!!.checkPermissionsOnResume()
    }

    override fun setOverlayButtonVisibility(visibility: Int) {
        overlayButton!!.visibility = visibility
    }
}