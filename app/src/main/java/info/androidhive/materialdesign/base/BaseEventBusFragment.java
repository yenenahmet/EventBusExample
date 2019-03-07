package info.androidhive.materialdesign.base;

import android.support.v4.app.Fragment;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

import info.androidhive.materialdesign.util.Utilitiy;

/**
 * Created by ahmet.yenen on 2/25/2019.
 */
public class BaseEventBusFragment<T> extends Fragment {

    // Bir Fragment Üzerinde birden fazla yapışkanlı Event Çalışacaksa
    // Aktif Edildiğinde Ondestroyde Tüm Eventleri Siler !
    protected boolean isRemoveAllStickyEvent = false;
    private T event = null;

    protected void setAutoCloseEvent(final T closeEvent) {
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


    // Bu Kısım OnPause veya kullanmakta istediğiniz datalarla işiniz bittiği yere koyup bu class ı istediğiniz
    // Şekilde  kurabilirsiniz

    @SuppressWarnings("unchecked")
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRemoveAllStickyEvent) {
            EventBus.getDefault().removeAllStickyEvents();
            Log.e("Remove Sticky", "Close Event ALL");
        } else {
            Utilitiy.closeEvent(event);
        }
        event = null;
    }
}
