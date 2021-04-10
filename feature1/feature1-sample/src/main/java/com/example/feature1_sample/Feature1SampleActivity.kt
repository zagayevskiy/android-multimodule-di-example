package com.example.feature1_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.core.DepsMap
import com.example.core.HasDependencies
import com.example.feature1.api.Feature1CaptionProvider
import com.example.feature1.api.Feature1Dependencies
import com.example.feature1.api.Feature1Fragment
import com.example.feature1.api.Feature1Logger

class Feature1SampleActivity : AppCompatActivity(), HasDependencies {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature1_sample)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, Feature1Fragment())
                .commit()
        }
    }

    override val depsMap: DepsMap = mapOf(
        Feature1Dependencies::class.java to object : Feature1Dependencies {
            override val feature1Logger = object : Feature1Logger {
                override fun log(text: String) {
                    Log.d("sample", text)
                }
            }
            override val feature1CaptionProvider = object : Feature1CaptionProvider {
                private var index = 0
                override val caption
                    get() = "Sample #$index".also { ++index }
            }
        }
    )
}