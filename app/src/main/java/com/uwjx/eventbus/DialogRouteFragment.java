package com.uwjx.eventbus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

import com.uwjx.eventbus.event.RouteEvent;

import org.greenrobot.eventbus.EventBus;

public class DialogRouteFragment extends DialogFragment {
    DialogFragmentNavigator dialogFragmentNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogFragmentNavigator = new DialogFragmentNavigator(getActivity() , getParentFragmentManager());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("功能选择:");
        String[] items = new String[]{
                "加油功能",
                "串口功能",
                "其他功能"
        };
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
//                        dialogFragmentNavigator.
//                        NavHostFragment.findNavController(DialogRouteFragment.this)
//                                .navigate(R.id.action_DialogRouteFragment_to_HoseFragment);
                        EventBus.getDefault().post(new RouteEvent());
                        break;
                    case 1:
                        EventBus.getDefault().post(new RouteEvent());
                        break;
                    case 2:
                        EventBus.getDefault().post(new RouteEvent());
                        break;
                }
            }
        });
        return builder.create();
    }
}
