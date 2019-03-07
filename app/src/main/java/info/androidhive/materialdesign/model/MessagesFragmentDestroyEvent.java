package info.androidhive.materialdesign.model;

public class MessagesFragmentDestroyEvent {
    //  Farklı Farklı Class Açmamızın nedeni Her olayın birbirinden farklı
    // Gerçekleşiyor olması // Fonksiyonlar(Parametre) da Aldıkları class adlarına göre çalışmakta
    // olduğuna Dikkat Edilmeli
    private final User user;

    public User getUser() {
        return user;
    }

    public MessagesFragmentDestroyEvent(final User user) {
        this.user = user;
    }
}
