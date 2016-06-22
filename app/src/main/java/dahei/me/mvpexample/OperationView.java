package dahei.me.mvpexample;

import java.util.ArrayList;

import dahei.me.mvpexample.data.Phone;

/**
 * Created by su on 2016/6/22.
 */
public interface OperationView {

    void showCreatingPhone();


    void showPhoneCountChange();

    void showNoPhone();

    void showFactoryBusy();

    void showCreatedPhone();
}
