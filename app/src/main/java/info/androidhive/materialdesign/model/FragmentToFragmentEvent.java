package info.androidhive.materialdesign.model;

/**
 * Created by ahmet.yenen on 2/20/2019.
 */

public class FragmentToFragmentEvent {
    private final User user;

    public User getUser() {
        return user;
    }

    public FragmentToFragmentEvent(final User user) {
        this.user = user;
    }
}
