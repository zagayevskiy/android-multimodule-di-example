package com.example.feature2.api

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.findDependencies
import com.example.feature2.R
import com.example.feature2.internal.di.DaggerFeature2Component
import javax.inject.Inject

class Feature2Fragment : Fragment() {

    @Inject
    internal lateinit var otherFeatureFragmentProvider: Feature2OtherFeatureFragmentProvider

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFeature2Component.factory()
            .create(findDependencies())
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feature2_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val root = view as ViewGroup

        root.findViewById<View>(R.id.feature2_show_feature1).setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(R.id.feature2_other_features_container, otherFeatureFragmentProvider.otherFeatureFragment())
                .addToBackStack("feature 2")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}