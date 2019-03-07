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
import info.androidhive.materialdesign.model.FriendsFragmentSearchEvent;
import info.androidhive.materialdesign.model.MessagesFragmentDestroyEvent;
import info.androidhive.materialdesign.model.User;

/**
 * Created by Ravi on 29/07/15.
 */
public class MessagesFragment extends BaseEventBusFragment<FragmentToFragmentEvent> {

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getView(inflater.inflate(R.layout.fragment_messages, container, false));
    }

    private View getView(final View view){
        return view;
    }

    @Subscribe (sticky = true)
    public void onEvent(FragmentToFragmentEvent fragmentToFragmentEvent){
        final User user  = fragmentToFragmentEvent.getUser();
        setAutoCloseEvent(fragmentToFragmentEvent);
        Log.e("onEvent","Message Fragment ");
        Log.e("Event Bus",user.getSurname());

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        final User user = new User("Ahmet", "YENEN -- Event : MessagesFragmentDestroy -- Go Home ", "Bilgisayar Mühendisi", 25);
        EventBus.getDefault().postSticky(new MessagesFragmentDestroyEvent(user));
    }
}
