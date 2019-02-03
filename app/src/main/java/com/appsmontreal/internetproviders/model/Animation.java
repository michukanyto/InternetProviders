package com.appsmontreal.internetproviders.model;

import android.widget.Button;

public class Animation {
    public void buttonRotateXanimation(Button btn){
        btn.animate().rotationX(360).setDuration(400);
    }

    public void buttonRotateYanimation(Button btn){
        btn.animate().rotationY(360).setDuration(400);
    }
}
