package info.androidhive.materialdesign.model;

public class FriendsFragmentDestroyEvent {


    private final User user;

    public User getUser() {
        return user;
    }

    public FriendsFragmentDestroyEvent(final User user) {
        this.user = user;
    }
}
