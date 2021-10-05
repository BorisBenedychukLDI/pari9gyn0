package com.soon.pamatch.co.com

import android.Manifest
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.ValueCallback
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

var key9gyn0: String? = null
var sub29gyn0: String? = null
var sub39gyn0: String? = null
var adGroup9gyn0: String? = null
var adSet29gyn0: String? = null
var afChannel9gyn0: String? = null
var mediaSource9gyn0: String? = null
var AID9gyn0: String? = null
var APPSFLYER_UID9gyn0: String? = null
var status9gyn0: String? = null

var fbBlackValue9gyn0: String? = null
var fbDefaultValue9gyn0: String? = null
var fbWhiteValue9gyn0: String? = null

var filePathCallBack9gyn0: ValueCallback<Array<Uri>>? = null
var uriView9gyn0: Uri = Uri.EMPTY

var isShown9gyn0 = false

fun Context.createTempFile9gyn0 (): File  {
    val date9gyn0 = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        .format(Date())
    val fileDir9gyn0 = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile("TMP${date9gyn0}_9gyn0", ".jpg", fileDir9gyn0)
}

fun Context.checkPermissionsDexter9gyn0 () {
    Dexter.withContext(this)
        .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        .withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {

            }
        }).check()
}