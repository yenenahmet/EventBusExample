package info.androidhive.materialdesign.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.base.BaseEventBusFragment;
import info.androidhive.materialdesign.model.FragmentToFragmentEvent;
import info.androidhive.materialdesign.model.FriendsFragmentDestroyEvent;
import info.androidhive.materialdesign.model.FriendsFragmentSearchEvent;
import info.androidhive.materialdesign.model.User;

/**
 * Created by Ravi on 29/07/15.
 */
public class FriendsFragment extends BaseEventBusFragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getView(inflater.inflate(R.layout.fragment_friends, container, false));
    }


    private View getView(View view){
        return view;
    }

    @Subscribe  // Yapışkan olmadan Post edilen Data  !
    public void onEvent(FriendsFragmentSearchEvent friendsFragmentSearchEvent){
        final User user  = friendsFragmentSearchEvent.getUser();
        Log.e("onEvent","Friends Fragment ");
        Log.e("Event Bus",user.getSurname());

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        final User user = new User("Ahmet", "YENEN -- Friends Destroy- Go HOME", "Bilgisayar Mühendisi", 25);
        EventBus.getDefault().postSticky(new FriendsFragmentDestroyEvent(user));
        final User userMessage = new User("Ahmet", "YENEN -- Friends Destroy- Go Messages Fragment", "Bilgisayar Mühendisi", 25);
        EventBus.getDefault().postSticky(new FragmentToFragmentEvent(userMessage));
    }
}
