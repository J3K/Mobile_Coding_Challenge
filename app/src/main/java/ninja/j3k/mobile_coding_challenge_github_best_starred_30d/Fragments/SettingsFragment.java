package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.R;

/**
 * Created by J3K on 16.05.2018.
 */

public class SettingsFragment  extends Fragment{
        public static SettingsFragment newInstance() {
            SettingsFragment fragment = new SettingsFragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_settings_main, container, false);
        }
}