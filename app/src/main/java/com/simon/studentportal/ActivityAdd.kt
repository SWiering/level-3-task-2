package com.simon.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_activity_add.*

const val EXTRA_WEBSITE = "EXTRA_WEBSITE"

class ActivityAdd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        addButton.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        val theTitle = titleInput.text.toString()
        val theUrl = urlInput.text.toString()

        if (theTitle.isNotBlank() && theUrl.isNotBlank() ) {
            val website = Website( theTitle, theUrl )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_WEBSITE, website)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The website cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}
