package info.androidhive.materialdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.base.BaseEventBusFragment;
import info.androidhive.materialdesign.model.FriendsFragmentDestroyEvent;
import info.androidhive.materialdesign.model.MessagesFragmentDestroyEvent;
import info.androidhive.materialdesign.model.User;

public class HomeFragment extends BaseEventBusFragment {
    private TextView subTitleText ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getView(inflater.inflate(R.layout.fragment_home, container, false));
    }

    private View getView(View view){
        // Bu class altında 2 farklı olay olduğundan ötürü
        // ve  yapışkanlı bir şekilde data yollamadığım için destroyde
        // removeAll  çalıştırdım
        isRemoveAllStickyEvent = true;
        subTitleText = view.findViewById(R.id.subLabel);
        return view;
    }

                                // Ahmet YENEN //
    // Bu Olaylar Şöyle Örneklenmiştir ,bu tip te bir fragment yapısında  fragmentleri değiştirdiğinizde stackte tutulması gerekmiyor
    // Ve  Home  Sayfasına dönmeden önce diğer fragmentler de bir şeyler gerçekleştiriyorsunuz(işlem parçaları  operasyonlar vs.)
    // Ve elinizde tuttuğunuz datayı eğer home sayfasına (buraya) dönerse yollamak istiyorsunuz


    // Burdaki fonskiyonlar neden gri bir şekilde nerden  implement , extends ediliyor  yada nerden çıktı bunlar diyebilirsiniz :)
    // Event Bus Kütüphanesi(abone olunduktan sonra ,Notasyona Dikkat ! ) içinden  tetiklemesi yapılmaktadır Eğer Uygun olayın fonksiyonunu bulursa tetikler
    //https://www.javatpoint.com/custom-annotation

    // Yapışkan Üzerinden Atılan  Datalar //
    // Fragment ler Üzerinde geçiş yaparken bu fonksiyonların çalışma yapısını izleyin //

    @Subscribe(sticky = true) // FriendsFragment üzerinden Home Fragmentde Geldi ve bu geçiş  sırasında aktarmak istediğimiz data var !
    public void onEvent(FriendsFragmentDestroyEvent friendsFragmentDestroyEvent){
        final User user  = friendsFragmentDestroyEvent.getUser();
        Log.e("onEvent","Home Fragment -- Event == FriendsFragmentDestroyEvent");
        Log.e("Event Bus",user.getSurname());

    }

                                                           // UI data bastığımızdan dolayı  threadMode Main Aktif Ettik Ana Thread altında kilitlenme yaşamamak için !
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)// MessagesFragment üzerinden Home Fragmente Geldi ve bu geçiş sırasında aktarmak istediğimiz data var !
    public void onEvent(MessagesFragmentDestroyEvent messagesFragmentDestroyEvent){
        final User user  = messagesFragmentDestroyEvent.getUser();
        Log.e("onEvent","Home  Fragment -- Event == MessagesFragmentDestroyEvent");
        Log.e("Event Bus",user.getSurname());
        subTitleText.setText(user.getSurname());

    }

}
