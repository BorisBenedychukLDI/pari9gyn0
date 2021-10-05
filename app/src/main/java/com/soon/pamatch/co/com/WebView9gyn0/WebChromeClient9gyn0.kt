package com.soon.pamatch.co.com.WebView9gyn0

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.soon.pamatch.co.com.*

class WebChromeClient9gyn0(private val activity9gyn0: AppCompatActivity) : WebChromeClient() {
    override fun onShowFileChooser(
        webView9gyn0: WebView?,
        filePathCallback9gyn0s: ValueCallback<Array<Uri>>?,
        fileChooserParams9gyn0: FileChooserParams?
    ): Boolean {
        activity9gyn0.checkPermissionsDexter9gyn0()
        filePathCallBack9gyn0 = filePathCallback9gyn0s
        val captureIntent9gyn0 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (captureIntent9gyn0.resolveActivity(activity9gyn0.packageManager) != null) {
            val providedFile9gyn0 = activity9gyn0.createTempFile9gyn0()
            uriView9gyn0 = FileProvider.getUriForFile(
                activity9gyn0,
                "${activity9gyn0.applicationContext.packageName}.provider",
                providedFile9gyn0
            )
            captureIntent9gyn0.run {
                putExtra(MediaStore.EXTRA_OUTPUT, uriView9gyn0)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            val actionIntent9gyn0 = Intent(Intent.ACTION_GET_CONTENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            val intentChooser9gyn0 = Intent(Intent.ACTION_CHOOSER).apply {
                putExtra(Intent.EXTRA_INTENT, captureIntent9gyn0)
                putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(actionIntent9gyn0) )
            }
            activity9gyn0.startActivityForResult(intentChooser9gyn0, REQUEST_CODE_9gyn0)
            return true

        }
        return super.onShowFileChooser(webView9gyn0, filePathCallback9gyn0s, fileChooserParams9gyn0)
    }
}