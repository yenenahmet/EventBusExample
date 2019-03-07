package info.androidhive.materialdesign.base;

import android.support.v7.app.AppCompatActivity;
import org.greenrobot.eventbus.EventBus;

import info.androidhive.materialdesign.util.Utilitiy;

/**
 * Created by ahmet.yenen on 2/25/2019.
 */

public class BaseEventBusActivity<T> extends AppCompatActivity {

    protected boolean isRemoveAllStickyEvent = false;
    private T event = null;

    // ÖnBelleğe alınan Datanın Otomatik ondestroyda Silinmesi için
    protected void setCloseEvent(final T closeEvent) {
        this.event = closeEvent;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRemoveAllStickyEvent) {
            EventBus.getDefault().removeAllStickyEvents();
        } else {
            Utilitiy.closeEvent(event);
        }
        event = null;
    }

}
