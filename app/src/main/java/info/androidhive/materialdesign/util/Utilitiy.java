package info.androidhive.materialdesign.util;

import android.util.Log;
import org.greenrobot.eventbus.EventBus;

public class Utilitiy {

    // Burası Close Ettiğiniz Eventleri Loglamak için //  Kullanırsanız  log u ve burayı silin !
    // Sadece gösterilmek amacıyla yazılmıştır !
    private static final String eventText = "Close Event {0}";

    // Uygulama üzerinde close kontrollerinin  manuel  yapılabilmesi için daha karmaşık durumlarda manuel close gerekebilir !
    @SuppressWarnings("unchecked")
    public static <T> void  closeEvent(final T event){
        if(event!=null){
            final T closeEvet = (T) EventBus.getDefault().getStickyEvent(event.getClass());
            if (closeEvet != null) {
                Log.e("Remove Sticky", eventText.replace("{0}",closeEvet.getClass().getName()));
                EventBus.getDefault().removeStickyEvent(closeEvet);
            }
        }
    }

}
