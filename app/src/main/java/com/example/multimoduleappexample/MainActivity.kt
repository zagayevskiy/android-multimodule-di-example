package com.example.multimoduleappexample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.DepsMap
import com.example.core.HasDependencies
import com.example.feature1.api.Feature1CaptionProvider
import com.example.feature1.api.Feature1Fragment
import com.example.feature2.api.Feature2Fragment
import com.example.feature3_no_ui.api.Notifier
import com.example.multimoduleappexample.di.DaggerMainActivityComponent
import com.example.multimoduleappexample.di.MainActivityScope
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasDependencies {

    @Inject
    override lateinit var depsMap: DepsMap

    @Inject
    lateinit var feature1CaptionProvider: Feature1CaptionProviderImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent.factory()
            .create(context = this)
            .inject(this)


        setContentView(R.layout.activity_main)

        setupFeature1()
        setupFeature2()
    }

    private fun setupFeature1() {
        feature1CaptionProvider.attach(findViewById<EditText>(R.id.feature1_caption))
        findViewById<View>(R.id.show_feature1).setOnClickListener {
            showFeatureFragment(Feature1Fragment())
        }
    }

    private fun setupFeature2() {
        findViewById<View>(R.id.show_feature2).setOnClickListener {
            showFeatureFragment(Feature2Fragment())
        }
    }

    private fun showFeatureFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.features_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

@MainActivityScope
class Feature1CaptionProviderImpl @Inject constructor(private val notifier: Notifier) : Feature1CaptionProvider, TextWatcher {
    private var prevGrabbedCaption: String? = null
    override var caption: String = ""
        get() {
            if (field == prevGrabbedCaption) {
                notifier.notify("Change caption in text field on top to see result", Notifier.Level.IMPORTANT)
            }

            prevGrabbedCaption = field
            return field
        }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        caption = s.toString()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    fun attach(view: TextView) {
        view.addTextChangedListener(this)
        caption = view.text.toString()
    }

}