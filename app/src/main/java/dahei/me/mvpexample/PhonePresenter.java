package dahei.me.mvpexample;

import dahei.me.mvpexample.data.Phone;
import dahei.me.mvpexample.data.PhoneFactory;
import dahei.me.mvpexample.tasks.TaskPresenter;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by su on 2016/6/22.
 */
public class PhonePresenter implements TaskPresenter{

    private final PhoneFactory phoneFactory;
    private final OperationView operationView;

    private static final long createPhoneTime = 2000;
    private static final int msgWhat = 0x102;


    public PhonePresenter( @NonNull OperationView operationView) {
        this.phoneFactory = new PhoneFactory();
        this.operationView = operationView;
    }


    @Override
    public void addPhone(Phone phone) {
        operationView.showPhoneCountChange();
        if (mHandler.hasMessages(msgWhat)) {
            operationView.showFactoryBusy();
            return;
        }
        Message message = new Message();
        message.what = msgWhat;
        message.obj = phone;
        mHandler.sendMessageDelayed(message, createPhoneTime);
        operationView.showCreatingPhone();
    }

    @Override
    public void removePhone(int index) {
        phoneFactory.removePhone(index);
        if (phoneFactory.getPhoneCounts() <= 0) {
            operationView.showNoPhone();
        }
        operationView.showPhoneCountChange();
    }

    public ArrayList<Phone> getPhonesList() {
        return phoneFactory.getPhonesList();
    }

    @Override
    public void addRandomPhone() {
        addPhone(new Phone("iphone", 4000 + new Random().nextInt(1000)));
    }

    @Override
    public void removePhone(Phone phone) {

    }

    public ArrayList<Phone> getPhones() {
        ArrayList<Phone> phones = phoneFactory.getPhonesList();
        if (phones.isEmpty()) {
            operationView.showNoPhone();
        }
        return phones;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            phoneFactory.addPhone((Phone)msg.obj);
            operationView.showCreatedPhone();
            operationView.showPhoneCountChange();
            operationView.hideNoPhone();
        }
    };
}
