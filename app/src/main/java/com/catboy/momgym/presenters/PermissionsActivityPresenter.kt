package com.catboy.momgym.presenters

import com.catboy.momgym.usecases.permissions.GetOverlayPermission
import com.catboy.momgym.usecases.permissions.IsOverlayPermission
import com.catboy.momgym.usecases.permissions.IsPermissionsDenied
import com.catboy.momgym.usecases.startactivities.StartMainActivity
import com.catboy.momgym.util.IsVisible


class PermissionsActivityPresenter(private val view: IPermissionView) {
    private val isPermissionsDenied = IsPermissionsDenied(view.getApplicationContext()!!)
    private val startMainActivity = StartMainActivity(view.getApplicationContext()!!)
    private val isOverlayPermission = IsOverlayPermission(view.getApplicationContext()!!)
    private val isVisible = IsVisible()
    private val getOverlayPermission = GetOverlayPermission(view.getApplicationContext()!!)

    fun checkPermissionsOnResume() {
        if (!isPermissionsDenied.execute()) {
            startMainActivity.execute(!isPermissionsDenied.execute())
        } else {
            view.setOverlayButtonVisibility(isVisible.execute(!isOverlayPermission.execute()))
        }
    }

    fun getOverlayPermission() {
        getOverlayPermission.execute()
    }
}