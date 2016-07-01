package dahei.me.mvpexample.tasks;

import java.util.ArrayList;

import dahei.me.mvpexample.data.Phone;

/**
 * Created by su on 2016/6/22.
 */
public interface TaskPresenter {
    void addPhone(Phone phone);

    void removePhone(Phone phone);

    void removePhone(int index);

    ArrayList<Phone> getPhonesList();

    void addRandomPhone();
}
