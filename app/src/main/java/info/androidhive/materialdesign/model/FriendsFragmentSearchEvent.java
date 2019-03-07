package info.androidhive.materialdesign.model;

/**
 * Created by ahmet.yenen on 3/4/2019.
 */

public class FriendsFragmentSearchEvent {
    //  Farklı Farklı Class Açmamızın nedeni Her olayın birbirinden farklı
    // Gerçekleşiyor olması // Fonksiyonlar(Parametre) da Aldıkları class adlarına göre çalışmakta
    // olduğuna Dikkat Edilmeli
    private final User user;

    public User getUser() {
        return user;
    }

    public FriendsFragmentSearchEvent(final User user) {
        this.user = user;
    }
}
